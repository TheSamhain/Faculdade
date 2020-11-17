#include "stdio.h"
#include "stdlib.h"
#include "time.h"

void Quick(int *vetor, int inicio, int fim);

int main(void) {
    int tamanho, i;

    printf("Qual o tamanho do vetor? ");
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

    //organizar vetor
    Quick(vetor, 0, tamanho);


    printf("Vetor ordenado:\n");
    for (i = 0; i < tamanho; i++) {
        printf("%d ", vetor[i]);
    }
    printf("\n");

    return 0;
}

void Quick(int *vetor, int inicio, int fim) {
    int i = inicio;
    int j = fim;
    int pivo, aux, meio, olha;

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