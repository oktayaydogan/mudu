note = input("Enter your note: ")

if int(note) <= 45:
    print("FF")
elif int(note) < 55:
    print("D-")
elif int(note) < 65:
    print("D+")
elif int(note) < 75:
    print("C")
elif int(note) < 85:
    print("B")
elif int(note) >= 85:
    print("A")
else:
    print("Invalid note")