#include <stdio.h>

// 구조체 : 새로운 타입(복합형)의 자료형을 선언한 것으로 일단 보면 됨
// 자료형은 하나의 값만 대입 가능했지만 구조체로 선언된 변수는 여러개의 값을 담을 수 있다.

struct apple{
	int name;
	int value;
};

int main(){
	struct apple i;
	i.name = 100;
	i.value = 200;
	
	printf("%d %d\n", i.name, i.value);  // 하나의 변수에 두개 값 저장
	return 0;
}