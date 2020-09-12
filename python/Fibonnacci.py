'''
This is for https://programmers.co.kr/learn/courses/30/lessons/12900?language=python3
'''

def solution_loop(n):
    arr = [1,1]
    if n < 2:
        return arr[n]
    for i in range(2,n+1):
        arr.append(arr[i-1]+arr[i-2])
    answer = arr[n]
    return answer % 1000000007

def solution_recursive(n):
    answer = recursive(n)
    return answer % 1000000007

def recursive(n):
    if n < 2:
        return 1
    return recursive(n-1) + recursive(n-2)

def solution_matrix(n):
    x = pow(n)
    return x[0] % 1000000007

# def pow(n):
#     if n < 2:
#         return [1, 1, 1, 0]
#     x = pow(n-1)
#     return [x[0]+x[1], x[0], x[2]+x[3], x[2]]

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

if __name__ == '__main__':
    n = 60000
    print(solution_matrix(n))
