from PIL import Image
image = Image.open('test.JPG').convert('RGB')
pixels = image.load()
w, h = image.size

print(w,h)
for i in range(w) :
	for j in range(h) :
		r,g,b = image.getpixel((i,j))
		# print(image.getpixel((i,j)))
		if (r > 150):
			b = r
			r = 0
		pixels[i, j] = (r, g, b)

		# print(image.getpixel((i,j)))

image.save('outp1.jpg')

# image = Image.open('test.JPG')
# img_hsv = image.convert('HSV')
# hsv = image_hsv.load()
# print(hsv)
