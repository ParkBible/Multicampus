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
	bokri��� �Լ��� ���� ȣ���ϴ� ���·� 100�Ⱓ 100������ 6.6%�� ����� ����� ����ϴ� �ڵ�
	
	�ʺ����� �ϴ� �ܿ��(���¸�) ������� �����ϸ� �ξ� ���ϴ�.(���븦 ��Ƴ��´�.)
	����-ȣ���ϴ� �ڵ常 ��Ƶ� ������ �ȳ���.
	Ȯ���ϰ� ���� �ȳ��� �ڵ带 ������ ¥����!
	
*/