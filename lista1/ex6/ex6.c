#include<stdio.h>
#include<stdlib.h>
typedef struct Arvore{
    int elem;
    struct Arvore *esq, *dir;
}Arvore;

#define MAX 100//supondo um limite altura de 100 elementos
typedef struct pilha Pilha;
typedef struct pilha {
    int n;
    Arvore vet[MAX];
};

Pilha* pilhaCria (void);
void push (Pilha* p, Arvore v);
Arvore pop (Pilha* p);
int pilhaVazia (Pilha* p);
void imprimeInterativo(Arvore a);


void imprimeInterativo(Arvore a){
    Pilha *p = pilhaCria();
    push(p, a);
    while(!pilhaVazia(p)){
        a = pop(p);
        printf("%d", a.elem);
        if(a.dir != NULL)
            push(p,a.dir);
        if(a.esq != NULL)
            push(p, a.esq);
    }
}
Pilha* PilhaCria (void){
    Pilha* p = (Pilha*) malloc(sizeof(Pilha));
    p->n = 0;
    return p;
}
void push (Pilha* p, Arvore v){
    if (p->n == MAX) {
        printf("Capacidade da pilha estourou.\n");
        return;
    }
    p->vet[p->n] = v;
    p->n++;
}

Arvore pop (Pilha* p){
    Arvore v;
    if (pilhaVazia(p)) {
    printf("Pilha vazia.\n");
    exit(1);
    }
    v = p->vet[p->n-1];
    p->n--;
    return v;
}
int pilhaVazia (Pilha* p){
    return (p->n == 0);
}