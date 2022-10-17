
"""
Get first duplicate
"""
def get_duplicate(numbers: int):

    number_count = {}

    for num in numbers:
        if num in number_count:
            value = number_count[num]
            value += 1
            number_count[num] = value
        else:
            number_count[num] = 1
        
    
    for num_count in number_count:

        if number_count[num_count] > 1:
            return num_count

    return -1

"""
Get list of duplicates from array
"""
def get_duplicates(numbers: int):

    number_count = {}

    for num in numbers:
        if num in number_count:
            value = number_count[num]
            value += 1
            number_count[num] = value
        else:
            number_count[num] = 1

    if len(number_count.keys()) == 0:
        return []
        
    duplicate_nums = []

    for num in number_count:

        if number_count[num] > 1:
            duplicate_nums.append(num)

    return duplicate_nums

"""
Get duplicate numbers and their count
"""
def get_duplicate_count(numbers: int):

    number_count = {}

    for num in numbers:
        if num in number_count:
            value = number_count[num]
            value += 1
            number_count[num] = value
        else:
            number_count[num] = 1

    if len(number_count.keys()) == 0:
        return []
        
    duplicate_nums = {}

    for num in number_count:

        if number_count[num] > 1:
            duplicate_nums[num] = number_count[num]

    return duplicate_nums


print("get_duplicate: {}".format(get_duplicate([1,2,3,2,])))

print("get_duplicate: {}".format(get_duplicate([1,2,3,4,4])))

print("get_duplicates: {}".format(get_duplicates([1,2,2,3,4,4])))

print("get_duplicate_count: {}".format(get_duplicate_count([1,2,2,3,4,4,4])))