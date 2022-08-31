import sys

input = sys.stdin.readline

N, M = map(int, input().split())

board = [list(map(int, input().split())) for _ in range(N)]
# print(board)
visited = [[0 for _ in range(M)] for _ in range(N)]

dx = [0, 0, -1, 1]
dy = [1, -1, 0, 0]
ans = 0

def dfs(x,y, tet_sum, count):
    global ans

    if count >= 4:
        ans = max(ans, tet_sum)
        return

    for d in range(4):
        next_x = x + dx[d]
        next_y = y + dy[d]
        if 0 <= next_x < N and 0 <= next_y < M and not visited[next_x][next_y]:
            visited[next_x][next_y] = 1

            # 'ㅗ' 예외 처리
            if count == 2:
                dfs(x, y, tet_sum + board[next_x][next_y], count + 1)
            
            dfs(next_x, next_y, tet_sum + board[next_x][next_y], count + 1)

            visited[next_x][next_y] = 0

# 'ㅗ' 모양은 따로 처리해야함
def oh(x, y):
    global ans

    for d in range(4):
        temp = board[x][y]

        for dir in ((d-1)%4, d, (d+1)%4):
            next_x, next_y = x + dx[dir], y + dy[dir]
            if 0 <= next_x < N and 0 <= next_y < M:
                temp += board[next_x][next_y]
            else:
                temp = 0
                break

        ans = max(ans, temp)

for i in range(N):
    for j in range(M):
        visited[i][j] = 1
        dfs(i,j, board[i][j], 1)
        visited[i][j] = 0
        # oh(i,j)

print(ans)