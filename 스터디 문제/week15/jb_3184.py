from collections import deque
import sys

input = sys.stdin.readline

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

def bfs(x, y):
    global sheep, wolf, R, C, field
    cell_sheep, cell_wolf = 0, 0

    q = deque()
    q.append([x, y])
    while q:
        cur_x, cur_y = q.popleft()
        if field[cur_x][cur_y] == 'o':
            cell_sheep += 1
        if field[cur_x][cur_y] == 'v':
            cell_wolf += 1

        for d in range(4):
            next_x, next_y = cur_x + dx[d], cur_y + dy[d]
            if 0 <= next_x < R and 0 <= next_y < C and not visited[next_x][next_y] and field[next_x][next_y] != '#':
                visited[next_x][next_y] = 1
                q.append([next_x, next_y])
    
    if cell_sheep > cell_wolf:
        wolf -= cell_wolf
    else:
        sheep -= cell_sheep


R, C = map(int, input().split())

sheep, wolf = 0, 0
# field = [list(input().strip()) for _ in range(R)]
field = []
for i in range(R):
    temp = list(input().strip())
    # print(temp)
    for j in range(C):
        if temp[j] == 'o':
            sheep += 1
        if temp[j] == 'v':
            wolf += 1
    field.append(temp)
# print(field)
visited = [[0] * C for _ in range(R)]

for i in range(R):
    for j in range(C):
        if field[i][j] == 'v' or field[i][j] == 'o' and not visited[i][j]:
            visited[i][j] = 1
            bfs(i, j)

print(sheep, wolf)