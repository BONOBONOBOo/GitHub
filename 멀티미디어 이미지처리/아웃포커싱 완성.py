import cv2
import numpy as np

circle=False

# 마우스 콜백 함수
def draw_circle(event, x, y, flags, param):

    global ix,iy,fx,fy,circle,img,copy,mask1_wright
    mask1_weight=1.2
    
    if event == cv2.EVENT_LBUTTONDOWN:
        ix,iy=x,y
        circle = True
        
    elif event == cv2.EVENT_MOUSEMOVE:#움직일때 그리기
        print(circle)
        if circle:
            img=copy.copy()
            ix,iy,fx,fy=min(ix,x),min(iy,y),max(ix,x),max(iy,y)      
            cx,cy=int((fx-ix)/2+ix),int((fy-iy)/2+iy)
            #cv2.circle(img,(cx,cy),int(cx-ix),(255, 0, 0), 2)
            cv2.ellipse(img, (cx,cy), (int((fx-ix)/2), int((fy-iy)/2)), 0, 0, 360, (255,255,255), 1)
            cv2.ellipse(img, (cx,cy), (int(((fx-ix)*mask1_weight)), int(((fy-iy)*mask1_weight))), 0, 0, 360, (255,255,255), 1)
            
    elif event == cv2.EVENT_LBUTTONUP:
        
        
        circle = False
        ix,iy,fx,fy=min(ix,x),min(iy,y),max(ix,x),max(iy,y)
        cx,cy=int((fx-ix)/2+ix),int((fy-iy)/2+iy)
        
        rows,cols = img.shape[:2]
        mask_0 = np.zeros((rows,cols,3),np.uint8)

        img=copy.copy()

        

        #마스크1
        cv2.ellipse(mask_0, (cx,cy), (int((fx-ix)/2), int((fy-iy)/2)), 0, 0, 360, (255,255,255), -1)#마스크0에 타원그리기
        mask_1=cv2.bitwise_and(mask_0,img)#마스크1 얻어내기
                
        #마스크2
        cv2.ellipse(mask_0, (cx,cy), (int(((fx-ix)*mask1_weight)), int(((fy-iy)*mask1_weight))), 0, 0, 360, (255,255,255), -1)#마스크1 타원그리기
        cv2.ellipse(mask_0, (cx,cy), (int((fx-ix)/2), int((fy-iy)/2)), 0, 0, 360, (0,0,0), -1)#마스크1 원본 타원그리기
        img = cv2.blur(img,(3,3))
        mask_2=cv2.bitwise_and(mask_0,img)#마스크2 얻어내기
        
        #마스크3
        cv2.ellipse(mask_0, (cx,cy), (int((fx-ix)*mask1_weight), int((fy-iy)*mask1_weight)), 0, 0, 360, (255,255,255), -1)
        mask_0 = cv2.bitwise_not(mask_0)
        img = cv2.blur(img,(5,5))
        mask_3=cv2.bitwise_and(mask_0,img)#마스크3 얻어내기

        #마스크 합치기        
        
        pp = cv2.bitwise_or(mask_1,mask_2)
        
        pp = cv2.bitwise_or(mask_3,pp)
        cv2.imshow('result',pp)
        
                
img = cv2.imread('3.jpg')
copy=img.copy()
cv2.namedWindow('image')
cv2.setMouseCallback('image', draw_circle)

while True:
    cv2.imshow('image', img)
    if cv2.waitKey(1) & 0xFF == 27:
        break
    elif cv2.waitKey(1) & 0xFF == ord('r'):
        img = np.zeros((512, 512, 3), np.uint8)
cv2.destroyAllWindows()
