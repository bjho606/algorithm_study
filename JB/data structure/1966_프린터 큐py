from collections import deque
import sys

input = sys.stdin.readline

T = int(input())
for i in range(T):
    N, M = map(int, input().split())
    count = 0
    script = deque(map(int, input().split()))

    while True:
        if len(script) <= 0:
            break
        if script[0] >= max(script):
            count += 1
            script.popleft()
            if M == 0:
                break
        else:
            script.rotate(-1)
        if M == 0:
            M = len(script) - 1
        else:
            M  -= 1

    print(count)