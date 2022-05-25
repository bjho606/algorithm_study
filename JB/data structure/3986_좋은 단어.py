import sys

input = sys.stdin.readline

N = int(input())

count = 0
for i in range(N):
    st = []

    ip = input().rstrip('\n')
    for word in ip:
        if st and st[-1] == word:
            st.pop()
        else:
            st.append(word)

    if not st:
        count += 1

print(count)