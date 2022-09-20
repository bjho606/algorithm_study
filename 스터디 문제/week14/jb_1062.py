from itertools import combinations
import sys

input = sys.stdin.readline

N, K = map(int, input().split())
alphabets = set(chr(i) for i in range(97, 123))
K -= 5      # a, n, t, i, c
default_alphabet = {'a', 'n', 't', 'i', 'c'}
alphabets -= default_alphabet
# print(alphabets)

words = []

# 문자 가공
for i in range(N):
    origin_word = input()
    final_word = set(origin_word.rstrip()[4:-4]) - default_alphabet

    words.append(final_word)
# print(words)

learned_alphabet = [0] * 26
for i in default_alphabet:
    learned_alphabet[ord(i)-97] = 1
# print(learned_alphabet)

# 예외 조건
if K < 0:
    print(0)
    exit()

ans = 0

for combi_alpha in combinations(alphabets, K):
    # 조합의 단어 1로 표시
    for ca in combi_alpha:
        # print(ca)
        learned_alphabet[ord(ca)-97] = 1

    count = 0
    for word in words:
        # print(word)
        temp = 0
        for w in word:
            if learned_alphabet[ord(w)-97] == 0:
                temp = 1
                break
        if temp == 0:
            count += 1

    ans = max(ans, count)

    # 조합의 단어 다시 0으로 초기화
    for ca in combi_alpha:
        learned_alphabet[ord(ca)-97] = 0

# # --- 시간 초과
# for combi_alpha in combinations(alphabets, K):
#     # print(combi_alpha)
#     count = 0
#     for word in words:
#         # temp = len(word)
#         # print(word, temp)
#         if not word - set(combi_alpha):
#             count += 1

#     ans = max(ans, count)

print(ans)