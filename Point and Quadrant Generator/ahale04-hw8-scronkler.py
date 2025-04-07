import random

# Audrey Hale
# ahale04
# Homework 8 - Modules
# TCSS 141A - Programming for All

"""
This program generates a random pair of points on a 2d graph in the range -10 to 10.
This information is then used to find which quadrant this point would land on.
The user will then be prompted to guess the quadrant that the point lands in.
If the guess is correct the user will be able to guess until failure, while keeping
track of the highscore of the rounds the user reaches. When the user exits the program
the highest score reached will be printed.
"""

#vars that need prior initializing, subject to changes
highScore = 0
guess = True
userInput = "y"
roundNum = 0

print("Welcome to On Point!",
      "\nGuess the quadrant of the point to score.",
      "\nQuadrants are 1, 2, 3, or 4.",
      "\nIf a point is on an axis, the \"quadrant\" in 0.",
      "\n---")


def getRandomPoints():
    #return a list of randomly generated points -10 to 10

    pointList = []
    for x in range(2):
        point = random.randrange(-10, 11)
        pointList.append(point)

    return(pointList)

def getQuadrant(points):
    #test what quadrant these points belong to
    #returns the quadrant #

    point1 = points[0]
    point2 = points[1]
    quadrant = 0
    #conditions to narrow down which quadrant it is
    if point1 < 0:
        if point2 < 0:
            quadrant = 3

        if point2 > 0:
            quadrant = 2
    if point1 > 0:
        if point2 > 0:
            quadrant = 1

        if point2 < 0:
            quadrant = 4

    return(quadrant)
    
def guessTheQuadrant(points, quadNum, roundNum):
    #have the user guess what the quadrant is
    #if ==, print so, and continue the game
    #if !=, print so, and end the game after printing the correct
    #return true or false

    print("Round", roundNum, ":")
    
    print("The point is at", "(", points[0], ",", points[1], ")")
    userGuess = int(input("Enter your guess: "))

    if userGuess == quadrant:
        guessBool = True
        print("Correct!")
    else:
        guessBool = False
        print("Incorrect; the quadrant was:", quadrant)

    return(guessBool)

def highScoreCheck(curHigh, curRound):
    #check if the round num surpasses the curHighscore
    #if yes, reassign highscore to the curRound, if not, it doesnt change
    #return curHigh

    print("Your final score was", curRound)

    if curHigh < curRound:
        curHigh = curRound
        print("You got the High Score!")

    return(curHigh)

#while loop to keep player in until input != y
while userInput == "y":
    #nested while loop so player can keep guessing until failure
    #also to keep track of vars of past tests like highScore
    while guess != False:
        roundNum += 1
        randPoints = getRandomPoints()
        quadrant = getQuadrant(randPoints)
        guess = guessTheQuadrant(randPoints, quadrant, roundNum)

    
    highScore = highScoreCheck(highScore, roundNum)
    userInput = input("Enter y to play again: ")
    if userInput == "y":
        roundNum = 0
        guess = True

print("High Score: ", highScore)
