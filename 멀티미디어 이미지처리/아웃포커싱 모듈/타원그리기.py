#타원그리기 연습
import numpy as np
import cv2

img = np.zeros((800,800,3), np.uint8)

thickness=2
green=(0,255,0)

cv2.ellipse(img, (400,400), (200, 10), 0, 0, 360, green, thickness)

cv2.imshow('1',img)
