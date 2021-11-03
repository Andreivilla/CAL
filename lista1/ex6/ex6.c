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
void *push (Pilha* p, Arvore *v);
Arvore *pop (Pilha* p);
int pilhaVazia (Pilha* p);
void imprimeIterativo(Arvore *a);


void imprimeIterativo(Arvore *a){
    Pilha *p = pilhaCria();
    push(p, a);
    while(!pilhaVazia(p)){
        a = pop(p);
        printf("%d", a->elem);
        if(a->dir != NULL)
            push(p,a->dir);
        if(a->esq != NULL)
            push(p, a->esq);
    }
}
