from collections import deque
import sys

input = sys.stdin.readline

dx = [1, -1, 0, 0, 0, 0]
dy = [0, 0, 1, -1, 0, 0]
dz = [0, 0, 0, 0, 1, -1]

M, N, H = map(int, input().split())

board = []

for i in range(H):
    board.append([])
    for j in range(N):
        board[i].append(list(map(int, input().split())))
# print(board)

q = deque()
for i in range(H):
    for j in range(N):
        for k in range(M):
            if board[i][j][k] == 1:
                q.append([i, j, k])

def bfs():
    while q:
        z, x, y = q.popleft()

        for d in range(6):
            next_z = z + dz[d]
            next_x = x + dx[d]
            next_y = y + dy[d]

            if 0 <= next_z < H and 0 <= next_x < N and 0 <= next_y < M:
                if board[next_z][next_x][next_y] == 0:
                    board[next_z][next_x][next_y] = board[z][x][y] + 1
                    q.append([next_z, next_x, next_y])
        
bfs()
# print(board)

ans = -1
for i in range(H):
    for j in range(N):
        for k in range(M):
            if board[i][j][k] == 0:
                print(-1)
                exit()

        ans = max(ans, max(board[i][j]))
        # print(ans)

print(ans - 1)