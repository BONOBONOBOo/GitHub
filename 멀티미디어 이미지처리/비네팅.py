import cv2
import numpy as np



img = cv2.imread('2.jpg')
rows,cols = img.shape[:2]
copy = np.zeros((rows,cols,3),np.uint8)
black = np.zeros((rows,cols,3),np.uint8)
copy[:][:] = 255

mask_set=["mask1",'mask2','mask3','mask4','mask5','mask6','mask7','mask8','mask9','mask10','mask11','mask12','mask13','mask14','mask15','mask16','mask17','mask18''mask19','mask20']

copy_not = cv2.bitwise_not(copy)
center = cv2.bitwise_and(img,copy)#중앙 저장

mask_weight=20

 
for mask_number in range(19):#마스크 만들기
    for i in range(rows):
        for j in range(cols):
              if i<rows/(mask_weight-mask_number) or i>rows/(mask_weight-mask_number)*(mask_weight-mask_number-1) or j<cols/(mask_weight-mask_number) or j>cols/(mask_weight-mask_number)*(mask_weight-mask_number-1):
                  copy[i][j]=0
                  
    if mask_number==0:
        mask_set[mask_number]=cv2.addWeighted(img, 0.05, copy, 0.95, 0)
    else:
        mask_set[mask_number]=cv2.addWeighted(img, 0.07*mask_number, copy, 1-(0.07*mask_number), 0)
    copy[:][:] = 255

for mask_number in range(0,19,1):
    for i in range(rows):
        for j in range(cols):
            if mask_number==0:
                if i<rows/mask_weight or i>rows/(mask_weight)*(mask_weight-1) or j<cols/(mask_weight) or j>cols/(mask_weight)*(mask_weight-1):
                    copy[i][j] = mask_set[0][i][j]

            elif mask_number>0 and mask_number<20:
                if (i>=(rows/(mask_weight-mask_number+1)) and i <=(rows/(mask_weight-mask_number)) and j<(cols/(mask_weight+1-mask_number)*(mask_weight-mask_number)) and j>(cols/(mask_weight+1-mask_number))):
                    copy[i][j] = mask_set[mask_number][i][j]    
                elif (i<=(rows/(mask_weight+1-mask_number)*(mask_weight-mask_number)) and i>=(rows/(mask_weight-mask_number)*(mask_weight-1-mask_number)))and j<(cols/(mask_weight+1-mask_number)*(mask_weight-mask_number)) and j>(cols/(mask_weight+1-mask_number)):
                    copy[i][j] = mask_set[mask_number][i][j]                    
                elif (j>=(cols/(mask_weight+1-mask_number)) and j <=(cols/(mask_weight-mask_number))and i<(rows/(mask_weight+1-mask_number)*(mask_weight-mask_number)) and i>(rows/(mask_weight+1-mask_number))):
                    copy[i][j] = mask_set[mask_number][i][j]
                elif (j<=(cols/(mask_weight+1-mask_number)*(mask_weight-mask_number)) and j>=(cols/(mask_weight-mask_number)*(mask_weight-1-mask_number)) and i<(rows/(mask_weight+1-mask_number)*(mask_weight-mask_number)) and i>(rows/(mask_weight+1-mask_number))):
                    copy[i][j] = mask_set[mask_number][i][j]
            #elif mask_number==7:
             #   copy[i][j]=center[i][j]
                

cv2.imshow('1',copy)           
k = cv2.waitKey(0)

if k == 27:
    cv2.destroyAllWindows()


