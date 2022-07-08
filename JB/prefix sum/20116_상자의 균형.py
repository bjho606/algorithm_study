import sys

input = sys.stdin.readline

N, L = map(int, input().split())
center = (list(map(int, input().split())))
# print(center)
center.reverse()
# print(center)

center_sum = []
temp = 0
for x in center:
    temp += x
    center_sum.append(temp)
# print(center_sum)

for i, x in enumerate(center_sum):
    if i < len(center_sum) - 1:
        # print(center[i+1] - L, x / (i+1), center[i+1] + L)
        if center[i+1] - L < x / (i+1) < center[i+1] + L:
            continue
        else:
            print("unstable")
            exit()

print("stable")