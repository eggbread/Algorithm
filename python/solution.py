
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

if __name__ == '__main__':
    board = [2, 2]
    moves = 1
    print(solution(board, moves))