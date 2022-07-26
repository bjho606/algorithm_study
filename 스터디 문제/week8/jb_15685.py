'''
    [gen] : [dir]
    0 gen : 0
    1 gen : 0 -> 1
    2 gen : 0 1 -> 2 1
    3 gen : 0 1 2 1 -> 2 3 2 1
    4 gen : 0 1 2 1 2 3 2 1 -> 2 3 0 3 2 3 2 1
'''

import sys

input = sys.stdin.readline

N = int(input())
board = [[0] * 101 for _ in range(101)]
dx = [1, 0, -1, 0]
dy = [0, -1, 0, 1]

for i in range(N):
    x, y, d, g = map(int, input().split())
    board[x][y] = 1

    # 방향 추가
    dirs = [d]
    for gen in range(g):
        back_dir = []
        for k in range(len(dirs)):
            back_dir.append((dirs[-k - 1] + 1) % 4)
        dirs.extend(back_dir)
    # print(dirs)

    # 그래프 그리기
    for dir in dirs:
        next_x = x + dx[dir]
        next_y = y + dy[dir]
        board[next_x][next_y] = 1
        x, y = next_x, next_y

ans = 0
for i in range(100):
    for j in range(100):
        if board[i][j] == 1 and board[i+1][j] == 1 and board[i][j+1] == 1 and board[i+1][j+1] == 1:
            ans += 1

print(ans)