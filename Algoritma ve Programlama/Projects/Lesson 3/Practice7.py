terminate = False
while not terminate:
    year = input("Enter a year 1800 of 2099: (Q to quit) ")
    year = year.strip()

    if year == "Q" or year == "q":
        terminate = True
        break
    else:
        if year.isdigit() == False or int(year) < 1800 or int(year) > 2099 or len(year) != 4:
            print("Please enter a year between 1800 and 2099")
            continue

    month = input("Enter a month 1 to 12: (Q to quit) ")
    month = month.strip()

    if month == "Q" or month == "q":
        terminate = True
        break
    else:
        if month.isdigit() == False or int(month) < 1 or int(month) > 12 or len(month) > 2:
            print("Please enter a month between 1 and 12")
            continue

    century: int = int(year[:2])
    year: int = int(year[2:])


'''

    # Check if the year is a leap year
    if year % 400 == 0 or (year % 4 == 0 and year % 100 != 0):
        leapYear = True
        print(f"{year} artık yıldır")
    else:
        leapYear = False
        print(f"{year} artık yıl değildir")
        
    # Check if the month has 30 or 31 days
    if month == 4 or month == 6 or month == 9 or month == 11:
        days = 30
    elif month == 2:
        if leapYear:
            days = 29
        else:
            days = 28
    else:
        days = 31

    print(f"{year} yılındaki {month}. ay {days} gün çeker")


'''