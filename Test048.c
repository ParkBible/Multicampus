#include <stdio.h>

float fx(float x){
	return x * x;
}
int main(){
	float i;   // 이거 int로 해놓으니까 무한루프 돌고 미쳐버림..
	float sum = 0;
	float mit = 0.01;
	
	for(i=0; i<3; i=i+mit){
		sum = sum + mit * fx(i);
	}
	
	printf("%f\n", sum);
	return 0;
}

/*
	y = x^2 함수를 0에서 3까지 적분해보기(답 : 9)
	
	밑변 = 0.01
	높이 = y
	0.01 * 네모개수 = 3
	네모개수 = 3 / 0.01

*/