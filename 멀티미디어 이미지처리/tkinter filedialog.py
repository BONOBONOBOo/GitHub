import tkinter as tk
from tkinter import filedialog

import cv2

root = tk.Tk()
root.withdraw()

file_path = tk.filedialog.askopenfilename()
filename=file_path.split('/')
location=file_path.count('/')

k = cv2.imread(filename[location])

cv2.namedWindow('1')
cv2.imshow('1',k)

