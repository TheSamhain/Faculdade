#include "stdio.h"     
#include "stdlib.h"    
#include "time.h"

int main (void){
    int tam,num,max,i,j,qt=0;

    printf("Insira a quantidade de numeros: ");
    scanf("%d",&tam);

    printf("Qual o valor maximo aleatorio: ");
    scanf("%d",&max);

    int vetor[tam];

    srand (time(NULL));
    
    for(i =0;i < tam;i++){
        num = rand() % max;
        if(i == 0){
            vetor[i] = num;
            qt++;
        }else {
            for(j = 0;j < qt; j++){
                if(num == vetor[j]){
                    num = rand() % max;
                    j = -1;
                }
            }
            vetor[i] = num;
            qt++;
        }  
    } 

    for(i = 0;i<tam;i++){
        printf("%d - ",vetor[i]);
    }

    return 0;
}