#include <stdio.h>
#include <stdlib.h>
#include <time.h>

void shellSort(int *vetor,int max);

int main (void) {
    int max, i, olha;
    
    printf("Qual o tamanho do vetor?  ");
    scanf("%d",&max);

    int vetor[max];

    //entrada de dados
    srand(time(NULL));
    for(i = 0;i<max;i++){
        vetor[i] = 1 + rand()%10;
        printf("%d - ", vetor[i]);
    }
    printf("\n\n------------------\n\n");

    shellSort(vetor,max);

    return 0;
}

void shellSort (int *vetor,int max){
    int i, j, olha, valor;
    int tamanho=max;

    while(tamanho > 1){
        tamanho=tamanho/2;
        for(i=tamanho;i<max;i++){
            valor=vetor[i];
            j=i-tamanho;
            while(j>=0 && valor<vetor[j]){
                vetor[j+tamanho] = vetor[j];
                j=j-tamanho;
            }
            vetor[j+tamanho]=valor;
            for(olha=0;olha<max;olha++){
                printf("%d - ",vetor[olha]);
            }
            printf("\n\n");
        }

    }
}