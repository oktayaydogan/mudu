check = False
while not check:
    number = int(input("Enter a number: "))
    if number < 0:
        print("Please enter a positive number")
    else:
        check = True
        factorial = 1
        for i in range(1, number + 1):
            factorial *= i
        print(f"{number} != {factorial}")
