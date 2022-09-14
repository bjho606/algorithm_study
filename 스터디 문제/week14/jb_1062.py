import sys

input = sys.stdin.readline

N, K = map(int, input().split())
K -= 5      # a, n, t, i, c
default_alphabet = ['a', 'n', 't', 'i', 'c']

# 예외 조건
if K < 0:
    print(0)
    exit()

words = []
alphabet_used = [0] * 26
# print(ord('a'))   # a = 97
for used in default_alphabet:
    alphabet_used[ord(used) - 97] = 1
# print(alphabet_used)

# def check_updates(learned_alphabet, words):


for i in range(N):
    origin_word = input()
    final_word = ''     # 최종 가공된 글자
    # anta, tica 제거
    trimmed_word = origin_word[4:-5]
    # print(trimmed_word)
    for alphas in trimmed_word:
        # a, n, t, i, c 포함하는 글자 제거
        if alphas in default_alphabet:
            continue
        # 중복되는 글자 제거
        if alphas in final_word:
            continue

        final_word += alphas
        # print(final_word)

    words.append(final_word)
print(words)

# for word in words:
