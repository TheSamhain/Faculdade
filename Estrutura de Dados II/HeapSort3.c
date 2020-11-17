#include <stdio.h>
#include <stdlib.h>
#include <time.h>

void heapsort(long int vetor[], long int n);

int main() {
    long int tamanho, verifica, i;
    float ti, tf;

    // sorteando valores
    srand(time(NULL));

    printf("Qual o tamanho do vetor a ser gerado? ");
    scanf("%ld", &tamanho);
    printf("\n");


    long int vetor[tamanho];

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
    heapsort(vetor, tamanho);
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

void heapsort(long int vetor[], long int n) {
    long int i = n / 2, pai, filho, t;
    for (;;) {
        if (i > 0) {
            i--;
            t = vetor[i];
        } else {
            n--;
            if (n == 0) return;
            t = vetor[n];
            vetor[n] = vetor[0];
        }
        pai = i;

        //Primeiro será feita a comparação com o filho da esquerda.
        filho = i * 2 + 1;
        while (filho < n) {
            //Se o filho da esquerda for menor do que o filho da 
            // direita, então será feita a troca do filho que será
            //  comparado.
            if ((filho + 1 < n) && (vetor[filho + 1] > vetor[filho])) {
                filho++;
            }
            if (vetor[filho] > t) {
                vetor[pai] = vetor[filho];
                pai = filho;
                filho = pai * 2 + 1;
            } else {
                break;
            }
        }
        vetor[pai] = t;
    }
}