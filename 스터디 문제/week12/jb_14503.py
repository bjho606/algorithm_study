import sys

input = sys.stdin.readline

N, M = map(int, input().split())
r, c, d = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(N)]
# print(board)

# 북, 동, 남, 서
dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

cleaned = [[0 for _ in range(M)] for _ in range(N)]
count = 0

cur_x, cur_y = r, c
dir = d
# board[r][c] = 2

temp = 0
while True:
    # print(cur_x, cur_y)
    # 1. 청소
    if cleaned[cur_x][cur_y] == 0:
        cleaned[cur_x][cur_y] = 1
        count += 1

    # 왼쪽 보기
    dir -= 1
    if dir < 0:
        dir = 3

    next_x, next_y = cur_x + dx[dir], cur_y + dy[dir]

    # 2-1. 왼쪽 방향에 아직 청소하지 않은 공간이 존재한다면, 그 방향으로 회전한 다음 한 칸을 전진하고 1번부터 진행한다.
    if board[next_x][next_y] == 0 and cleaned[next_x][next_y] == 0:
        cur_x, cur_y = next_x, next_y
        temp = 0
        continue

    # 2-2. 왼쪽 방향에 청소할 공간이 없다면, 그 방향으로 회전하고 2번으로 돌아간다.
    else:
        temp += 1

    if temp >= 4:
        # print(dir, dx[dir], dy[dir])
        next_x, next_y = cur_x - dx[dir], cur_y - dy[dir]
        # 2-3. 네 방향 모두 청소가 이미 되어있거나 벽인 경우에는, 바라보는 방향을 유지한 채로 한 칸 후진을 하고 2번으로 돌아간다.
        if board[next_x][next_y] == 0:
            cur_x, cur_y = next_x, next_y

        # 2-4. 네 방향 모두 청소가 이미 되어있거나 벽이면서, 뒤쪽 방향이 벽이라 후진도 할 수 없는 경우에는 작동을 멈춘다.
        else:
            break
        
        temp = 0

print(count)