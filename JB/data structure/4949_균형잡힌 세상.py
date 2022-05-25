import sys

input = sys.stdin.readline

while(True):
    line = input()

    if line.rstrip('\n') == '.':
        break

    flag = False
    st = []
    for word in line:
        if word == '(' or word == '[':
            st.append(word)
        elif word == ')':
            if not st or st[-1] != '(':
                flag = True
                break
            else:
                st.pop()
        elif word == ']':
            if not st or st[-1] != '[':
                flag = True
                break
            else:
                st.pop()

    if flag == False and not st:
        print('yes')
    else:
        print('no')