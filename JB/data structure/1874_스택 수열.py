import sys

input = sys.stdin.readline

N = int(input())
q = []
st = []
ans = []
flag = True
count = 1

# print(q)
for i in range(N):
    next = int(input())
    
    while count <= next:
        st.append(count)
        ans.append('+')
        count += 1
    
    if st[-1] == next:
        st.pop()
        ans.append('-')
    else:
        flag = False
        break

if flag:
    for i in ans:
        print(i)
else:
    print('NO')