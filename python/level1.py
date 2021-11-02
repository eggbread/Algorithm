
def solution_77484(lottos, win_nums):
    """
    time : nlogn(sort) + n(for) + logn(binary search) < n^2
    url : https://programmers.co.kr/learn/courses/30/lessons/77484
    """
    win_nums.sort()
    cnt = 1
    zeros = 0
    for num in lottos:
        if num:
           if not binary_search(num, win_nums):
                cnt += 1
        else:
            zeros += 1
    return [min(cnt,6), min(cnt+zeros,6)]

def binary_search(num, win_nums):
    if len(win_nums) == 1:
        return num == win_nums[0]
    else:
        pivot = win_nums[int(len(win_nums)/2)]
        if pivot == num:
            return True
        elif num > pivot:
            return binary_search(num, win_nums[int(len(win_nums)/2):])
        else:
            return binary_search(num, win_nums[:int(len(win_nums) / 2)])

if __name__ == '__main__':
    pass