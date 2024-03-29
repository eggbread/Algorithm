"""
젤 빠른 피보나치 코드
"""


def fibonacci(n):
    x = pow(n)
    return x[0] % 1000000007


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


"""
행렬 덧셈
"""


def sumMatrix(A, B):
    return [[c + d for c, d in zip(a, b)] for a, b in zip(A, B)]

"""
행렬 곱셈
"""
def mulMatrix(A, B):
    return [[sum(a*b for a, b in zip(A_row,B_col)) for B_col in zip(*B)] for A_row in A]

"""
에라토스테네스의 체
"""


def get_prime(n):
    num = set(range(2, n + 1))

    for i in range(2, n + 1):
        if i in num:
            num -= set(range(2 * i, n + 1, i))
    return num


"""
소수 찾기 기본 코드
"""


def isPrime(a):
    if (a < 2):
        return False
    for i in range(2, a):
        if (a % i == 0):
            return False
    return True


"""
약수 구하기
"""


def get_divisor(n):
    divisor = set()
    if n == 1:
        divisor.add(1)
    for i in range(1, int(n / 2) + 1):
        if n % i == 0:
            divisor.add(i)
            divisor.add(int(n / i))
    return divisor


"""
최소(댓)값 위치 찾기
"""


def find_max_idx(arr):
    import sys
    idx = 0
    max_value = - sys.maxsize - 1
    for i in range(len(arr)):
        if arr[i] > max_value:
            max_value = arr[i]
            idx = i
    return idx, max_value


def find_min_idx(arr):
    import sys
    idx = 0
    min_value = sys.maxsize
    for i in range(len(arr)):
        if arr[i] < min_value:
            min_value = arr[i]
            idx = i
    return idx, max_value


"""
N진수로 만들기
"""
NOTATION = '0123456789ABCDEF'


def change(N, K):
    q, r = divmod(N, K)
    n = NOTATION[r]
    return change(q, K) + n if q else n

def change_binary(N):
    q, r = divmod(N, 2)
    return change_binary(q) + str(r) if q else str(r)
"""
최대공약수
"""
def gcd(a, b):
    if a < b:
        (a, b) = (b, a)
    while b != 0:
        (a, b) = (b, a % b)
    return a

"""
최대공배수
"""
def lcm(a, b):
    return a * b // gcd(a,b)

"""
숫자의 자리수 합
"""
def sum_digit(x):
    return sum(map(int,str(x)))

"""
list 내 최댓값의 index
"""
def get_max_index(x):
    import operator
    index, value = max(enumerate(x), key=operator.itemgetter(1))
    return index, value

if __name__ == '__main__':
    print(gcd(16,24))
