#include <stdio.h>

float fx(float x){
	return x * x;
}
int main(){
	float i;   // �̰� int�� �س����ϱ� ���ѷ��� ���� ���Ĺ���..
	float sum = 0;
	float mit = 0.01;
	
	for(i=0; i<3; i=i+mit){
		sum = sum + mit * fx(i);
	}
	
	printf("%f\n", sum);
	return 0;
}

/*
	y = x^2 �Լ��� 0���� 3���� �����غ���(�� : 9)
	
	�غ� = 0.01
	���� = y
	0.01 * �׸𰳼� = 3
	�׸𰳼� = 3 / 0.01

*/