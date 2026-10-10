class Solution:
    def minSumSquareDiff(self, nums1, nums2, k1, k2):
        diff = [abs(a - b) for a, b in zip(nums1, nums2)]
        k = k1 + k2

        if sum(diff) <= k:
            return 0

        diff.sort(reverse=True)

        for i in range(len(diff)):
            if i == len(diff) - 1 or diff[i] > diff[i + 1]:
                level = diff[i + 1] if i < len(diff) - 1 else 0
                cost = (diff[i] - level) * (i + 1)

                if k >= cost:
                    k -= cost
                    diff[:i + 1] = [level] * (i + 1)
                else:
                    q, r = divmod(k, i + 1)
                    diff[:i + 1] = [max(0, diff[i] - q)] * (i + 1)
                    for j in range(r):
                        diff[j] -= 1
                    k = 0
                    break

        return sum(x * x for x in diff)