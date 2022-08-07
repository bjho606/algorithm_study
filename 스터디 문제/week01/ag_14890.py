import sys

N, L = map(int,sys.stdin.readline().split())
arr = [list(map(int,sys.stdin.readline().split())) for _ in range(N)] #dummy_
answer = 0

for i in range(N):
    pre = arr[i][0]
    cnt = 1
    for j in range(1,N):
        if arr[i][j] == pre:
            cnt += 1
            pre = arr[i][j]
        elif arr[i][j] == pre+1 and cnt >= 0:
            if cnt >= L:
                cnt = 1
                pre = arr[i][j]
            else:
                break
        elif arr[i][j] == pre-1 and cnt >= 0:
            cnt = - L + 1
            pre = arr[i][j]
        else:
            break
    else:
        if cnt >= 0:
            answer += 1
###
for j in range(N):
    pre = arr[0][j]
    cnt = 1
    for i in range(1,N):
        if arr[i][j] == pre:
            cnt += 1
            pre = arr[i][j]
        elif arr[i][j] == pre+1 and cnt >= 0:
            if cnt >= L:
                cnt = 1
                pre = arr[i][j]
            else:
                break
        elif arr[i][j] == pre-1 and cnt >= 0:
            cnt = - L + 1
            pre = arr[i][j]
        else:
            break
    else:
        if cnt >= 0:
            answer += 1
 
print(answer)