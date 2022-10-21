

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