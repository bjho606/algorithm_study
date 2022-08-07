# 모르겠어...ㅠㅠㅠ

import copy
import sys

input = sys.stdin.readline

N, M = map(int, input().split())
min_blind = N * M

board = [list(map(int, input().split())) for _ in range(N)]
# print(board)

# 동,서,남,북
dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]

direction = {
    1: [[0], [1], [2], [3]],
    2: [[0, 2], [1, 3]],
    3: [[0, 1], [1, 2], [2, 3], [3, 0]],
    4: [[0,1,2], [1,2,3], [2,3,0], [3,0,1]],
    5: [[0,1,2,3]]
}

# def dfs(depth, board):
#     global min_blind
#     temp = copy.deepcopy(board)

#     if depth == len(cctv):
#         count = temp.count(0)
#         min_blind = min(min_blind, count)
#         return

    # x, y, cctv_type = cctv[depth]
    # for dir in direction[cctv_type]:


cctv = []

for i in range(N):
    for j in range(M):
        if 0 < board[i][j] < 6:
            cctv.append([i, j, board[i][j]])    # x, y, 종류

dfs(0, board)

print(min_blind)