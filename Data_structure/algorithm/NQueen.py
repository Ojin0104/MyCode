

def DFS(N,current_row,current_candidate,final_result):
    if current_row==N:
        final_result.append(current_candidate)

        return
    for candidate_col in range(N):
        if is_available(current_candidate,candidate_col):
            current_candidate.append(candidate_col)
            DFS(N,current_row+1,current_candidate,final_result)
            current_candidate.pop()#밑에열 모두 안되면-> 잘못된거기떄문에 다시 뺴냄
def solve_n_queens(N):#N체스판 몇열인지
    final_result=[]
    DFS(N,0,[],final_result)
    return final_result

def is_available(candidate,current_col):
    current_row=len(candidate)
    for queen_row in range(current_row):
        if candidate[queen_row]==current_col or abs(candidate[queen_row]-current_col)==current_row-queen_row:
            return False
    return True
print(solve_n_queens(4))