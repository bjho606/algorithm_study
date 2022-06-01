import sys

input = sys.stdin.readline

ip1, ip2 = input().rstrip('\n').split()

available_count = 0
X, A, B = 0, 2, 2
numbers = dict()
for i in range(10):
    numbers[str(i)] = i
for i in range(26):
    numbers[chr(ord('a') + i)] = i + 10
# print(numbers)

A_max = max(list(ip1))
B_max = max(list(ip2))
# print(A_max, B_max)

for i in range(numbers[A_max] + 1, 37):
    for j in range(numbers[B_max] + 1, 37):
        if i < 2 or j < 2 or i == j:
            continue
        if int(ip1, i) == int(ip2, j):
            available_count += 1
            if available_count > 1:
                print('Multiple')
                exit()
            X = int(ip1, i)
            A = i
            B = j

if available_count == 0:
    print('Impossible')
else:
    print(X, A, B)