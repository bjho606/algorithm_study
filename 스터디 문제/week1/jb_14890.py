import sys

input = sys.stdin.readline

def check(li):
    for i in range(N-1):
        # 4. 높이 차이가 1 이상
        if abs(li[i] - li[i+1]) > 1:
            return 0

        # 왼쪽이 더 작으면, 현재 위치부터 왼쪽을 탐색하여 경사로 설치 가능 여부조사
        if li[i] < li[i+1]:
            for j in range(L):
                # 1. 경사로 놓을 공간 없음
                if i-j < 0:
                    return 0
                # 2. 이미 경사로가 놓임
                if taken[i-j] == 1:
                    return 0
                # 3. 낮은 지점의 칸의 높이가 모두 같지 않음
                if li[i] != li[i-j]:
                    return 0
                
            # 다 괜찮으면 경사로 놓기
            for j in range(L):
                taken[i-j] = 1

        # 오른쪽이 더 작으면, 현재 위치부터 오른쪽을 탐색하여 경사로 설치 가능 여부조사
        elif li[i] > li[i+1]:
            for j in range(L):
                # 1. 경사로 놓을 공간 없음
                if i+1+j > N-1:
                    return 0
                # 2. 이미 경사로가 놓임
                if taken[i+1+j] == 1:
                    return 0
                # 3. 낮은 지점의 칸의 높이가 모두 같지 않음
                if li[i+1] != li[i+1+j]:
                    return 0
                
            # 다 괜찮으면 경사로 놓기
            for j in range(L):
                taken[i+1+j] = 1

    return 1

N, L = map(int, input().split())

ans = 0

# 테스트
# taken = [0 for _ in range(N)]
# row = list(map(int, input().split()))
# print(check(row))

map = [list(map(int, input().split())) for _ in range(N)]
# print(map)
for i in range(N):
    taken = [0 for _ in range(N)]
    # 행 체크
    if check(map[i]) == 1:
        ans += 1

for i in range(N):
    taken = [0 for _ in range(N)]
    # 열 체크
    if check([col[i] for col in map]) == 1:
        ans += 1

print(ans)