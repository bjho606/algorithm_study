# ㅠㅠㅠㅠ
import sys

input = sys.stdin.readline

# 한 세로선마다 짝수개의 통로가 있어야함
# 짝수개의 통로 사이에 다른 선이 끼어들면 안됨

N, M, H = map(int, input().split())

board = [[0] * (N) for _ in range(H+1)]
# print(board)

# 그림으로 체크
def check_board():
    for i in range(1, H+1):
        for j in range(1, N):
            print(board[i][j], end=' ')
        print()

for i in range(M):
    a, b = map(int, input().split())
    board[a][b] = 1

# check_board()

