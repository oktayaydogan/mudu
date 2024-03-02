notes = [1, 6, 7, 9, 3, 4]
sum_note = 0.0
avarage_note = 0.0

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
