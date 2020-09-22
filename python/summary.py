"""
젤 빠른 피보나치 코드
"""
def fibonacci(n):
    x = pow(n)
    return x[0] % 1000000007
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

"""
행렬 덧셈
"""
def sumMatrix(A,B):
    return [[c + d for c, d in zip(a, b)] for a, b in zip(A,B)]

