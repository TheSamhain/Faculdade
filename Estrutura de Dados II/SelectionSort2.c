#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int main(void) {
    long int i, j, aux, tamanho;
    long int verifica;
    double ti, tf;

    printf("Qual o tamanho do vetor a ser gerado? ");
    scanf("%ld", &tamanho);
    printf("\n");

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
    for (i = 0; i < tamanho; i++) {
        for (j = i; j < tamanho; j++) {
            if (vetor[i] > vetor[j]) {
                aux = vetor[i];
                vetor[i] = vetor[j];
                vetor[j] = aux;
            }
        }
    }
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