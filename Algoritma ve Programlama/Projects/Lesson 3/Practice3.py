sum = 0.0
input_str = input("Enter a number: ")
while input_str != "":
    input_int = float(input_str)
    sum = sum + input_int
    input_str = input("Enter a number: ")
print(str(sum))
