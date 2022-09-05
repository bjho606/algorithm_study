from itertools import combinations
import sys

input = sys.stdin.readline

N, M = map(int, input().split())
city = [[0]*(N+1)] + [([0] + list(map(int, input().split()))) for _ in range(N)]
# print(city)

def get_dist(x1, y1, x2, y2):
    return (abs(x1-x2) + abs(y1-y2))

houses = []
chickens = []
for i in range(1,N+1):
    for j in range(1, N+1):
        if city[i][j] == 2:
            chickens.append((i,j))
        elif city[i][j] == 1:
            houses.append((i,j))

ans = 100000

# 고를 수 있는 모든 치킨집의 경우의 수
for chicken in combinations(chickens, M):
    # print(chicken)
    sum_dist = 0    # 도시의 치킨 거리

    # 고른 치킨집들로부터 모든 집들의 거리
    for house_coords in houses:
        house_x, house_y = house_coords
        min_dist = 100000   # 치킨 거리

        # 한 집으로부터 가장 가까운 치킨거리 구하기
        for chicken_coords in chicken:
            chicken_x, chicken_y = chicken_coords
            # print(chicken_coords, house_coords)
            min_dist = min(min_dist, get_dist(chicken_x, chicken_y, house_x, house_y))

        sum_dist += min_dist    # 도시의 치킨 거리 = (치킨 거리)들의 합

    ans = min(ans, sum_dist)

print(ans)