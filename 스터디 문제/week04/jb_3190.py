from collections import deque
import sys

input = sys.stdin.readline

N = int(input())
board = [[0]*(N+1) for _ in range(N+1)]     # board:0, snake:1, apple:2
# print(board)
K = int(input())
for k in range(K):
    col, row = map(int, input().split())
    board[col][row] = 2
L = int(input())
dirInfo = dict()
for l in range(L):
    X, C = input().split()
    dirInfo[int(X)] = C
# print(dirInfo)

dx, dy = [0, 1, 0, -1], [1, 0, -1, 0]
ans = 0

direction = 0
head_x, head_y = 1, 1
snake = deque()
snake.append((1,1))

def turn(c):
    global direction
    if c == 'L':
        direction = (direction - 1) % 4     # -1 % 4 == 3
    elif c == 'D':
        direction = (direction + 1) % 4

while True:
    ans += 1
    head_x += dx[direction]
    head_y += dy[direction]
    if head_x < 1 or head_x > N or head_y < 1 or head_y > N or board[head_x][head_y] == 1:
        break
    
    if board[head_x][head_y] == 2:
        board[head_x][head_y] = 1
        snake.append((head_x, head_y))

    elif board[head_x][head_y] == 0:
        board[head_x][head_y] = 1
        snake.append((head_x, head_y))
        del_x, del_y = snake.popleft()
        board[del_x][del_y] = 0

    if ans in dirInfo.keys():
        turn(dirInfo[ans])

print(ans)