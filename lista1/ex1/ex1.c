#include<stdlib.h>
#include<stdio.h>
int contRecursivo = 0; contFibInterativo = 0;
unsigned int fibRecursivo (unsigned int n){
    if (n < 2)
        return n;
    return fibRecursivo (n-2) + fibRecursivo (n-1);
}
int fibInterativo(int n){
    int i = 0;
    int j = 1;
    int k;
    for(k = 1; k < n; k++){
        int t = i + j;
        i = j;
        j = t;
    }
    if(n==0)
        return 0;
    else
    return j;
}                            

int main(int argc, char const *argv[]){
    int i=0;
    for(int i=0; i<10; i++){
        printf("n: %d\n", i);
        printf("%d\n", fibInterativo(i));
        printf("%d\n", fibRecursivo(i));
    }

}