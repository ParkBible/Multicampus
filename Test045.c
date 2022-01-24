#include <stdio.h>

int main(){
	char i;
	
	i = 'A';
	printf("%d\n", i);   // 65
	printf("%c\n", i);   // A
	
	return 0;
}

/*
	char 자료형은 java와 유사하다.(컴파일러마다 틀리지만, 아스키코드를 기반으로 하는 경우가 많음)
	실제로 저장되는 건 숫자가 저장되고 %d로 보냐 %c로 보냐에 따라서 다름
*/