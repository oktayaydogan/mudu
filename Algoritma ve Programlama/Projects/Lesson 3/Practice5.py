notes = []
sum_note = 0.0
avarage_note = 0.0

input_str = input("Enter a number: ")
while input_str != "":
    input_int = float(input_str)
    notes.append(input_int)
    input_str = input("Enter a number: ")

for note in notes:
    sum_note = sum_note + note
print("Sum is: " + str(sum_note))

sum_note = 0.0
for note in notes:
    sum_note += note
if len(notes) != 0:
    avarage_note = sum_note / len(notes)
else:
    avarage_note = 0.0
print("Avarage is: " + str(avarage_note))