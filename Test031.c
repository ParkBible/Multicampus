#include <stdio.h>

int main(){
	int l[4];
	int i;
	int max;
	l[0] = 3;
	l[1] = 15;
	l[2] = 9;
	l[3] = 10;
	max = l[0];
	
	for(i=0; i<4; i++){
		if(l[i] > max){
			max = l[i];
		}
	}
	
	printf("%d\n", max);
	return 0;
}

/*
	gcc Test031.c -o test.exe
	int l[4] = {3, 7, 9, 10}; //이 문법은 변종 문법임. 원래 문법은 허용 안한다.
	Q. 배열에 들어있는 값들 중 최대값을 구하는 코드
*/