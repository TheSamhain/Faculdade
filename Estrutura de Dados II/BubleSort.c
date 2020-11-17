#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include "time.h"

void bubleShort(int vetor[], int tamanho) {
    int flag, i, aux, olha;
    do {
        flag = 0;
        for (i = 0; i < (tamanho - 1); i++) {
            if (vetor[i] > vetor[i + 1]) {
                aux = vetor[i];
                vetor[i] = vetor[i + 1];
                vetor[i + 1] = aux;
                flag = 1;

                for (olha = 0; olha < tamanho; olha++) {
                    printf("%d -", vetor[olha]);
                    sleep(1.1);
                }
                printf("\n");
            }
        }
    } while (flag == 1);
}

int main(void) {
    int i, tamanho;
    printf("\n Qual o tamanho do vetor?");
    scanf("%d", &tamanho);

    int vetor[tamanho];

    srand(time(NULL));
    for (i = 0; i < tamanho; i++) {
        vetor[i] = 1 + rand() % tamanho;
    }

   printf("Vetor desordenado:\n");
    for (i = 0; i < tamanho; i++) {
        printf("%d ", vetor[i]);
    }
    printf("\n\n");    

    bubleShort(vetor, tamanho);

    printf("Vetor ordenado:\n");
    for (i = 0; i < tamanho; i++) {
        printf("%d ", vetor[i]);
    }
    printf("\n");

    return 0;
}
