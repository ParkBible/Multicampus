#include <stdio.h>

int main(){
	int i;
	float j;
	i = 100;
	i = i + 1;
	printf("%d\n", i);
	j = i;
	printf("%f\n", j);
	i = 3.14;
	printf("%d\n", i); // 3
	
	return 0;
}

/*
	컴파일러마다 차이가 있지만 gcc는 실수형으로 float 애용.
	정수값을 실수형 변수에 대입하면 자동 형변환되어 대입된다.
	실수값을 정수형 변수에 넣어도 자동 형변환된다.
*/