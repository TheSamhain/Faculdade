#include <stdio.h>
#include <stdlib.h>
#include "time.h"

void bubleShort(long int vetor[], long int tamanho) {
    long int flag, i, aux;
    do {
        flag = 0;
        for (i = 0; i < (tamanho - 1); i++) {
            if (vetor[i] > vetor[i + 1]) {
                aux = vetor[i];
                vetor[i] = vetor[i + 1];
                vetor[i + 1] = aux;
                flag = 1;
            }
        }
    } while (flag == 1);
}

int main(void) {
    long int i, tamanho;
    float ti, tf;

    printf("Qual o tamanho do vetor?");
    scanf("%ld", &tamanho);

    long int vetor[tamanho];

    srand(time(NULL));
    for (i = 0; i < tamanho; i++) {
        vetor[i] = 1 + rand() % tamanho;
    }

    printf("Vetor desordenado:\n");
    for (i = 0; i < tamanho; i++) {
        printf("%ld ", vetor[i]);
    }
    printf("\n\n");

    //Ordenar Vetor
    ti = clock();
    bubleShort(vetor, tamanho);
    tf = clock();
    printf("Tempo Inicial: %f\nTempo Final: %f  \nTempo Total: %f\n\n", ti, tf, (tf - ti));

    printf("Vetor ordenado:\n");
    for (i = 0; i < tamanho; i++) {
        printf("%ld ", vetor[i]);
    }
    printf("\n\n");

    printf("Tempo Inicial: %f\nTempo Final: %f  \nTempo Total: %f\n\n", ti, tf, (tf - ti));

    return 0;
}
