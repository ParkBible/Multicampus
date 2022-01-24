#include <stdio.h>

int main(){
	int a[4];
	int i, len;
	a[0] = 3;
	a[1] = 6;
	a[2] = 5;
	a[3] = 8;
	
	len = sizeof(a) / sizeof(int); //배열의 길이 재는 법
	
	for(i=0; i<4; i++){
		printf("%d\n",a[i]);
	}
	return 0;
}


//3 6 5 8 요소를 가진 배열을 선언하고 for 반복문으로 찍어봅시다.

/*
	배열은 포인터다. '배열형 변수는 포인터 변수에 대입 가능하다.'
*/