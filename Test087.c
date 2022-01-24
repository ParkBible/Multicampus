
// Test086.java�� �޼ҵ� �������̵��� C�� �����غ���
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
	// new B() ���� ��
	B* t;
	t = (B*)malloc(sizeof(B));    // �ϴ� �������� �Լ��� ������ �޸𸮸� �����.
	
	t->print = A_print;    // ���󿡼� �������� �Լ��� �����Ѵ�.
	t->print = B_print;    // ������ ����Ű�� �����͸� �״�� ���������, ���븸 �ڽ��� ������ �ٲ۴�.
	
	t->print(t);    // B_print�� ��µȴ�.
	
	free(t);
	return 0;
}