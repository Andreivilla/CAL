#include<stdio.h>
#include<stdlib.h>
#include<bn.h>

int main(int argc, char const *argv[]){
    int n=1;

    while (1){
        printf("%d\n", n);
        n = n*2;
        system("pause");
        if(n==0)
            break;
    }
    
    return 0;
}
