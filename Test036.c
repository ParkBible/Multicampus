#include <stdio.h>

float bokri(int years, int money, float rate){
	float total;
	int i;
	total = money;
	for(i=0; i<years; i++){
		total = total + (total * rate);
	}
	return total;
}

int main(){
	float res;
	res = bokri(100, 100, 0.066);
	printf("%f\n",res);
	return 0;
}

/*
	bokri라는 함수를 만들어서 호출하는 형태로 100년간 100만원을 6.6%로 운용한 결과를 출력하는 코드
	
	초보들은 일단 외운거(형태만) 적어놓고 시작하면 훨씬 편하다.(뼈대를 잡아놓는다.)
	선언-호출하는 코드만 잡아도 에러가 안난다.
	확실하게 에러 안나는 코드를 여러개 짜놓자!
	
*/