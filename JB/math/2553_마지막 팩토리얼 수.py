import sys

input = sys.stdin.readline

N = int(input())

def facto(n):
    val = 1
    for i in range(1, n+1):
        val *= i

    return val

val = facto(N)
# print(val)
str_val = str(val)
for i in range(len(str_val) - 1, -1, -1):
    if str_val[i] == '0':
        continue
    print(str_val[i])
    break
