#include<stdlib.h>
#include<stdio.h>
#include<time.h>

unsigned int fibR (unsigned int n){
    if (n < 2)
        return n;
    return fibR(n-2) + fibR(n-1);
}
int main(int argc, char const *argv[]){
    double tempo=0, vetTempo[100];
    int j, i = 0;
    while(tempo < 1000){
        printf("\nn: %d\n", i);
        clock_t t = clock();
        printf("fibo: %d\n",fibR(i));
        t = clock() - t;
        tempo = ((double)t)/((CLOCKS_PER_SEC/1000));
        printf("Tempo de execucao: %lf\n", tempo);
        vetTempo[i] = tempo;
        i++;
    }
    //printando vetor em formato de python
    printf("tempos: ");
    for(j=0; j<i; j++){
        if(j==0)
            printf("[%lf, ", vetTempo[j]);
        printf("%lf, ", vetTempo[j]);
        if(j==i-1)
            printf("%lf]", vetTempo[j]);
    }
    printf("\nfiboN: ");
    for(j=0; j<i; j++){
        if(j==0)
            printf("[%d, ", j);
        printf("%d, ", j);
        if(j==i-1)
            printf("%d]", j);
    }
}