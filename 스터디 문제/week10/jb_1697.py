from collections import deque
import sys

input = sys.stdin.readline

N, K = map(int, input().split())
visited = [0] * 100001
q = deque()

def bfs(node):
    q.append(node)
    while q:
        cur_node = q.popleft()        
        if cur_node == K:
            print(visited[cur_node])
            exit()

        for next_node in (cur_node - 1, cur_node + 1, cur_node * 2):
            if next_node < 0 or next_node > 100000 or visited[next_node]:
                continue

            visited[next_node] = visited[cur_node] + 1
            q.append(next_node)

bfs(N)