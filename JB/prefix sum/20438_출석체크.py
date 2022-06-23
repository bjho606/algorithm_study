import sys

input = sys.stdin.readline

N, K, Q, M = map(int, input().split())
students = [0,0,0] + [1] * (N+3)

Ks = list(map(int, input().split()))
Qs = list(map(int, input().split()))

for q in Qs:
    if q in Ks:
        continue
    for i in range(q, N+3, q):
        if i not in Ks:
            students[i] = 0

    # [이 코드는 왜 안돼는거야????????!!!!!!]
    # i = 0
    # while True:
    #     i += 1
    #     if q * i > N+2:
    #         break
        
    #     if (q * i) in Ks:
    #         continue
        
    #     students[q*i] = 0

ps = [0] * (N+3)
ps[3] = students[3]
for n in range(3, N+3):
    ps[n] = students[n] + ps[n-1]

for i in range(M):
    S, E = map(int, input().split())
    print(ps[E] - ps[S-1])