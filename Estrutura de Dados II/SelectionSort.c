#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int main(void) {
    int i, j, aux, tamanho;
    int verifica;


    printf("Qual o tamanho do vetor a ser gerado? ");
    scanf("%d", &tamanho);
    printf("\n");

    int vetor[tamanho];

    srand(time(NULL));

    for (i = 0; i < tamanho; i++) {
        vetor[i] = 1 + rand() % 100;
    }

    printf("Vetor desordenado:\n");
        for (i = 0; i < tamanho; i++) {
        printf("%d ", vetor[i]);
    }
    printf("\n\n");


    for (i = 0; i < tamanho; i++) {
        for (j = i; j < tamanho; j++) {
            if (vetor[i] > vetor[j]) {
                aux = vetor[i];
                vetor[i] = vetor[j];
                vetor[j] = aux;
            }
        }
    }

      printf("Vetor ordenado:\n");
    for (i = 0; i < tamanho; i++) {
        printf("%d ", vetor[i]);
    }
    printf("\n");

    return 0;
}