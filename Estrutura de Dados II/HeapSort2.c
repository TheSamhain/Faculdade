#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#ifndef CAPACIDADE
#define CAPACIDADE 10001
#endif

struct Heap {
    long int tamanho;
    long int vetor[CAPACIDADE];
};

typedef struct Heap MaxHeap;

/* Recebe um heap h e imprime o conteúdo do heap */
void imprimeHeap(MaxHeap* h) {
    long int i;
    printf("Heap h\n");
    for (i = 1; i <= h->tamanho; i++) {
        printf("heap[%ld] : %ld\n", i, h->vetor[i]);
    }
    printf("\n");
}

/* Recebe um heap h, os índices de dois filhos Esquerdo e Direito e devolve o inteiro
   que representa o de menor valor. */
int obtemFilhoMenor(MaxHeap* h, long int filhoEsquerdo, long int filhoDireito) {
    long int minimo;
    long int indiceMinimo;
    if (filhoEsquerdo <= (h->tamanho) && filhoDireito <= (h->tamanho)) {
        minimo = h->vetor[filhoEsquerdo];
        indiceMinimo = filhoEsquerdo;
        if (minimo > h->vetor[filhoDireito]) {
            minimo = h->vetor[filhoDireito];
            indiceMinimo = filhoDireito;
        }
        return indiceMinimo;
    } else if (filhoEsquerdo <= (h->tamanho) && filhoDireito > (h->tamanho)) {
        return filhoEsquerdo;
    } else if (filhoDireito <= (h->tamanho) && filhoEsquerdo > (h->tamanho)) {
        return filhoDireito;
    } else { /* Ambos são maiores que o heap: devolve valor que não aparecerá no heap-> */
        return CAPACIDADE + 1;
    }
}

/* Recebe um heap h, os índices de dois filhos Esquerdo e Direito e devolve o inteiro
   que representa o de maior valor. */
int obtemFilhoMaior(MaxHeap* h, long int filhoEsquerdo, long int filhoDireito) {
    long int maximo;
    long int indiceMaximo;
    if (filhoEsquerdo <= (h->tamanho) && filhoDireito <= (h->tamanho)) {
        maximo = h->vetor[filhoEsquerdo];
        indiceMaximo = filhoEsquerdo;
        if (maximo < h->vetor[filhoDireito]) {
            maximo = h->vetor[filhoDireito];
            indiceMaximo = filhoDireito;
        }
        return indiceMaximo;
    } else if (filhoEsquerdo <= (h->tamanho) && filhoDireito > (h->tamanho)) {
        return filhoEsquerdo;
    } else if (filhoDireito <= (h->tamanho) && filhoEsquerdo > (h->tamanho)) {
        return filhoDireito;
    } else { /* Ambos são maiores que o heap: devolve valor que não aparecerá no heap-> */
        return CAPACIDADE + 1;
    }
}

/* Recebe um Heap h e um índice i pertencente ao Heap.
   Devolve a nova posição do elemento que era inicialmente i. */
int rebaixa(long int i, MaxHeap* h) {
    long int filhoEsquerdo;
    long int filhoDireito;
    long int filhoMaior;
    long int filhoMenor;
    long int aux;
    while (i <= (h->tamanho)) {
        filhoEsquerdo = 2 * i;
        filhoDireito = 2 * i + 1;
        filhoMaior = obtemFilhoMaior(h, filhoEsquerdo, filhoDireito);
        filhoMenor = obtemFilhoMenor(h, filhoEsquerdo, filhoDireito);
        if ((filhoMaior <= h->tamanho) && (h->vetor[i] < h->vetor[filhoMaior])) {
            aux = h->vetor[filhoMaior];
            h->vetor[filhoMaior] = h->vetor[i];
            h->vetor[i] = aux;
            i = filhoMaior;
        } else if ((filhoMenor <= h->tamanho) && (h->vetor[i] < h->vetor[filhoMenor])) {
            aux = h->vetor[filhoMenor];
            h->vetor[filhoMenor] = h->vetor[i];
            h->vetor[i] = aux;
            i = filhoMenor;
        } else {
            return i;
        }
    }
    return i;
}

/* 
   Recebe um heap h.
   Devolve o elemento que estava na raiz do heap.
 */
int extraiMaximo(MaxHeap* h) {
    long int maximo;
    if ((h->tamanho) > 1) {
        maximo = h->vetor[1];
        h->vetor[1] = h->vetor[(h->tamanho)];
        (h->tamanho) = (h->tamanho) - 1;
        rebaixa(1, h);
    } else if (h->tamanho == 1) {
        maximo = h->vetor[1];
        (h->tamanho) = 0;
    } else {
        maximo = -1;
    }
    return maximo;
}

/*
   Recebe um Heap e um inteiro i.
   Devolve o novo valor de i após tentar realizar promoções ao valor que estava na posição inicial de i.
 */
int promove(long int i, MaxHeap* h) {
    int aux;
    while (i > 1) {
        if (h->vetor[i] > h->vetor[ i / 2 ]) {
            aux = h->vetor[i];
            h->vetor[i] = h->vetor[i / 2];
            h->vetor[i / 2] = aux;
            i = i / 2;
        } else {
            return i;
        }
    }
    return i;
}

/*
   Recebe um Heap h e um vertice x.
   Insere x em h e devolve o índice de x em h.
 */
int insere(long int x, MaxHeap* h) {
    long int indiceX = -1;
    h->tamanho = (h->tamanho) + 1;

    if (h->tamanho < CAPACIDADE) {
        h->vetor[h->tamanho] = x;
        indiceX = h->tamanho;
        indiceX = promove(indiceX, h);
    }
    return indiceX;
}

/*
   Recebe um MaxHeap e um número n.
   Gera n números pseudo aleatórios e insere cada um no MaxHeap.
 */
void incluiElementos(MaxHeap* maxHeap, long int n) {
    long int i;
    long int pseudoAleatorio;
    for (i = 0; i < n; i++) {
        pseudoAleatorio = rand() % n;
        insere(pseudoAleatorio, maxHeap);
    }
}

/* 
   Recebe um vetor e seu tamanho n.
   Devolve 0 se não estiver em ordem não descrescente e devolve 1 se estiver. 
 */
int estaOrdenado(long int vetor[CAPACIDADE], long int n) {
    long int i;
    for (i = 0; i < n - 1; i++) {
        if (vetor[i] > vetor[i + 1]) {
            return 0;
        }
    }
    return 1;
}

/* 
   Recebe um vetor e seu tamanho n.
   Imprime os elementos de 0 a n em v. 
 */
void imprimeVetor(long int vetor[CAPACIDADE], long int n) {
    long int i;
    for (i = 0; i < n; i++) {
        if (i % 10 == 0) {
            printf("\n");
        }
        printf("%5ld ", vetor[i]);
    }
    printf("\n");
}

/*
   Recebe um MaxHeap, um vetor e um número n tal que 1 <= n <= 10000.
   Ordena os elementos do vetor de maneira não decrescente.
 */
void HeapSort(MaxHeap* maxHeap, long int vetor[CAPACIDADE], long int n) {
    long int i;
    for (i = n - 1; i >= 0; i--) {
        vetor[i] = extraiMaximo(maxHeap);
    }
}

int main() {
    int ti, tf;
    long int n = 0;
    MaxHeap maxHeap;
    long int vetor[CAPACIDADE] = {0,};

    maxHeap.tamanho = 0;

    srand(time(NULL));

    printf("*** Ordenação com HeapSort ***\n\n");
    while (n <= 0) {
        printf("Digite o tamanho do vetor a ser ordenado (0 < n <= 500000): ");
        scanf("%ld", &n);
    }

    if (n <= 500000) {
        ti = clock();
        incluiElementos(&maxHeap, n);
        HeapSort(&maxHeap, vetor, n);
        tf = clock();
        printf("Vetor Ordenado: ");

        if (estaOrdenado(vetor, n) == 1) {
            printf("Sim.\n");
        } else {
            printf("Não.\n");
        }
        imprimeVetor(vetor, n);

    } else {
        printf("Forneça n no intervalo [1 - 10000].\n");
    }
    printf("\nVETOR ORGANIZADO AGORA!");
    printf("\n\nTEMPO PARA ORGANIZAR: %d mili segundos \n", (tf - ti));
    system("PAUSE");

    system("pause");
    return 0;
}