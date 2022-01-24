#include <stdio.h>

int main(){
	int i;
	float j;
	void* vp;
	int* t;
	
	i = 100;
	vp = &i;
	printf("%d\n", *((int*)vp));
	
	t = (int*)vp;
	printf("%d\n", t); // 라인11과 똑같은 결과.
	
	j = 3.14;
	vp = &j;
	printf("%f\n", *((float*)vp));
	
	return 0;
}

/*
	void* 는 모든 기억장소를 가리킬 수 있는 포인터이다.(정수형 실수형 구조체 공용체...)
	단, 해당 기억공간 안에 저장된 내용에 접근할 때는 해당 타입으로 캐스팅 해주어야 한다.
*/