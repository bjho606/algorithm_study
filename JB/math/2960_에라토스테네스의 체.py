import sys

input = sys.stdin.readline

N, K = map(int, input().split())

nums = []
count = 0

for i in range(2, N+1):
    nums.append(i)

while len(nums) > 0:
    prime = nums[0]
    for i in range(prime, nums[len(nums) - 1] + 1, prime):
        # print(i)
        if nums.count(i) > 0:
            count += 1
            if count == K:
                print(i)
                exit()
            nums.remove(i)

