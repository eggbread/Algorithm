
def solution_68644(numbers):
    answer = set()
    """
    프로그래머스 : 두 개 뽑아서 더하기
    Θ(n^2)
    """
    for i, x in enumerate(numbers):
        for y in numbers[i+1:]:
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
        while board[idx][move-1] < 1 and idx < len(board) - 1:
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

def solution(N, number):
    """
    프로그래머스 : N으로 표현
    Θ(?)
    n번의 사용으로 만들어진 숫자는 1, n-1 ~ n-1, 1의 숫자들의 사칙연산의 조합이다.
    """
    sets = [set()]
    answer = 9
    for i in range(1,9):
        sets.append(set())
        sets[i].add(int(str(N) * i))
    if number == N:
        return 1
    for i in range(2,8):
        for j in range(1,i):
            for a in sets[j]:
                for b in sets[i-j]:
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
if __name__ == '__main__':
    print(solution(1, 1))