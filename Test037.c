#include <stdio.h>

float danri(int years, int money, float rate){
	float total;
	total = money + money * rate * years;
	return total;
}
int main(){
	float a;
	a = danri(100, 100, 0.066);
	printf("%f\n", a);
	return 0;
}

