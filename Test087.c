
// Test086.java의 메소드 오버라이딩을 C로 구현해보기
typedef struct a{
	void(*print)(void*);
}A;

typedef struct b{
	void(*print)(void*);
}B;

void A_print(void* self){
	printf("A print\n");
}

void B_print(void* self){
	printf("B print\n");
}


int main(){
	// new B() 했을 때
	B* t;
	t = (B*)malloc(sizeof(B));    // 일단 물려받을 함수를 저장할 메모리를 만든다.
	
	t->print = A_print;    // 조상에서 물려받은 함수와 연결한다.
	t->print = B_print;    // 조상을 가리키던 포인터를 그대로 사용하지만, 내용만 자신의 것으로 바꾼다.
	
	t->print(t);    // B_print가 출력된다.
	
	free(t);
	return 0;
}