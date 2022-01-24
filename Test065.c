#include <stdio.h>
/*
	Temp ����ü - class Temp - ������� ����
	new_Temp() ȣ��� - �޸� Ȯ��, add �Լ������Ϳ� ��ü�� �����Ѵ�.
	Temp* t; - �̰��� ������, ����ü�� ��ü�� ����Ű�µ�, �� ���� ������ �̹� ���ԵǾ���.
	
	��ư �Լ��� �ٷ� ����ü�� ���� �� �����ϱ� new_Temp() �̷� �����۾��� �ʿ��ϴ� �̸��̾�
*/

typedef struct temp{  // class�� ���� ����. ������ ��Ÿ��
	int data;
	int (*add)(int);
} Temp;

int Temp_add(int i){  // �� �Լ�
	return 20 * i;
};


Temp* new_Temp(){  // ����ü�� �Լ������Ϳ� �Լ��� ��������. tmp��� ����ü ������ �����, �� ���� ���� ��ҵ鿡 ������.(��ü)
	Temp* tmp;
	tmp = (Temp*)malloc(sizeof(Temp));
	tmp->add = Temp_add;
	tmp->data = 100;
	return tmp;
}

int main(){
	Temp* t;
	t = new_Temp();  // new_Temp()�� ������ ���� ���� ���ԵǾ� �ִ� ���� tmp�� ���Ϲ޾Ƽ� t�� ������. 
	
	t->data = t->add(20);
	printf("%d\n", t->data);
	free(t);
	
	return 0;
}

/*
	����ü �ȿ� �Լ��� ���� �Ұ��������� �Լ� �����ʹ� ���� �����ϴ�!!!
	��ġ like ��ٸ��� "Ŀ�� �̺�Ʈ" �� ���.
*/