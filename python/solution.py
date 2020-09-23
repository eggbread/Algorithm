def solution_68644(numbers):
    answer = set()
    """
    프로그래머스 : 두 개 뽑아서 더하기
    Θ(n^2)
    """
    for i, x in enumerate(numbers):
        for y in numbers[i + 1:]:
            answer.add(x + y)
    return sorted(answer)


def solution_64061(board, moves):
    """
    프로그래머스 : 크레인 인형뽑기 게임
    Θ(n^2)
    Stack 사용 문제
    """
    answer = 0
    result = list()
    for move in moves:
        dool = 0
        idx = 0
        while board[idx][move - 1] < 1 and idx < len(board) - 1:
            idx += 1

        if dool == 0:
            continue
        else:
            dool = board[idx][move - 1]
            board[idx][move - 1] = 0

        if len(result):
            if result[-1] == dool:
                result.pop()
                answer += 1
            else:
                result.append(dool)
        else:
            result.append(dool)
    return answer * 2


def solution_42587(priorities, location):
    """
    프로그래머스 : 프린터
    Θ(n)
    Queue 사용 문제
    """
    answer = 0
    while True:
        if len(priorities) < 2:
            answer += 1
            break
        else:
            value = priorities[0]
            priorities.pop(0)
            if value >= max(priorities):
                answer += 1
                if location:
                    location -= 1
                else:
                    break
            else:
                if location:
                    location -= 1
                else:
                    location = len(priorities)
                priorities.append(value)
    return answer


def solution_42895(N, number):
    """
    프로그래머스 : N으로 표현
    Θ(?)
    n번의 사용으로 만들어진 숫자는 1, n-1 ~ n-1, 1의 숫자들의 사칙연산의 조합이다.
    """
    sets = [set()]
    answer = 9
    for i in range(1, 9):
        sets.append(set())
        sets[i].add(int(str(N) * i))
    if number == N:
        return 1
    for i in range(2, 8):
        for j in range(1, i):
            for a in sets[j]:
                for b in sets[i - j]:
                    sets[i].add(a + b)
                    sets[i].add(a - b)
                    sets[i].add(a * b)
                    if b:
                        sets[i].add(a // b)
        if number in sets[i]:
            if answer > i:
                answer = i
            break

    if answer == 9:
        return -1
    else:
        return answer


def solution_43162_1(n, computers):
    """
    프로그래머스 : 네트워크
    Θ(n^2)
    Stack을 이용한 DFS
    """
    answer = 0
    check = [False for _ in range(n)]
    for i, item in enumerate(check):
        if not item:
            stack = [i]
            answer += 1
            while stack:
                idx = stack.pop()
                check[idx] = True
                for index, x in enumerate(computers[idx]):
                    if not check[index] and x == 1 and idx != index:
                        stack.append(index)
    return answer


def solution_43162_2(n, computers):
    """
    프로그래머스 : 네트워크
    Θ(n^2)
    재귀를 이용한 DFS
    """
    answer = 0
    check = [False for _ in range(n)]
    for i, item in enumerate(check):
        if not item:
            answer += 1
            DFS(computers, i, check)
    return answer


def DFS_43162(computers, n, check):
    check[n] = True
    for i, x in enumerate(computers[n]):
        if x == 1 and not check[i] and i != n:
            DFS(computers, i, check)


def solution_43165(numbers, target):
    """
    프로그래머스 : 타겟 넘버
    Θ(lgn)
    Queue를 이용한 DFS
    시간초과 때문에 Bottom-up이 아니라 Up-bottom으로 해야한다.
    """
    stack = [target + numbers[0], target - numbers[0]]
    sums = sum(numbers) - numbers[0]
    for i in numbers[1:]:
        sums -= i
        for _ in range(len(stack)):
            num = stack.pop(0)
            temp = num + i
            if temp - sums <= 0:
                stack.append(temp)
            temp = num - i
            if temp + sums >= 0:
                stack.append(temp)

    return stack.count(0)


def solution_43163(begin, target, words):
    """
    프로그래머스 : 단어 변환
    Θ(n^2)
    Stack을 이용한 DFS
    """
    answer = 0
    if target not in words:
        return 0
    q = [begin]
    found = [False for _ in range(len(words))]
    while q:
        word = q.pop()
        if target == word:
            return answer
        for idx, item in enumerate(words):
            if check_word(word, item) and not found[idx]:
                found[idx] = True
                q.append(item)
        answer += 1
    return 0


def check_word(A, B):
    cnt = 0
    for i in range(len(A)):
        if A[i] != B[i]:
            cnt += 1
    if cnt == 1:
        return True
    else:
        return False


import itertools


def solution_42839(numbers):
    """
    프로그래머스 : 소수 찾기
    O(n^2)
    brute force로 다 돌며 찾기
    """
    answer = 0
    for i in range(1, len(numbers) + 1):
        number_list = set(map(''.join, itertools.permutations(list(numbers), i)))
        for item in number_list:
            if item[0] != '0':
                number = int(item)
                if isPrime(number):
                    answer += 1
    return answer


def isPrime(a):
    if (a < 2):
        return False
    for i in range(2, a):
        if (a % i == 0):
            return False
    return True

def solution_42840(answers):
    """
    프로그래머스 : 모의고사
    Θ(n)
    완전 탐색
    """
    first = [1, 2, 3, 4, 5]
    second = [2, 1, 2, 3, 2, 4, 2, 5]
    third = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]
    first_score = 0
    second_score = 0
    third_score = 0
    for i in range(len(answers)):
        if answers[i] == first[i%5]:
            first_score += 1
        if answers[i] == second[i%8]:
            second_score += 1
        if answers[i] == third[i%10]:
            third_score += 1
    persons = [first_score,second_score,third_score]
    max_value = max(persons)

    return [i+1 for i,j in enumerate(persons) if j == max_value]

def solution_(brown, yellow):
    """
    프로그래머스 : 카펫
    Θ(n)
    완전 탐색
    """
    answer = []
    n = int((brown - 4) / 2)
    for i in range(1,n//2+1):
        width = n - i
        height = i
        if width * height == yellow:
            return [width+2, height+2]
    return answer

def solution_184169(n):
    """
    프로그래머스 : 멀리뛰기
    Matrix Fibonacci
    """
    x = pow(n)
    return x[0] % 1234567

def pow(n):
    if n < 2:
        return [1, 1, 1, 0]
    if n % 2:#odd
        x = pow((n-1)/2)
        return mul(mul(x,x),[1,1,1,0])
    else:#even
        x = pow(n/2)
        return mul(x,x)

def mul(A,B):
    return [A[0]*B[0]+A[1]*B[2], A[0]*B[1]+A[1]*B[3], A[2]*B[0]+A[3]*B[2], A[2]*B[1]+A[3]*B[3]]

def Queue(n):
    """
    프로그래머스 : 멀리뛰기
    Queue를 이용한 BFS
    """
    queue = [n]
    answer = 0
    while queue:
        item = queue.pop(0)
        if item == 1:
            answer += 1
        elif item == 2:
            answer += 2
        else:
            queue.append(item - 1)
            queue.append(item - 2)
    return answer

def DFS(n):
    """
    프로그래머스 : 멀리뛰기
    재귀를 이용한 DFS
    """
    result = 0
    if n > 0:
        if n == 2:
            return 2
        if n == 1:
            return 1
        result += DFS(n-1)
        result += DFS(n-2)
    return result


from collections import defaultdict


def solution_49191(n, results):
    """
    프로그래머스 : 순위
    """
    answer = 0
    wins = defaultdict(set)
    loses = defaultdict(set)

    for a, b in results:
        wins[a].add(b)
        loses[b].add(a)

    for i in range(1, n + 1):
        for loser in wins[i]:
            loses[loser] |= loses[i]
        for winner in loses[i]:
            wins[winner] |= wins[i]

    for i in range(1, n + 1):
        if len(wins[i]) + len(loses[i]) == n - 1:
            answer += 1

    return answer

import heapq
def solution(scoville, K):
    """
    프로그래머스 : 더 맵게
    Θ(n^2)
    minheap을 이용한 탐색
    """
    answer = 0
    heapq.heapify(scoville)
    while scoville[0] < K:
        if len(scoville) < 2:
            return -1
        answer += 1
        one = heapq.heappop(scoville)
        two = heapq.heappop(scoville)
        heapq.heappush(scoville,one + two * 2)
    return answer


if __name__ == '__main__':
    scoville = [1, 2]
    K = 7
    print(solution(scoville, K))
