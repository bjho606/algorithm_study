import sys

input = sys.stdin.readline

count = 0
computer_count = int(input())
link_count = int(input())

graph = [[] for _ in range(computer_count+1)]

for _ in range(link_count):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)
# print(graph)

visited = [0] * (computer_count + 1)

def dfs(computer):
    global count
    visited[computer] = 1
    for i in graph[computer]:
        if visited[i] == 0:
            dfs(i)
            count += 1

dfs(1)
print(count)
