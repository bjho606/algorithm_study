# 인덱스로 커서 위치 조절하며 푸는 방법 -> 삽입/삭제 시 뒤에 있는 모든 문자의 위치를 옮겨야 하기 때문에 시간초과!

import sys

input = sys.stdin.readline

T = int(input())
for _ in range(T):
    l_st, r_st = [], []
    ip = input().rstrip('\n')
    # index = 0
    for word in ip:
        if 'a' <= word <= 'z' or 'A' <= word <= 'Z' or '0' <= word <= '9':
            # st.insert(index, word)
            # index += 1
            l_st.append(word)
        elif word == '<':
            # if st:
            #     index -= 1
            if l_st:
                r_st.append(l_st.pop())
        elif word == '>':
            # if index < len(st):
            #     index += 1
            if r_st:
                l_st.append(r_st.pop())
        elif word == '-':
            # if st:
            #     st.pop()
            if l_st:
                l_st.pop()
        # print(index, st)
    l_st.extend(reversed(r_st))

    # for key in st:
    #     print(key, end='')
    print(''.join(l_st))