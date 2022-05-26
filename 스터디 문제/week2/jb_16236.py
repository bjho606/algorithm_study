# bfs 함수 작성도중 풀이 봄
# fish_info를 어떻게 활용할지 전혀 몰랐음, bfs 함수의 역할이 정확히 무엇인지 잘 몰랐음

from collections import deque
import sys

from numpy import size

input = sys.stdin.readline

dx, dy = [1, -1, 0, 0], [0, 0, 1, -1]
shark_size = 2
shark_x, shark_y = 0, 0
fish_cnt = 0
fish_pos = []

N = int(input())

map = [list(map(int, input().split())) for _ in range(N)]

# 초기 환경 파악 - 물고기 수, 물고기 위치, 상어 위치
for i in range(N):
    for j in range(N):
        if 0 < map[i][j] <= 6:
            fish_cnt += 1
            fish_pos.append((i, j))
        elif map[i][j] == 9:
            shark_x, shark_y = i, j
            map[i][j] = 0   # 상어 위치 0으로 통일

# 가장 가까운 물고기 냠냠
def bfs(x, y):
    visited = [[0] * N for _ in range(N)]
    min_dist = [[0] * N for _ in range(N)]
    q = deque()
    q.append((x, y))
    visited[x][y] = 1
    fish_info = []  # fish_x, fish_y, distance between shark <-> fish

    while q:
        cur_x, cur_y = q.popleft()
        for i in range(4):
            next_x, next_y = cur_x + dx[i], cur_y + dy[i]
            if 0 <= next_x < N and 0 <= next_y < N and visited[next_x][next_y] == 0:
            # 자기보다 작거나 같은 물고기 or 빈 칸 만난 경우
                if map[next_x][next_y] <= shark_size:
                    q.append((next_x, next_y))
                    visited[next_x][next_y] = 1
                    min_dist[next_x][next_y] = min_dist[cur_x][cur_y] + 1
                    # 자기보다 작은 물고기 만난 경우
                    if 0 < map[next_x][next_y] < shark_size:
                        fish_info.append((next_x, next_y, min_dist[next_x][next_y]))

    # 최단거리, 가장 왼쪽, 가장 위쪽 순으로 정렬
    fish_info.sort(key=lambda x: (-x[2], -x[0], -x[1]))
    return fish_info

eat_cnt = 0
ans = 0

while True:
    shark = bfs(shark_x, shark_y)

    # 먹을 수 있는 물고기가 없으면 종료
    if not shark:
        break

    next_x, next_y, distance = shark.pop()

    # 이동한 상어 위치 0으로 초기화
    map[next_x][next_y] = 0
    shark_x, shark_y = next_x, next_y

    ans += distance
    eat_cnt += 1

    # 상어 크기와 같은 수의 물고기 먹으면 크기 증가
    if eat_cnt == shark_size:
        shark_size += 1
        eat_cnt = 0

print(ans)