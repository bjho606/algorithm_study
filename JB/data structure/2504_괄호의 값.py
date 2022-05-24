import sys

input = sys.stdin.readline

ip = input().rstrip('\n')
st = []
val_st = []
ans = 0
val = 1

for idx, word in enumerate(ip):
    if word == '(':
        st.append(word)
        val *= 2

    elif word == '[':
        st.append(word)
        val *= 3
        
    elif word == ')':
        if not st or st[-1] == '[':
            ans = 0
            break
        if ip[idx-1] == '(':
            ans += val
        st.pop()
        val //= 2

    elif word == ']':
        if not st or st[-1] == '(':
            ans = 0
            break
        if ip[idx-1] == '[':
            ans += val
        st.pop()
        val //= 3

if st:
    print(0)
else:
    print(ans)