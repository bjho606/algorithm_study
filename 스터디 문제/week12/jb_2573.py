from collections import deque
import sys

input = sys.stdin.readline

N, M = map(int, input().split())
sea = []
for i in range(N):
    sea.append(list(map(int, input().split())))
# print(sea)

dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]
que = deque()
year = 0

# 빙산 상태 확인
def bfs(x, y):
    que.append((x,y))
    while que:
        cur_x, cur_y = que.popleft()
        visited[cur_x][cur_y] = 1
        for d in range(4):
            next_x = cur_x + dx[d]
            next_y = cur_y + dy[d]
            if 0 <= next_x < N and 0 <= next_y < M:
                if sea[next_x][next_y] == 0:
                    count[cur_x][cur_y] += 1
                elif sea[next_x][next_y] != 0 and visited[next_x][next_y] == 0:
                    que.append((next_x, next_y))
                    visited[next_x][next_y] = 1

while True:
    count = [[0 for _ in range(M)] for _ in range(N)]
    visited = [[0 for _ in range(M)] for _ in range(N)]
    ice = 0

    # 빙산 개수 구하기, 상태 저장
    for i in range(N):
        for j in range(M):
            if sea[i][j] != 0 and visited[i][j] == 0:
                ice += 1
                bfs(i,j)

    # 빙산 깎기
    for i in range(N):
        for j in range(M):
            sea[i][j] -= count[i][j]
            if sea[i][j] < 0:
                sea[i][j] = 0

    # 빙산 개수 구하기
    if ice == 0:
        print(ice)
        exit()
    elif ice > 1:
        print(year)
        exit()

    year += 1