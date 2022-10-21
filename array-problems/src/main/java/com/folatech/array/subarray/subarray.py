

import string


def is_valid_subsequence(arr: list, sequence: list):

    seq_index = 0

    sequence_size = len(sequence)

    for num in arr:
        print("arr {}, sequence {}".format(num, sequence[seq_index]))

        if num == sequence[seq_index]:
            seq_index += 1
        
        if seq_index == sequence_size:
            break
    
    return sequence_size == seq_index

print("is_valid_subsequence")

arr = [5, 1, 22, 25, 6, -1, 8, 10, 17, 29]
sequence = [1, 6, -1, 10]

print("arr: {}".format(arr))
print("sequence: {}".format(sequence))

result = is_valid_subsequence(arr,sequence)

print("result: {}".format(result))

arr = [5, 1, 22, 25, 6, -1, 8, 10, 17, 29]
sequence = [1, 6, -1, 10, 78]

print("arr: {}".format(arr))
print("sequence: {}".format(sequence))

result = is_valid_subsequence(arr,sequence)

print("result: {}".format(result))


def is_valid_string_subsequence(str: string, sequence: string):

    seq_index = 0

    sequence_size = len(sequence)

    for char in str:
        print("char {}, sequence {}".format(char, sequence[seq_index]))

        if char == sequence[seq_index]:
            seq_index += 1
        
        if seq_index == sequence_size:
            break
    
    return sequence_size == seq_index

print("is_valid_string_subsequence")

str = "folaukaveinga"
seq = "oan"

print("str: {}".format(str))
print("seq: {}".format(seq))

result = is_valid_string_subsequence(str,seq)

print("result: {}".format(result))

str = "folaukaveinga"
seq = "oano"

print("str: {}".format(str))
print("seq: {}".format(seq))

result = is_valid_string_subsequence(str,seq)

print("result: {}".format(result))