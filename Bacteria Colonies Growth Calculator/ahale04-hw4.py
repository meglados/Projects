# I attempted the EXTRA CREDIT
# Audrey Hale
# ahale04
# Homework 4 - Repetition Structures
# TCSS 141A - Programming for All

"""
This program accepts user input for the number of starting
colonies, the growth rate, and the simulation hours
that are greater than 0.

It will then calculate and output all hours until completion.
this will include the current colonies, colonies grown within the hour,
and the colonies that died within that same hour.

After all hours are produced, the total overall colonies that died
and were grown will be output.
"""

#all input variables and constants taken at the beginning of the program
numColonies = int(input("Enter the number of colonies: "))
if numColonies <= 0:
    while (numColonies <= 0):
        numColonies = int(input("Enter number of colonies (greater that 0): "))

GROWTH_RATE = int(input("Enter the growth rate： ")) / 100
if GROWTH_RATE <= 0:
    while (GROWTH_RATE <= 0):
        GROWTH_RATE = int(input("Enter the growth rate (greater that 0): ")) / 100

NUM_HOURS = int(input("Enter the hours to simulate: "))
if NUM_HOURS <= 0:
    while (NUM_HOURS <= 0):
        NUM_HOURS = int(input("Enter the hours to simulate (greater that 0): "))
        
CULL_RATE = 0.15
FIRST_HOUR = 1
coloniesDied = 0
totalColDead = 0
totalColGrown = 0
coloniesGrown = 0

#formatting for readability
print()
print("Hour #:    ", "Current Colonies","    ","Colonies Grown", "    ", "Colonies Died")

#forloop starts at 1 so as to stay within the scope of the program
for curHour in range(1,NUM_HOURS + 1):
    #each iteration tests if 3 hours has passed, if so, %15 of colonies are slain
    if (curHour % 3 == 0):
        coloniesDied = numColonies * CULL_RATE
        totalColDead = totalColDead + coloniesDied
        numColonies = numColonies - coloniesDied
    #interation of not 3hr interval will expand the colonies
    coloniesGrown = numColonies * GROWTH_RATE
    totalColGrown = totalColGrown + coloniesGrown
    numColonies = numColonies + coloniesGrown

    #print out the data collected formatted to the decimal aligning with the column texts
    print(format(curHour, '7d')
          , format(numColonies, '20.4f')
          , format(coloniesGrown, '19.4f')
          , format(coloniesDied, '18.4f'))
    #VERY IMPORTANT! colonies need to be reset or it will carry into the next iteration!!
    coloniesDied = 0

print()
print("Total colonies grown:", format(totalColGrown, '.4f'))
print("Total colonies dead :", format(totalColDead, '.4f'))
