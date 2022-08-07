from itertools import combinations
import sys

input = sys.stdin.readline

N = int(input())
S = [list(map(int, input().split())) for _ in range(N)]
arr = [i for i in range(N)]
# print(S)

# 팀의 경우의 수
possible_teams = []
for team in combinations(arr, N//2):
    # print(team)
    possible_teams.append(team)

min_gap = 10000
for i in range(len(possible_teams)//2):
    team1, team2 = possible_teams[i], possible_teams[-i-1]  # 팀의 경우의 수를 출력해보면 가우스 합처럼 짝이 맞다.
    sum1, sum2 = 0, 0
    for j in range(N//2):
        for k in team1:
            sum1 += S[team1[j]][k]
        for k in team2:
            sum2 += S[team2[j]][k]

    min_gap = min(min_gap, abs(sum1 - sum2))    

print(min_gap)