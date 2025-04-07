# Audrey Hale
# ahale04
# Homework 3 - Booleans and Decision Structures
# TCSS 141A - Programming for All

"""
this program accepts user inputs for the length and width
of a rectangle, using said inputs to calculate and
print the area, perimeter, and notable features about the
dimensions of the rectangle
"""

# get user input for length and width
length = float(input("What is the length? "))
width = float(input("What is the width? "))

# calculate the area and perimeter
area = float(length * width)
perimeter = float((length * 2) + (width * 2))

# if the length is greater than the widthm assign
# var shortSide to value of width, else; assign
# to value of length.
if length > width:
    shortSide = width
else:
    shortSide = length

# print notable features based on previous calculations
print("Length       :", format(length, '10,.2f'))
print("Width        :", format(width, '10,.2f'))
print("Perimeter    :", format(perimeter, '10,.2f'))
print("Area         :", format(area, '10,.2f'))
print("Short Side   :", format(shortSide, '10,.2f'))

# if statements to deduce the most fitting descriptor of
# the rectangle based on the value of area and length / width
if area < 10:
    print("This rectangle is small.")

elif area > 100:
    print("This rectangle is HUGE!!!!!")

elif area > 50:
    print("This rectangle is large.")

else:
    print("This rectangle is normal.")

if length > width:
    print("This rectangle is tall!")

elif width > length:
    print("This rectangle is wide!")

else:
    print("This rectangle is a square.")
