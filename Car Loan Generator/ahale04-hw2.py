# Audrey Hale
# ahale04
# Homework 2 - Variables and Data Types
# TCSS 141A - Programming for All

"""
This program accepts input from the user to use and calculate
and assemble a final order report for a car loan. It will take the users
name, the car model, the base price of the car, and the total months spent
paying off the loan. This information will be used to calculate an output
in the form of an order report.
"""

#takes input from user, assigns this value to appropriate variable
personName = input("What is your name? ")
carName = input("What is the name of the car? ")
valueOfCar = float(input("What is the value of the car? "))
monthsSpent = int(input("How many months have been spent paying off the loan? "))
monthlyInterest = valueOfCar * 0.075
finalCost = (valueOfCar + (monthlyInterest * monthsSpent))

#formatting
print()
print("-----")
print()

#this is for the print statements, all calculations done prior to call
print("Order Report:")
print("Buyer:", personName)
print("Model:", carName, "\n")
print("Base Value: $", format(valueOfCar, ',.2f'))
print("Monthly Interest: $", format(monthlyInterest, ',.2f'))
print("Final Cost: $", format(finalCost, ',.2f'))
