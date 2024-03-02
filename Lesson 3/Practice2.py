visa = input("Enter your visa note: ")
final = input("Enter your final note: ")

note = (int(visa) * 0.4) + (int(final) * 0.6)

if note <= 45:
    print("FF")
elif note < 55:
    print("D-")
elif note < 65:
    print("D+")
elif note < 75:
    print("C")
elif note < 85:
    print("B")
elif note >= 85:
    print("A")
else:
    print("Invalid note")