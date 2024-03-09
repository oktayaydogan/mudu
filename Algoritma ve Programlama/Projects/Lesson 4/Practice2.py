def check_same(x, y):
    for i in x:
        if i in y:
            return True
    return False


list1 = [1, 2, 3, 4]
list2 = [5, 4, 6, 7]

print(check_same(list1, list2))
