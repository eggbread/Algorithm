def solution_demo(A):
    # write your code in Python 3.6
    max_value = max(A)
    if max_value < 0:
        return 1
    else:
        arr = sorted(A)
        temp = arr[0]
        for i in arr[1:]:
            if i <= temp + 1:
                temp = i
                continue
            else:
                return temp + 1
        return max_value + 1


def solution_binarygap(N):
    # write your code in Python 3.6
    binary = int_to_binary(N)
    stack = []
    answer = 0
    for i in binary:
        if i == '1':
            if len(stack):
                if len(stack) - 1 > answer:
                    answer = len(stack) - 1
                stack = ['1']

            else:
                stack.append(i)
        else:
            stack.append(i)

    return answer


def int_to_binary(n):
    result = ''
    while n > 1:
        if n % 2:
            result = '1' + result
        else:
            result = '0' + result
        n //= 2
    if n:
        result = '1' + result
    return result


def solution_cyclic_rotation(A, K):
    # write your code in Python 3.6
    length = len(A)
    if length:
        K %= length
        for i in range(K):
            temp = A[-1]
            del A[-1]
            A.insert(0, temp)
        return A
    else:
        return []


def solution_odd_occurrences_in_array(A):
    # write your code in Python 3.6
    check = {}
    for i in A:
        if i in check.keys() and not check[i]:
            check[i] = True
        else:
            check[i] = False
    for i in check:
        if not check[i]:
            return i


def solution_frog_jmp(X, Y, D):
    # write your code in Python 3.6
    remain = Y - X
    jump = remain // D
    last = remain % D
    if last:
        return jump + 1
    else:
        return jump


def solution_(A):
    # write your code in Python 3.6
    A.sort()
    if not A:
        return 1
    if A[0] != 1:
        return 1
    for i in range(len(A) - 1):
        if A[i] != A[i + 1] - 1:
            return A[i] + 1
    return A[-1] + 1


def solution(H):
    # write your code in Python 3.6
    left = H[0]
    right = sum(H) - left
    min = abs(right - left)
    for i in H[1:len(H) - 1]:
        left += i
        right -= i
        if abs(right - left) <= min:
            min = abs(right - left)

    return min


if __name__ == '__main__':
    A = [-1000, 1000]
    # A = [3, 1, 2, 4, 3]
    print(solution(A))
