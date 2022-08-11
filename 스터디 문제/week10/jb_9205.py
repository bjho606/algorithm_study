from collections import deque
import sys

input = sys.stdin.readline

def get_distance(x1, y1, x2, y2):
    dist = abs(x1-x2) + abs(y1-y2)
    # print(f"({x1},{y1}) ~ ({x2},{y2}) : {dist}")
    return dist

def bfs(x, y):
    global left_beer
    q = deque()
    q.append((x, y))

    while q:
        cur_x, cur_y = q.popleft()
        if get_distance(cur_x, cur_y, fest_x, fest_y) <= left_beer * 50:
            print("happy")
            return

        for i in range(n):
            next_x, next_y = store[i]

            if not visited[i]:
                if get_distance(cur_x, cur_y, next_x, next_y) > left_beer * 50:
                    continue
                else:
                    left_beer = MAX_BEER
                    visited[i] = 1
                    q.append((next_x, next_y))

    print("sad")

t = int(input())

for _ in range(t):
    n = int(input())
    store = []
    home_x, home_y = map(int, input().split())
    for _ in range(n):
        x, y = map(int, input().split())
        store.append((x,y))
    fest_x, fest_y = map(int, input().split())
    visited = [0] * n
    # print(store)

    MAX_BEER = 20

    left_beer = MAX_BEER
    bfs(home_x, home_y)