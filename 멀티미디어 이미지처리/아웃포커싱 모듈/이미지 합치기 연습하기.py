import cv2

img1 = cv2.imread('3.jpg')
img2 = cv2.imread('copy1.jpg')
img3 = cv2.imread('copy2.jpg')

result = cv2.bitwise_or(img1,img3)


cv2.imshow('result',result)
#cv2.imshow('1',img1)
#cv2.imshow('2',img2)
#cv2.imshow('3',img3)





k=cv2.waitKey(0)
if k==27:
    cv2.destroyAllWindows()
