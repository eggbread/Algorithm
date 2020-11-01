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
        if answers[i] == first[i % 5]:
            first_score += 1
        if answers[i] == second[i % 8]:
            second_score += 1
        if answers[i] == third[i % 10]:
            third_score += 1
    persons = [first_score, second_score, third_score]
    max_value = max(persons)

    return [i + 1 for i, j in enumerate(persons) if j == max_value]


def solution_(brown, yellow):
    """
    프로그래머스 : 카펫
    Θ(n)
    완전 탐색
    """
    answer = []
    n = int((brown - 4) / 2)
    for i in range(1, n // 2 + 1):
        width = n - i
        height = i
        if width * height == yellow:
            return [width + 2, height + 2]
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
    if n % 2:  # odd
        x = pow((n - 1) / 2)
        return mul(mul(x, x), [1, 1, 1, 0])
    else:  # even
        x = pow(n / 2)
        return mul(x, x)


def mul(A, B):
    return [A[0] * B[0] + A[1] * B[2], A[0] * B[1] + A[1] * B[3], A[2] * B[0] + A[3] * B[2], A[2] * B[1] + A[3] * B[3]]


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
        result += DFS(n - 1)
        result += DFS(n - 2)
    return result


def solution_49191(n, results):
    """
    프로그래머스 : 순위
    """
    from collections import defaultdict
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


def solution_42626(scoville, K):
    """
    프로그래머스 : 더 맵게
    Θ(n^2)
    minheap을 이용한 탐색
    """
    import heapq
    answer = 0
    heapq.heapify(scoville)
    while scoville[0] < K:
        if len(scoville) < 2:
            return -1
        answer += 1
        one = heapq.heappop(scoville)
        two = heapq.heappop(scoville)
        heapq.heappush(scoville, one + two * 2)
    return answer


def solution_42628(operations):
    """
    프로그래머스 : 이중우선순위큐
    Θ(n^2)
    deque를 이용한 정렬 큐
    """
    from collections import deque
    dq = deque()
    for item in operations:
        command = item.split()
        if command[0] == 'I':
            dq.append(int(command[1]))
            dq = deque(sorted(dq))
        if dq and command[0] == 'D':
            if command[1] == '1':
                dq.pop()
            if command[1] == '-1':
                dq.popleft()
    if dq:
        return [dq.pop(), dq.popleft()]
    return [0, 0]


def solution_42584(prices):
    """
    프로그래머스 : 주식 가격
    """
    answer = [0] * len(prices)
    stack = [0]
    for time in range(1, len(prices)):
        while stack and prices[stack[-1]] > prices[time]:
            top = stack.pop()
            answer[top] = time - top
        stack.append(time)
    for item in stack:
        answer[item] = len(prices) - 1 - item
    return answer


def solution_42586(progresses, speeds):
    """
    프로그래머스 : 기능 개발
    Θ(N)
    """
    answer = []
    day = 0
    while progresses:
        speed = speeds.pop(0)
        task = progresses.pop(0) + day * speed
        if task < 100:
            if (100 - task) % speed:
                day += (100 - task) // speed + 1
            else:
                day += (100 - task) // speed
            answer.append(1)
        else:
            answer[-1] += 1
    return answer


def solution_12927(n, works):
    """
    프로그래머스 : 야근 지수
    """
    import heapq
    answer = 0
    if sum(works) <= n:
        return 0
    tasks = []
    for i in works:
        heapq.heappush(tasks, (-i, i))
    for i in range(n):
        task = heapq.heappop(tasks)
        heapq.heappush(tasks, (task[0] + 1, task[1] - 1))
    for i in tasks:
        answer += i[1] ** 2
    return answer


def solution_43238(n, times):
    """
    프로그래머스 : 입국 심사
    """
    start = 1
    end = max(times) * n
    answer = 0
    while start <= end:
        sum_value = 0
        time = (end + start) // 2
        for item in times:
            sum_value += time // item
        if sum_value >= n:
            answer = time
            end = time - 1
        elif sum_value < n:
            start = time + 1
    return answer


def solution_43105(triangle):
    """
    프로그래머스 : 정수 삼각형
    :Θ(n^2)
    DP
    """
    for i in range(1, len(triangle)):
        for j in range(len(triangle[i])):
            if j == 0:
                triangle[i][j] += triangle[i - 1][0]
            elif j == len(triangle[i]) - 1:
                triangle[i][j] += triangle[i - 1][len(triangle[i - 1]) - 1]
            else:
                triangle[i][j] += max(triangle[i - 1][j - 1], triangle[i - 1][j])

    return max(triangle[-1])


def solution_12910(arr, divisor):
    """
    프로그래머스 : 나누어 떨어지는 숫자 배열
    Θ(n)
    """
    answer = []
    for item in arr:
        if item % divisor == 0:
            answer.append(item)
    if len(answer) == 0:
        return [-1]
    else:
        return sorted(answer)


def solution_12912(a, b):
    """
    프로그래머스 : 두 정수 사이의 합
    Θ(n)
    """
    answer = 0
    if a == b:
        return a
    else:
        if a > b:
            mx = a
            mn = b
        else:
            mx = b
            mn = a
        for i in range(mn, mx + 1):
            answer += i
    return answer


def solution_42862(n, lost, reserve):
    """
    프로그래머스 : 체육복
    Greedy
    """
    answer = 0
    check = [1 if i + 1 not in lost else 0 for i in range(n)]
    for i in reserve:
        check[i - 1] += 1
    if check[0] == 0 and check[1] == 2:
        check[0] = 1
        check[1] = 1
    if check[n - 1] == 0 and check[n - 2] == 2:
        check[n - 1] = 1
        check[n - 2] = 1
    for i in range(1, n - 1):
        if check[i] == 0 and check[i - 1] == 2:
            check[i] = 1
            check[i - 1] = 1
        if check[i] == 0 and check[i + 1] == 2:
            check[i] = 1
            check[i + 1] = 1
    for i in check:
        if i != 0:
            answer += 1
    return answer


def solution_42748(array, commands):
    """
    프로그래머스 : K번째 수
    """
    answer = []
    for item in commands:
        arr = array[item[0] - 1:item[1]]
        arr.sort()
        answer.append(arr[item[2] - 1])
    return answer


from queue import PriorityQueue


def solution_12915(strings, n):
    """
    프로그래머스 : 문자열 내 마음대로 정렬하기
    Θ(lgn)
    """
    answer = []
    Q = PriorityQueue()
    for item in strings:
        Q.put((item[n], item))
    while not Q.empty():
        answer.append(Q.get()[1])
    return answer


def solution_12916(s):
    """
    프로그래머스 : 문자열 내 p와 y의 개수
    """
    p = 0
    y = 0
    for item in s.lower():
        if item == 'p':
            p += 1
        if item == 'y':
            y += 1
    return p == y


def solution_12917(s):
    """
    프로그래머스 : 문자열 내림차순으로 배치하기
    """
    return ''.join(list(reversed(sorted(s))))


def solution_12918(s):
    """
    프로그래머스 : 문자열 다루기 기본
    """
    if len(s) == 4 or len(s) == 6:
        return s.isdigit()
    return False


def solution_12921(n):
    """
    프로그래머스 : 소수찾기
    에라토스테네스의 체
    """
    num = set(range(2, n + 1))

    for i in range(2, n + 1):
        if i in num:
            num -= set(range(2 * i, n + 1, i))
    return len(num)


def solution_12922(n):
    """
    프로그래머스 : 수박수박수박수박수박수?
    """
    mok = n // 2
    if n % 2:
        return ('수박' * mok) + '수'
    else:
        return '수박' * mok


def solution_12926(s, n):
    """
    프로그래머스 : 시저 암호
    """
    answer = ''
    for item in s:
        if item != ' ':
            pos = ord(item) + n
            if item.islower():
                if pos > 122:
                    pos = 97 + (pos - 123)
            elif item.isupper():
                if pos > 90:
                    pos = 65 + (pos - 91)
            answer += chr(pos)
        else:
            answer += ' '

    return answer


def solution_12930(s):
    """
    프로그래머스 : 이상한 문자 만들기
    """
    answer = ''
    flag = False
    for item in s:
        if item == ' ':
            answer += ' '
            flag = False
        else:
            if flag:
                answer += item.lower()
                flag = False
            else:
                answer += item.upper()
                flag = True
    return answer


def solution_12931(n):
    """
    프로그래머스 : 자릿수 더하기
    """
    answer = 0
    for item in str(n):
        answer += int(item)
    return answer


def solution_12932(n):
    """
    프로그래머스 : 자연수 뒤집어 배열로 만들기
    """
    answer = []
    for item in reversed(str(n)):
        answer.append(int(item))
    return answer


def solution_12933(n):
    """
    프로그래머스 : 정수 내림차순으로 배치하기
    """
    answer = ''
    li = list(str(n))
    li.sort(reverse=True)
    return int("".join(li))


def solution_12934(n):
    """
    프로그래머스 : 정수 제곱근 판별
    """
    import math
    answer = math.sqrt(n)
    if answer % 1 == 0:
        return int(math.pow(answer + 1, 2))
    else:
        return -1


def solution_12935(arr):
    """
    제일 작은 수 제거하기
    """
    min_idx = arr.index(min(arr))
    if len(arr) == 1:
        return [-1]
    else:
        del arr[min_idx]
        return arr


def solution_67256(numbers, hand):
    """
    프로그래머스 : 키패드 누르기
    Θ(n)
    구현
    """
    answer = ''
    l_hand = 12
    r_hand = 10
    get_position = lambda x: [(x - 1) // 3, (x - 1) % 3]
    minus = lambda x, y: abs(x[0] - y[0]) + abs(x[1] - y[1])
    for num in numbers:
        if num == 0:
            num = 11
        num_position = get_position(num)
        if num_position[1] == 0:
            answer += 'L'
            l_hand = num
        elif num_position[1] == 2:
            answer += 'R'
            r_hand = num
        else:
            l_position = minus(get_position(l_hand), num_position)
            r_position = minus(get_position(r_hand), num_position)
            if l_position == r_position:
                if hand == 'left':
                    answer += 'L'
                    l_hand = num
                else:
                    answer += 'R'
                    r_hand = num
            else:
                if l_position > r_position:
                    answer += 'R'
                    r_hand = num
                else:
                    answer += 'L'
                    l_hand = num
    return answer


def solution_12940(n, m):
    """
    프로그래머스 : 최대공약수와 최소공배수
    Θ(n)
    수학 구현
    최소공배수는 n * m을 최대공약수로 나눈 값이다.
    최대공약수는 유클리드 호제법 n과 m의 최대공약수는 m 과 n을 m으로 나눈 나머지와의 최대공약수와 같다.
    """
    answer = gcd(n, m)
    return [answer, n * m / answer]


def gcd(a, b):
    if a < b:
        (a, b) = (b, a)
    while b != 0:
        (a, b) = (b, a % b)
    return a


def solution_12943(num):
    """
    프로그래머스 : 콜라츠 추측
    Θ(n)
    수학 구현
    """
    answer = 0
    while num != 1:
        answer += 1
        if num % 2:
            num = num * 3 + 1
        else:
            num //= 2
    return answer


def solution_12947(x):
    """
    프로그래머스 : 하샤드 수
    Θ(n)
    """
    return False if x % sum(map(int, str(x))) else True


def solution_12950(arr1, arr2):
    answer = []
    for i in range(len(arr1)):
        answer.append([])
        for j in range(len(arr1[0])):
            answer[i].append(arr1[i][j] + arr2[i][j])
    return answer


def solution_12954(x, n):
    step = x * n + 1 if x >= 0 else x * n - 1
    if x == 0:
        return [0] * n
    return list(range(x, step, x))


def solution_17681(n, arr1, arr2):
    answer = []
    for x, y in zip(arr1, arr2):
        temp = x | y
        result = ''
        for i in format(temp, 'b').rjust(n, '0'):
            if i == '0':
                result += ' '
            else:
                result += '#'
        answer.append(result)

    return answer


def solution_17682(dartResult):
    """
    프로그래머스 : 다트 게임
    """
    score = []
    bonus = {'S': 1, 'D': 2, 'T': 3}
    store = ''
    idx = 0
    for i in dartResult:
        if i in bonus:
            score.append(int(store) ** bonus[i])
            idx += 1
            store = ''
        elif i == '*':
            if idx != 1:
                score[idx - 2] *= 2
            score[idx - 1] *= 2
        elif i == '#':
            score[idx - 1] *= -1
        else:
            store += i
    return sum(score)


def solution_62048(w,h):
    """
    프로그래머스 : 멀쩡한 사각형
    최대공약수를 이용한 계산
    """
    g = gcd(w, h)
    return w*h - g*(w//g+h//g-1)

def gcd_62048(a, b):
    if a < b:
        (a, b) = (b, a)
    while b != 0:
        (a, b) = (b, a % b)
    return a
import queue
def solution_42583(bridge_length, weight, truck_weights):
    """
    프로그래머스 : 다리를 지나는 트럭
    Queue를 이용한 풀이
    """
    Q = queue.Queue(maxsize=bridge_length)
    for _ in range(1,bridge_length):
        Q.put(0)
    W = 0
    time = 1
    while not Q.empty():
        if truck_weights:
            peek = truck_weights[0]
            if W + peek <= weight:
                item = truck_weights.pop(0)
                Q.put(item)
                W += item
            else:
                Q.put(0)
        W -= Q.get()
        time += 1
    return time

if __name__ == '__main__':
    bridge_length = 100
    weight = 100
    truck_weight = [10,10,10,10,10,10,10,10,10,10]
    print(solution(bridge_length,weight,truck_weight))
