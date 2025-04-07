# Audrey Hale
# ahale04
# Homework 7 - Custom Functions
# TCSS 141A - Programming for All

"""
This program intakes information such as total num of athletes, athletes names, and
certain stats for each athlete respectively. This information is gathered through several function
dedication to each task centered around their respective naming convention. This information is then
printed at the end of the program in summation with formatting the rightmost column. Ints are
the standard input, but strs are accepted given a request for it specifically.

"""

#gets total num of athletes through user input, returns numAth
def getNumAth():
    num = int(input("Enter the total number of athletes: "))

    while num < 0:  # input filtration, will prompt user until num is >0
        num = int(input("Enter only a number greater than 0: "))

    return(num)

#gets info based on the calling loop's current iteration# (x), returns the user input
def getAthInfo(x):
    tracker = False

    while tracker == False:
        if x == 0:
            toReturn = input("Enter athlete name: ")
            tracker = True
            
        if x == 1:
            toReturn = int(input("Enter batting strength (1 to 10): "))
            if toReturn > 0 and toReturn <= 10:
                tracker = True
            
        if x == 2:
            toReturn = int(input("Enter running strength (1 to 10): "))
            if toReturn > 0 and toReturn <= 10:
                tracker = True

        if x == 3:
            toReturn = int(input("Enter pitching strength (1 to 10): "))
            if toReturn > 0 and toReturn <= 10:
                tracker = True

    return(toReturn)

"""
fxn generates the athList by entering a for loop for the numAth, and a nest forloop for the num of info
questions asked. 2nd for loops appends the info to tempList, which after final iteration, is appended
to athList. Finally returns athList
"""
def getAthList(numAth):
    athList = []
    tempList = []

    for y in range(numAth):
        print("Athlete #", y + 1)
        for x in range(4):
            tempList.append(getAthInfo(x))
        athList.append(tempList)
        tempList = []

    return(athList)

#simple fxn for getting the average of the inputs when called, returns average
def getAverage(a, b, c):
    x = a + b + c
    x = x / 3

    return(x)

#fxn to print the athList with the formatting applied to each.
def printAthChart(athList):
    print("Athlete Name       Batting   Running   Pitching   Average")
          
    for x in range(len(athList)):
        print(format(athList[x][0], '16'),
              format(athList[x][1], '9'),
              format(athList[x][2], '9'),
              format(athList[x][3], '10'),
              format(getAverage(athList[x][1], athList[x][2], athList[x][3]), '9,.2f'))

"""
finds best performing ath by calling for average, storing that value, comparing the average to
curAvg which starts at 0. if the value in temp is > than curAvg, curAvg is reassigned to temp.
else: continues comparing with no changes to curAvg. Fxn returns the final value of best, which
will contain an str(athletes) name.
"""
def getBestAth(athList):
    best = athList[0][0]
    curAvg = 0

    for x in range(len(athList)):
        temp = getAverage(athList[x][1], athList[x][2], athList[x][3])
        if temp > curAvg:
            curAvg = temp
            best = athList[x][0]

    return(best)

"""
finds worst performing ath by calling for average, storing that value, comparing the average to
curAvg which starts at 0. if the value in temp is < than curAvg, curAvg is reassigned to temp.
else: continues comparing with no changes to curAvg. Fxn returns the final value of worst, which
will contain an str(athletes) name.
"""
def getWorstAth(athList):
    worst = athList[0][0]
    curAvg = 0

    for x in range(len(athList)):
        temp = getAverage(athList[x][1], athList[x][2], athList[x][3])
        if temp < curAvg:
            curAvg = temp
            worst = athList[x][0]

    return(worst)

#assignments to get values for final print list
numAth = getNumAth()
athList = getAthList(numAth)
bestAth = getBestAth(athList)
worstAth = getWorstAth(athList)

#final print list in summary of all ath info and information gathered with it, with proper formatting
printAthChart(athList)
print("Highest Performance:", bestAth)
print("Poorest Performance:", worstAth)

