import cv2
import numpy as np
from PIL import Image
import colorsys
img = cv2.imread("test.JPG")
img_hsv = cv2.cvtColor(img, cv2.COLOR_BGR2HSV)
def hsv2rgb(h,s,v):
	return tuple(round(i * 255) for i in colorsys.hsv_to_rgb(h,s,v))
image = Image.open('test.JPG').convert('RGB')
pixels = image.load()
w, h1 = image.size
print(w,h1)
for i in range(w) :
	for j in range(h1) :
		h= img_hsv[j][i].item(0);
		s= img_hsv[j][i].item(1);
		v= img_hsv[j][i].item(2);
		if((s>=50) and (v>=20)):
			if((h<=5) or ((h>=175) and (h<=180))):
				test_color1 = hsv2rgb(((h-60)%179)/179.0 , s/255.0 , v/255.0)
				pixels[i, j] = (int(test_color1[0]),int(test_color1[1]),int(test_color1[2]))
image.save('outp2.jpg')