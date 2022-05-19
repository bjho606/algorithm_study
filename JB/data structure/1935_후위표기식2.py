import sys

input = sys.stdin.readline

N = int(input())

exp = input().strip('\n')

dict = {}
# print(exp)
for i in range(N):
    val = int(input())
    alpha = chr(i + ord('A'))
    dict[alpha] = val

st = []
for word in exp:
    if 'A' <= word <= 'Z':
        st.append(dict[word])
    else:
        first = st.pop()
        second = st.pop()
        
        if word == '*':
            st.append(first * second)
        elif word == '+':
            st.append(first + second)
        elif word == '-':
            st.append(second - first)
        elif word == '/':
            st.append(second / first)

print('%.2f' %st[0])