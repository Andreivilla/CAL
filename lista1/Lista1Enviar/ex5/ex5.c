#include<stdio.h>
#include<stdlib.h>

typedef struct Lista{
    int elem;
    struct Lista *ptr;
}Lista;

Lista *insereInicio(Lista *lista, int valor){
    Lista *insere = (Lista*) malloc(sizeof(Lista));
    insere->elem = valor;
    insere->ptr = lista;
    return insere;
}

Lista *insereFinal(Lista *lista, int valor){
    Lista *insere = (Lista*) malloc(sizeof(Lista));
    Lista *percorre = lista;
    insere->elem = valor;
    insere->ptr = NULL;
    
    if(lista == NULL)
        return insere;

    while(percorre->ptr != NULL)
        percorre = percorre->ptr;
    
    printf("%d\n", percorre->elem);
    percorre->ptr = insere;

    return lista;
}
