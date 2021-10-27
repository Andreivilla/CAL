#include"funcs.h"
unsigned int fibR (unsigned int n){
    if (n < 2)
        return n;
    return fibRecursivo (n-2) + fibRecursivo (n-1);
}
int fibI(int n){
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