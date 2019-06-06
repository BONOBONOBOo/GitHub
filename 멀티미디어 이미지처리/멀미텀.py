import cv2
import numpy as np
import random
import tkinter as tk
from tkinter import filedialog



 
global img,dst,tmp,gray,weight

global selectRows,selectCols,imageRows,imageCols

global countArray

global threshold1,threshold2


defaultX = 0
defaultY = 0

count = 0

weight = np.uint8([20])
colortemp = 20

def nothing(x):
    pass

def mirroring():#뒤집기 함수
    global dst,tmp,count
    rows,cols=tmp.shape[0],tmp.shape[1]

    for i in range(0,cols):
        for j in range(0,rows):
            dst[j,cols-i-1]=tmp[j,i]

    count += 1
    countArray[count] = dst
    tmp=dst.copy()
    
def blur():#블러 함수

    global dst,tmp,count
    size = 5
    kernel = np.ones((size, size), np.float32) / (size * size)
    dst = cv2.filter2D(tmp, -2, kernel)
    count += 1
    countArray[count] = dst
    tmp=dst.copy()

def gray(): # 흑백
    
    global dst,tmp,count
    dst = cv2.cvtColor(tmp,cv2.COLOR_BGR2GRAY)
    
    print(dst.shape[:])
    count += 1
    countArray[count] = dst
    tmp=dst.copy()
    
def canny(): # 테두리
    
    global dst,tmp,count
    
    dst = cv2.Canny(tmp, 175, 350)

    count += 1
    countArray[count] = dst
    tmp=dst.copy()
    
def graysaltpepper():#흑백하고 노이즈 넣기
    global imageRows,imageClos,dst,img,tmp,count

    dst = cv2.cvtColor(tmp,cv2.COLOR_BGR2GRAY)
    how = 2
    k = how
    
    for i in range(0,imageRows-1):
        pp = sorted(random.sample(range(0,imageCols-1),how))
        for j in range(0,how-1):
            dst[i,pp[j]]=0
    count += 1
    countArray[count] = dst
    tmp=dst.copy()
    
def cut():#자르기
    global dst,tmp,count
    cv2.namedWindow('cut')
    cv2.setMouseCallback('cut',cutClick)
    cv2.imshow('cut',dst)
    


def histogram(): # 평활화

    global tmp,dst,count

    rows,cols=tmp.shape[0:2]
    
    ch=3

    try:
        r,g,b=cv2.split(tmp)

    except ValueError:

        pass
        print("gray scale\n")
        ch = 1

    if ch == 3:

        b,g,r = cv2.split(tmp)
        
        barray = [[0]*3 for i in range(256)]
        garray = [[0]*3 for i in range(256)]
        rarray = [[0]*3 for i in range(256)]

        for i in range(rows):
            for j in range(cols):
                barray[b[i][j]][0]  += 1
                garray[g[i][j]][0]  += 1
                rarray[r[i][j]][0]  += 1
                
        barray[0][1]=barray[0][0]
        barray[0][2]=round(barray[0][1]*255/(rows*cols))

        garray[0][1]=garray[0][0]
        garray[0][2]=round(garray[0][1]*255/(rows*cols))

        rarray[0][1]=rarray[0][0]
        rarray[0][2]=round(rarray[0][1]*255/(rows*cols))
                   
        for i in range(255):
            barray[i+1][1]=barray[i][1]+barray[i+1][0]
            barray[i+1][2]=round(barray[i+1][1]*255/(rows*cols))

            garray[i+1][1]=garray[i][1]+garray[i+1][0]
            garray[i+1][2]=round(garray[i+1][1]*255/(rows*cols))

            rarray[i+1][1]=rarray[i][1]+rarray[i+1][0]
            rarray[i+1][2]=round(rarray[i+1][1]*255/(rows*cols))
            
        for i in range(rows):
            for j in range(cols):
                b[i][j]=barray[b[i][j]][2]
                g[i][j]=garray[g[i][j]][2]
                r[i][j]=rarray[r[i][j]][2]    


        dst = cv2.merge((b,g,r))
        
    elif ch == 1:
        print('gray')
        dst = cv2.equalizeHist(tmp)
        
    
    count += 1
    countArray[count] = dst
    tmp=dst.copy()
    
def addColortemp():#색온도 +
    global dst,tmp,count,colortemp
    dst = cv2.add(tmp,colortemp)

    count += 1
    countArray[count] = dst
    tmp=dst.copy()
    
def subColortemp():#색온도-
    global dst,tmp,count
    dst = cv2.add(tmp,-colortemp)

    count += 1
    countArray[count] = dst
    tmp=dst.copy()
def addBright():#밝기+
    global dst,tmp,count,weight

    b,g,r = cv2.split(tmp)

    for i in range(dst.shape[0]):
        for j in range(dst.shape[1]):
            r[i][j]=cv2.add(int(r[i][j]),weight)
            g[i][j]=cv2.add(int(g[i][j]),weight)
            b[i][j]=cv2.add(int(b[i][j]),weight)

    dst=cv2.merge((b,g,r))
    
    count += 1
    countArray[count] = dst
    tmp=dst.copy()
    
def subBright():#밝기-
    global dst,tmp,count,weight

    b,g,r = cv2.split(tmp)

    for i in range(dst.shape[0]):
        for j in range(dst.shape[1]):
            r[i][j]=cv2.subtract(int(r[i][j]),weight)
            g[i][j]=cv2.subtract(int(g[i][j]),weight)
            b[i][j]=cv2.subtract(int(b[i][j]),weight)

    dst=cv2.merge((b,g,r))
    
    count += 1
    countArray[count] = dst
    tmp=dst.copy()
    




#-----------------키보드---------------------
def undo():
    global count,countArray,dst,tmp
    if count >0:
        count-=1
        dst=countArray[count].copy()
        tmp=countArray[count].copy()
        print(count)
    
def redo():
    global count,countArray,dst,tmp
    count+=1
    dst=countArray[count].copy()
    tmp=countArray[count].copy()
    print(count)

def seelist():
    for i in range(0,5):        
        cv2.imshow(list[i],countArray[i])
    
def listDestroy():
    for i in range(0,5):            
        cv2.destroyWindow(list[i])
def save():
    global dst
    cv2.imwrite(input("파일명을 확장자까지 입력하세요.\n"), dst)
    print('저정완료.')
    
def rotation():
    global dst,tmp
    
    rows,cols = tmp.shape[:2] 
    dst = np.zeros((cols,rows,3),np.uint8)


    for j in range(rows):
        for i in range(cols):
            dst[i,rows-j-1]=tmp[j,i]

  
    tmp =dst.copy()

    

def Onclick(event,x,y,flags,param):#마웃스 클릭 이벤트
    global ix,iy,Smirror,Sblur,img,dst

    
    
    if event == cv2.EVENT_LBUTTONDOWN:#마우스 왼쪽클릭
         
        if x<selectCols/2:
            if y<(selectRows/5):#반전
                mirroring()
                print('반전')
            elif y>(selectRows*1/5) and y<(2/5*selectRows):#흑백
                gray()
                print('흑백')
            elif y>(selectRows*2/5) and y<(3/5*selectRows):#자르기
                cut()
                print('자르기')
            elif y>(selectRows*3/5) and y<(4/5*selectRows):#색온도+
                addColortemp()
                print('색온도+')                
            elif y>(selectRows*4/5) and y<(5/5*selectRows):#밝기+
                addBright()
                print('밝기+')                

        elif x>selectCols/2:
            if y<(selectRows/5):#평활화
                histogram()
                print('평활화')
            elif y>(selectRows*1/5) and y<(2/5*selectRows):#케니
                canny()
                print('케니')
            elif y>(selectRows*2/5) and y<(3/5*selectRows):#유화
                blur()
                print('유화')
            elif y>(selectRows*3/5) and y<(4/5*selectRows):#색온도-
                subColortemp()
                print('색온도-')
            elif y>(selectRows*4/5) and y<(5/5*selectRows):#밝기-
                subBright()
                print('밝기-')
            
                
    
       
def cutClick(event,x,y,flags,param):#자르기에서 사용할 클릭 함수

    global ix,iy,fx,fy,img,dst,copy,count
    
    if event == cv2.EVENT_LBUTTONDOWN:
        ix,iy=y,x#x,y반전
    elif event == cv2.EVENT_LBUTTONUP:
        fx,fy=y,x


        if fx>ix and fy>iy:#어디로 드래그해도 오류가안나게하는 코드
            copy=dst[ix:fx,iy:fy]
        elif fx<ix and fy>iy:
            copy=dst[fx:ix,iy:fy]
        elif fx<ix and fy<iy:
            copy=dst[fx:ix,fy:iy]
        elif fx>ix and fy<iy:
            copy=dst[ix:fx,fy:iy]

        
        dst=copy.copy()
        
        cv2.imshow('dst',dst)
        
        count += 1
        countArray[count] = dst
        tmp=dst.copy()
        
        cv2.destroyWindow('cut')
        
        
root = tk.Tk()
root.withdraw()

file_path = tk.filedialog.askopenfilename()
filename=file_path.split('/')
location=file_path.count('/')


select = cv2.imread('select.jpg') #select 이미지 읽기


img = cv2.imread(filename[location]) #원본 이미지 읽기

imageRows,imageCols = img.shape[:2]
tmp = img.copy()#tmp복사





dst = img.copy()#dst복사


selectRows,selectCols = select.shape[:2]


#지울부분
print(selectCols,selectRows,)#select의 x,y
print(imageRows,imageCols)
#여기까지

cv2.namedWindow('src')#윈도우 이름 지정
cv2.namedWindow('dst')
cv2.namedWindow('select')



cv2.moveWindow('src',defaultX,defaultY)#위치설정
cv2.moveWindow('dst',defaultX+imageCols,defaultY)
#cv2.moveWindow('select',defaultX+(2*imageCols),defaultY)#dst옆에 붙이기
cv2.moveWindow('select',0,imageRows)#src아래에 붙이기


cv2.setMouseCallback('select',Onclick) #윈도우에 함수 달기

#수정
countArray = [tmp,tmp,tmp,tmp,tmp,tmp,tmp,tmp,tmp,tmp,tmp,tmp,tmp,tmp,tmp]#초기화


#수정
list=['0','1','2','3','4'] # 리스트 보기








while 1:#사진을 계속해서 업데이트 
    
    
    
    k = cv2.waitKey(1)

    if k == 27:
        break
    if k == ord('p'): #list창 끄기
        listDestroy()
    elif k == ord('l'):#히스토리 보여주기
        seelist()     
    elif k == ord('q'):#전으로 돌리기
        undo()      
    elif k == ord('w'):#앞으로 돌리기
        redo()
    elif k == ord('s'):#저장하기
        save()
    elif k == ord('r'):#90도씩 회전시키기 // 나중에 마우스 입력으로 넣기
        rotation()
        
    
    cv2.imshow('select',select)
    cv2.imshow('src',img)
    cv2.imshow('dst',dst)
        
        

cv2.destroyAllWindows()

 



 

 

