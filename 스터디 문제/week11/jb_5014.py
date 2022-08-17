from collections import deque
import sys

input = sys.stdin.readline

F, S, G, U, D = map(int, input().split())

building = [-1 for _ in range(F+1)]
# print(building)
building[S] = 0
q = deque()
q.append(S)

def bfs(floor):
    global count
    while q:
        cur_floor = q.popleft()

        if cur_floor == G:
            print(building[G])
            exit()

        for next_floor in (cur_floor + U, cur_floor - D):
            if next_floor < 1 or next_floor > F:
                continue
            if building[next_floor] != -1:
                continue

            building[next_floor] = building[cur_floor] + 1
            q.append(next_floor)

    print('use the stairs')

bfs(S)