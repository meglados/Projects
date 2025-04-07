# Audrey Hale
# ahale04
# Homework 6 - Lists
# TCSS 141A - Programming for All

"""
This program accepts input from the user to compare test answers with a predetermined
answer key. The user input will be converted to a string of several seperate values.
The program will only accept input of 15 characters, if there are more or less, the user
will be prompted to enter in exactly 15 characters. The user_string will then be
compared to the ANSWER_KEY one value at a time. Each time a value is not equivalent,
this information will be logged in a seperate string to hold all WRONG answers. All
CORRECT answers will also be logged. After comparison, a print statement will summarize
the ratio of correct answers to total answers, the grade percentage, and the pass or
fail metric. If the user received either a perfect 100 or 0, CORRECT and WRONG answers will
not be printed. In any other case, WRONG and CORRECT answers will be printed. 
"""

#constants assigned based on unchanging information gained outside the program
ANSWER_KEY = ['C','C','B','C','A','C','D','E','B','B','D','D','C','B','A']
PASSING_GRADE = 80
TOTAL_ANSWERS = 15

#initializing strings and other changing variables
num = 0
WRONG = []
user_answers = []
CORRECT = []

user_string = input("Enter your answers: ")
user_string = user_string.upper()   #convert to upper ASAP
answer_length = len(user_string)

#input filtering to ensure that the number of characters is neither <> 15
while answer_length != 15:
    user_string = input("Enter exactly 15 answers: ")
    user_string = user_string.upper()    #need to reconvert to upper
    answer_length = len(user_string)

#for loop that isolates the individual characters for the string
for char in user_string:
    user_answers.append(char)

#comparing the values of each of the strings and tracking conditions
for char in ANSWER_KEY:
    if char != user_answers[num]:
        WRONG.append(num)
    else:
        CORRECT.append(num)
    num += 1

#need the int val of WRONG and CORRECT
num_wrong = len(WRONG)
num_correct = len(CORRECT)
final_grade = (num_correct / TOTAL_ANSWERS) * 100

#summaritive set of print statements with final conditions based on gathered data
print("You Scored ", num_correct, "/", TOTAL_ANSWERS,
      ", or ", format(final_grade, '.1f'), "%")

if final_grade == 100:
    print("A perfect score - no answers wrong!")
elif final_grade == 0:
    print("You got a perfect 0! The TLC is included in tuition by the way!!")
else:
    print("Correct answers; ", CORRECT)
    print("Wrong answers; ", WRONG)

if final_grade < PASSING_GRADE:
    print("You failed the exam.")
else:
    print("You passed the exam!")
