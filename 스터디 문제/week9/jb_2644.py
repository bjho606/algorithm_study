import sys

input = sys.stdin.readline

n = int(input())
graph = [[] for _ in range(n+1)]

a, b = map(int, input().split())
m = int(input())

for _ in range(m):
    x, y = map(int, input().split())

    graph[x].append(y)
    graph[y].append(x)
# print(graph)

chon = 0
visited = [0] * (n+1)

def dfs(family):
    global chon
    # print(chon)
    visited[family] = 1
    if family == b:
        print(chon)
        exit()

    chon += 1
    for i in graph[family]:
        if visited[i] == 0:
            dfs(i)
            chon -= 1


dfs(a)
if visited[b] > 0:
    print(chon)
else:
    print(-1)