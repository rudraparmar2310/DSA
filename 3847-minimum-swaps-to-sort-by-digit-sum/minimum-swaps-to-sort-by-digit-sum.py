class Solution:
    def minSwaps(self, nums: List[int]) -> int:
        def digit_sum(n):
            return sum(int(d) for d in str(n))

        arr = sorted((digit_sum(n), n, i)
                     for i, n in enumerate(nums))

        visited = [False] * len(nums)
        swaps = 0

        for i in range(len(nums)):
            if visited[i] or arr[i][2] == i:
                continue

            j = i
            cycle = 0

            while not visited[j]:
                visited[j] = True
                j = arr[j][2]
                cycle += 1

            swaps += cycle - 1

        return swaps
