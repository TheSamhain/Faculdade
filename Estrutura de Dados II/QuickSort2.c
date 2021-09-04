#include "stdio.h"
#include "stdlib.h"
#include "time.h"

void Quick(long int *vetor, long int inicio, long int fim);

int main(void) {
    long int tamanho, i;
    double ti, tf;

    printf("Qual o tamanho do vetor? ");
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
    Quick(vetor, 0, tamanho);
    tf = clock();
    printf("Tempo Inicial: %f\nTempo Final: %f  \nTempo Total: %f\n\n", ti, tf, (tf - ti));

    printf("Vetor ordenado:\n");
    for (i = 0; i < tamanho; i++) {
        printf("%ld ", vetor[i]);
    }
    printf("\n\n");

    printf("Tempo Inicial: %f\nTempo Final: %f  \nTempo Total: %f\n\n", ti, tf, (tf - ti));
printf("Tempo Inicial: %f\nTempo Final: %f  \nTempo Total: %f\n\n", ti, tf, (tf - ti));

    return 0;
}

void Quick(long int *vetor, long int inicio, long int fim) {
    long int i = inicio;
    long int j = fim;
    long int pivo, aux, meio, olha;

    meio = i;
    //meio = (int) ((i+j) / 2);

    pivo = vetor[meio];
    do {
        while (vetor[i] < pivo) {
            i = i + 1;
        }
        while (vetor[j] > pivo) {
            j = j - 1;
        }

        if (i <= j) {
            aux = vetor[i];
            vetor[i] = vetor[j];
            vetor[j] = aux;
            i = i + 1;
            j = j - 1;
        }
    } while (j > i);

    if (inicio < j) {
        Quick(vetor, inicio, j);
    }
    if (i < fim) {
        Quick(vetor, i, fim);
    }

}