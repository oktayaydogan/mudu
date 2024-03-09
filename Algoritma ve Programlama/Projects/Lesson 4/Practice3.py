def check_lenght(x):
    new_list = []
    for i in x:
        if len(i) > 4:
            new_list.append(i)
    return new_list


list = ["Alpha", "Beta", "Gamma", "Delta"]
print(check_lenght(list))
