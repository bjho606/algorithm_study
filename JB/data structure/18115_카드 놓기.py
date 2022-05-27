from collections import deque
import sys

input = sys.stdin.readline

N = int(input())

# r_card = [i for i in range(1, N+1)]
# card = []
card = deque()

method = list(map(int, input().split()))

for idx, seq in enumerate(reversed(method)):
    if seq == 1:
        # card.insert(0, idx+1)
        card.appendleft(idx+1)
    elif seq == 2:
        card.insert(1, idx+1)
    elif seq == 3:
        card.append(idx+1)

# print(' '.join(o_card))
print(*card)
