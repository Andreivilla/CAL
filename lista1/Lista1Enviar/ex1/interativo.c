#include<stdlib.h>
#include<stdio.h>
#include<time.h>

int fibI(int n){
    int a = 0, b = 1, c, i = 2;
    if(n == 1)
        return a;
    else{
        if(n == 2)
            return b;
        else{
            while (i < n){
                c = a + b;
                a = b;
                b = c;
                i++;
            }
            return c;
        }
    }
}
int main(int argc, char const *argv[]){
    double tempo=0, vetTempo[100];
    int i = 0;
    while(i < 46){
        printf("\nn: %d\n", i);
        clock_t t = clock();
        printf("fibo: %d\n",fibI(i));
        t = clock() - t;
        tempo = ((double)t)/((CLOCKS_PER_SEC/1000));
        printf("Tempo de execucao: %lf\n", tempo);
        vetTempo[i] = tempo;
        i++;
    }
}