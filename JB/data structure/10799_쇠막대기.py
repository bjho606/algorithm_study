import sys

input = sys.stdin.readline

exp = input().rstrip()

st = []
count = 0

for i, word in enumerate(exp):
    if word == '(':
        st.append(word)
    else:
        st.pop()
        # if st[-1] == '(':     // 틀림
        if exp[i-1] == '(':
            count += st.count('(')
        else:
            count += 1

print(count)