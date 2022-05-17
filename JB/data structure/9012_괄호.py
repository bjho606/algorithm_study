import sys

input = sys.stdin.readline

N = int(input())
for i in range(N):
    st = []
    flag = 1
    ip = input().strip('\n')
    
    for letter in ip:
        if letter == '(':
            st.append(letter)
        else:
            if len(st) > 0:
                st.pop()
            else:
                flag = 0
                break

    if flag == 1 and len(st) == 0:
        print('YES')
    else:
        print('NO')