#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int main (void){
    int i,j,n,aux,menor,tamanho=10000;
    float ti,tf;
    int vetor[tamanho];
    int trocas=0,verifica=0;
    
    srand(time(NULL));
    n = tamanho;

    for(i = 0;i<tamanho;i++){
        vetor[i] = 1 + rand()%10000;
        printf("%d - ", vetor[i]);
    }

    ti=clock();
    for(i=1;i<n;i++){
        j=i;
        while(vetor[j]<vetor[j-1] && j>0){
            aux = vetor[j];
            vetor[j] = vetor[j-1];
            vetor[j-1] = aux;
            j--;
        }
    }
    tf=clock();
    printf("\nTempo: %f",(tf-ti));


  

    return 0;
}