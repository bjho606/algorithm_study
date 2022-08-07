from collections import deque
import sys
sys.setrecursionlimit(100000)

input = sys.stdin.readline

dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]

N = int(input())

board = [[]*N for _ in range(N)]
# visited = [[0]*N]*N   // 이렇게 선언하면 개망함..!!!!!!!!

for i in range(N):
    board[i] = list(map(int, input().split()))
# print(board)

min_height = min(min(board))
max_height = max(max(board))
# print(min_height, max_height)

def dfs(x, y):
    global h, area
    visited[x][y] = area
    
    for d in range(4):
        next_x = x + dx[d]
        next_y = y + dy[d]
        
        # 범위 체크
        if next_x < 0 or next_x >= N or next_y < 0 or next_y >= N:
            continue
        # 물에 잠기는지 체크
        if board[next_x][next_y] <= h:
            continue
        # 방문했는지 체크
        if visited[next_x][next_y]:
            continue

        dfs(next_x, next_y)

        # if 0 <= next_x < N and 0 <= next_y < N:
        #     if board[next_x][next_y] > h and not visited[next_x][next_y]:
        #         dfs(next_x, next_y)

# def bfs(x, y):
#     global h, area
#     q = deque()
#     q.append((x,y))
#     visited[x][y] = area

#     while q:
#         next_x, next_y = q.popleft()

#         for d in range(4):
#             next_x = x + dx[d]
#             next_y = y + dy[d]

#             # 범위 체크
#             if next_x < 0 or next_x >= N or next_y < 0 or next_y >= N:
#                 continue
#             # 물에 잠기는지 체크
#             if board[next_x][next_y] <= h:
#                 continue
#             # 방문했는지 체크
#             if visited[next_x][next_y]:
#                 continue

#             q.append((next_x, next_y))

ans = 1     # 모두 최소 높이일 때는 지역이 1개밖에 없으므로 0이 아닌 1로 설정해야함!!!!
for h in range(max_height):
    # 세팅 초기화
    area = 0
    visited = [[0] * N for _ in range(N)]

    # 영역 구하기
    for i in range(N):
        for j in range(N):
            if not visited[i][j] and board[i][j] > h:
                # print(i, ",", j)
                area += 1
                dfs(i, j)
                # bfs(i, j)
                # print(visited)

    # print(area)
    ans = max(ans, area)

print(ans)