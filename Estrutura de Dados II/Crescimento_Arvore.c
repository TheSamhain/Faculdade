#include "stdio.h"
#include "stdlib.h"

int main (void){
	float arvore1=60, arvore2=180,cresce1=5,cresce2=2.5;
	char mes=0,ano=0;

	printf("|anos \t| meses \t| arvore 1 \t| arvore 2 |\n");
	printf("+-------+---------------+---------------+----------+\n");
	
	while(arvore1<arvore2){
		arvore1 += cresce1;
		arvore2 += cresce2;
		mes++;
		if(mes == 12){
			ano++;
			mes = 0;
		}
		printf("|%0.2d \t| %0.2d \t\t| %0.2f \t| %0.2f   |\n",ano,mes,arvore1,arvore2);
	}	
}