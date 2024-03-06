from math import floor

terminate = False
while not terminate:
    year = input("1800 ile 2099 arasında bir yıl girin: (Çıkmak için Q) ")
    year = year.strip()

    if year.lower() == "q":
        terminate = True
        break
    else:
        if not year.isdigit() or int(year) < 1800 or int(year) > 2099 or len(year) != 4:
            print("Lütfen 1800 ile 2099 arasında bir yıl girin")
            continue

    month = input("1 ile 12 arasında bir ay girin: (Çıkmak için Q) ")
    month = month.strip()

    if month.lower() == "q":
        terminate = True
        break
    else:
        if not month.isdigit() or int(month) < 1 or int(month) > 12:
            print("Lütfen 1 ile 12 arasında bir ay girin")
            continue

    century_digit = int(year[:2])
    year_digit = int(year[2:])

    value = 0
    value += year_digit + floor(year_digit / 4)

    if century_digit == 18:
        value += 2
    elif century_digit == 20:
        value += 6

    leap_year = False

    if year_digit % 4 == 0 and (year_digit % 100 != 0 or year_digit % 400 == 0):
        leap_year = True

    if month == '1' and not leap_year:
        value += 1
    elif month == '2' and leap_year:
        value += 3
    elif month == '2' and not leap_year:
        value += 4
    elif month == '3' or month == '11':
        value += 4
    elif month == '5':
        value += 2
    elif month == '6':
        value += 5
    elif month == '8':
        value += 3
    elif month == '10':
        value += 1
    elif month == '9' or month == '12':
        value += 6

    start_day = 1
    value = (value + start_day) % 7
    days = ["Pazar", "Pazartesi", "Salı", "Çarşamba", "Perşembe", "Cuma", "Cumartesi"]

    day_of_week = days[value]

    days_in_month = 0
    if month in ['1', '3', '5', '7', '8', '10', '12']:
        days_in_month = 31
    elif month in ['4', '6', '9', '11']:
        days_in_month = 30
    elif month == '2' and leap_year:
        days_in_month = 28
    elif month == '2' and not leap_year:
        days_in_month = 29

    if leap_year:
        print(f"{year} yılı artık yıldır.")
    else:
        print(f"{year} yılı artık yıl değildir.")

    print(f"{year} yılının {month}. ayı {days_in_month} gün çeker.")
    print(f"{year} yılının {month}. ayının 1. günü {day_of_week} günüdür.")

    print("\nTakvim:")
    print("Pzt Sal Çar Per Cum Cmt Paz")
    print("----" * 7)

    template = "{:3} " * 7

    i = 1
    value -= 1
    while i <= days_in_month:
        line = []
        for j in range(1, 8):
            day = ""
            if i != 1 or j >= value:
                if i <= days_in_month:
                    day = i
                    i += 1
            line.append(day)
        print(template.format(*line))
