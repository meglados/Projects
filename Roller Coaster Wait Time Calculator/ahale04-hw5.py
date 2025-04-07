# I attempted the EXTRA CREDIT
# Audrey Hale
# ahale04
# Homework 5 - More About Strings
# TCSS 141A - Programming for All

"""
this program accepts input from the user to calculate the expected wait time for a ride.
the input is inspected for specific values and based on those values, it calculates and
prints the expected wait time.
"""

#accepts input in any form at first, and then assigns boolean value if it is purely alphabetical or not
userString = input("What is the sequence? ")
isAlphabetical = userString.isalpha()
addedTime = 0
orneryCount = 0
technician = False
deduction = 0

#test the condition of the boolean, prompting user until it returns true and the string is alphabetical only
if isAlphabetical != True:
    while isAlphabetical != True:
        userString = input("Incorrect format. Enter a sequence of characters: ")
        isAlphabetical = userString.isalpha()

#variable was continuosly reassigned, need to convert to uppercase again for later condition testing
userString = userString.upper()

#constants for the base time of wait and number of people in line
TOTAL_PEOPLE = len(userString)
BASE_TIME = TOTAL_PEOPLE * 5

#for loop goes through each character checking for applicable conditions and assigning values based on conditions
for curChar in userString:
    if curChar == "E":
        if technician == True:
            addedTime += 5
            
        else:
            addedTime += 0
            
    if curChar == "P":
        if technician == True:
            addedTime += 4

        else:
            addedTime += 2

    if curChar == "C":
        if technician == True:
            addedTime += 6

        else:
            addedTime += 3

    if curChar == "O":
        if technician == True:
            addedTime += (TOTAL_PEOPLE * 2) + 5
            orneryCount += 1

        else:
            addedTime += TOTAL_PEOPLE
            orneryCount += 1

    if curChar == "T":
        technician = True
        addedTime += 20
        deduction = -5

#specific condition to weed out if a technician was in the mix, assigns if applicable
if technician == True:
    totalTime = BASE_TIME + addedTime + deduction
    averageWait = totalTime / TOTAL_PEOPLE

#calculates and assigns here if not
else:
    totalTime = BASE_TIME + addedTime
    averageWait = totalTime / TOTAL_PEOPLE

#final print of all values compiled, no calculations to be done in the print statement
print("Total time: ", totalTime, "minutes.",
      "\nAverage: ", format(averageWait, '.1f'), "minutes per guest.",
      "\nOrnery Guests: ", orneryCount, "guests.")
