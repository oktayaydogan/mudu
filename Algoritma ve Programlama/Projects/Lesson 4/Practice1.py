def half_change(par):
    half_length = len(par) // 2
    return par[half_length:] + par[:half_length]


number_list = ["10", "20", "30", "40", "50", "60", "70"]
print(half_change(number_list))
