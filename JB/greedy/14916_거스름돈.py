import sys

input = sys.stdin.readline

n = int(input())

num = [-1, -1, 1, -1, 2, 1]
for i in range(6, n+1):
    if i % 5 == 0:
        num.append(i//5)
    elif num[i - 5] != -1:
        num.append(num[i-5] + 1)
    elif num[i - 2] != -1:
        num.append(num[i-2] + 1)
    elif i % 2 == 0:
        num.append(i//2)
    else:
        num.append(-1)

print(num[n])