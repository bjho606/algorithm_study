# fail..

import sys

input = sys.stdin.readline

board = []
dx = [0, 0, -1, 1]
dy = [1, -1, 0, 0]

N, M, x, y, K = map(int, input().split())

for i in range(N):
    board.append(list(map(int, input().split())))

# print(board)
