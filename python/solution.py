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


def DFS(computers, n, check):
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

def solution(begin, target, words):
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

if __name__ == '__main__':
    begin = 'hit'
    target = 'cog'
    words = ['hot', 'dot', 'dog', 'lot', 'log', 'cog']
    print(solution(begin, target, words))
