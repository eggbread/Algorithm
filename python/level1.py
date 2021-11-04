
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

def solution(s):
    """
    time : n
    url : https://programmers.co.kr/learn/courses/30/lessons/81301
    """
    dict = {
        "zero":0,
        "one":1,
        "two":2,
        "three":3,
        "four":4,
        "five":5,
        "six":6,
        "seven":7,
        "eight":8,
        "nine":9
    }
    answer = ""
    i = 0
    while i < len(s):
        if s[i].isdigit():
            answer += s[i]
            i+=1
        else:
            if s[i:i+3] in dict:
                answer += str(dict[s[i:i+3]])
                i += 3
            elif s[i:i+4] in dict:
                answer += str(dict[s[i:i+4]])
                i += 4
            elif s[i:i+5] in dict:
                answer += str(dict[s[i:i+5]])
                i += 5
    return int(answer)

if __name__ == '__main__':
    print(solution("123"))