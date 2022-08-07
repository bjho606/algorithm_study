# 에라이 포기

from collections import deque
import sys

input = sys.stdin.readline

def rotate_slate(x, d, k, s, l):
    if d == 0:
        s[x-1].rotate(k)
        l[x-1].rotate(k)
    elif d == 1:
        s[x-1].rotate(-k)
        l[x-1].rotate(-k)

def erase_adjacent(s, l, n, m):
    flag = False
    for i in range(n):
        for j in range(m):
            if s[i][j] != 0:
                # 같은 원판 인접 체크
                if j == m - 1:
                    if s[i][j] == s[i][0]:
                        flag = True
                        l[i][j] = l[i][0] = 0
                else:
                    if s[i][j] == s[i][j+1]:
                        flag = True
                        l[i][j] = l[i][j+1] = 0
                # 다른 원판 같은 위치 인접 체크
                if i == n - 1:
                    continue
                else:
                    if s[i][j] == s[i+1][j]:
                        flag = True
                        l[i][j] = l[i+1][j] = 0
    
    if flag:
        for i in range(n):
            for j in range(m):
                if l[i][j] == 0:
                    s[i][j] = 0

    return flag

def averaging(s, l, n, m):
    sums = 0
    count = 0
    for i in range(N):
        for j in range(M):
            if l[i][j] != 0:
                sums += l[i][j]
                count += 1
    avg = sums / count
    # print(sum, average)

    for i in range(N):
        for j in range(M):
            if left_slate[i][j] != 0:
                if left_slate[i][j] > avg:
                    slate[i][j] -= 1
                    left_slate[i][j] -= 1
                elif left_slate[i][j] < avg:
                    slate[i][j] += 1
                    left_slate[i][j] += 1


N, M, T = map(int, input().split())

slate = []
left_slate = []
ans = 0

for i in range(N):
    nums = deque(list(map(int, input().split())))
    nums2 = nums.copy()
    slate.append(nums)
    left_slate.append(nums2)
# print(slate)

# [rotation]
for i in range(T):
    X, D, K = map(int, input().split())
        
    if X > 1:
        while X <= N:
            rotate_slate(X, D, K, slate, left_slate)
            # print(slate)
            X += X

    check = 0
    for j in range(N):
        check += sum(left_slate[j])
    if check > 0:
        # [check adjacent and erase]
        # print(left_slate)
        flag = erase_adjacent(slate, left_slate, N, M)
        # print(left_slate)

        # [averaging]
        if not flag:
            averaging(slate, left_slate, N, M)
        # print(left_slate)
        
# [add sum]
for i in range(N):
    ans += sum(left_slate[i])
    # for j in range(M):
    #     ans += left_slate[i][j]

print(ans)