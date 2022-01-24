#include <stdio.h>

int main(){
	float rate;
	int money;
	int years;
	float total;
	int i;
	money = 100;
	years = 100;
	rate = 0.066;
	
	total = money;
	
	for(i=0; i<years; i++){
		total = total + (total * rate);
	}
	printf("%f", total);
	
	return 0;
}

// 100만원을 100년간 6.6% 이자로 복리로 굴린 결과는?
