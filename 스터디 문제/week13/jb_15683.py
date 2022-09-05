# ㅠㅠㅠㅠ...

import copy
import sys

input = sys.stdin.readline

N, M = map(int, input().split())
office = [list(map(int, input().split())) for _ in range(N)]
# print(office)

cameras = []    # x, y, camera_type
for i in range(N):
    for j in range(M):
        if office[i][j] != 0 and office[i][j] != 6:
            cameras.append((i,j,office[i][j]))

# 동,북,서,남
dx = [0, -1, 0, 1]
dy = [1, 0, -1, 0]

direction = {
    1: [[0], [1], [2], [3]],
    2: [[0, 2], [1, 3]],
    3: [[0, 1], [1, 2], [2, 3], [3, 0]],
    4: [[0,1,2], [1,2,3], [2,3,0], [3,0,1]],
    5: [[0,1,2,3]]
}

def count_zero(board):
    zeros = 0
    for i in range(N):
        for j in range(M):
            if board[i][j] == 0:
                zeros += 1

    return zeros

def watch(x, y, directions, board):
    for dir in directions:
            next_x, next_y = x, y
            while True:
                next_x += dx[dir]
                next_y += dy[dir]
                # 범위 아웃
                if next_x < 0 or next_x >= N or next_y < 0 or next_y >= M:
                    break
                # 벽 만난 경우
                if board[next_x][next_y] == 6:
                    break
                if board[next_x][next_y] == 0:
                    board[next_x][next_y] = -1

def dfs(office, depth):
    global ans

    # 확인
    # for i in range(N):
    #     print(office[i])
    # print()

    if depth == len(cameras):
        ans = min(ans, count_zero(office))
        return
    else:
        office_copy = copy.deepcopy(office)             ### 왜 배열 복사를 하는걸까...?
        cur_x, cur_y, camera_type = cameras[depth]
        for dirs in direction[camera_type]:
            watch(cur_x, cur_y, dirs, office_copy)

            dfs(office_copy, depth + 1)

            office_copy = copy.deepcopy(office)

ans = N*M

dfs(office, 0)

print(ans)