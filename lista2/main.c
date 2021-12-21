#include<stdio.h>
#include<stdlib.h>
#define TAM 8

int esquerda(int i){ 
    return (2 * i + 1); 
}
int direita(int i){ 
    return (2 * i + 2); 
}
void heapify (int *a, int n, int i){
    int e, d, maior, aux;

    e = esquerda(i);
    d = direita(i);
    if (e < n && a[e] > a[i])
        maior = e;
    else 
        maior = i;
    if (d < n && a[d] > a[maior])
        maior = d;
    if (maior != i){
        aux = a[i];
        a[i] = a[maior];
        a[maior] = aux;
        heapify(a, n, maior);
    }
}
void buildHeap(int *a, int n){
    int i;
    for (i = (n-1)/2; i >= 0; i--)
        heapify(a, n, i);
}
void heapSort(int *a, int n){
    int i, aux;
    buildHeap(a, n);
    for (i = n - 1; i > 0; i--){
        aux = a[0]; 
        a[0] = a[i]; 
        a[i] = aux;
        heapify(a, i, 0);
    }
}

void printVet(int *a){
    int i;
    for(i=0; i<TAM; i++)
        printf("%d  ", a[i]);
}

int main(int argc, char *argv[]){
    int vet[TAM] = {4, 6, 5, 3, 2, 8, 1, 7}; 
    //buildHeap(vet, TAM);
    heapSort(vet, TAM);
    printVet(vet);
    return 0;
}
