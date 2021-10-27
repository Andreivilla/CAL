#include"funcs.h"
int main(int argc, char const *argv[]){
    int i=0;
    for(int i=0; i<10; i++){
        printf("n: %d\n", i);
        printf("%d\n", fibInterativo(i));
        printf("%d\n", fibRecursivo(i));
    }

}