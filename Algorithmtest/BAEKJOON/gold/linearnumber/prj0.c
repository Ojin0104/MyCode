#include<stdio.h>

int main(){
    int A[2][3]={{1,2,3},{4,5,6}};
    print(transpostMat(A,sizeof(A)/sizeof(int),sizeof(A[0])/sizeof(int)));

}
int transposeMat(A,m,n){
    int B[n][m];
    for(i=0; i++;i<n){
        for(j=0;j++<j<m){
            B[i][j]=A[j][i]
        }
    }
    return B
}

