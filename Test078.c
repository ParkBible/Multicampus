#include <stdio.h>

int main(){
	int l[4] = {4,3,2,1};
	int idx, j;   //�ľ��� �ּҰ��� ��ġ
	int imsi;
	
	idx = 0;
	/*
	�ϳ��� ���ؼ� �ּҰ��� ��ġ�� ã�´�.
	if(l[0] > l[1]){
		idx = 1;
	}
	if(l[1] > l[2]){
		idx = 2;
	}
	if(l[2] > l[3]){
		idx = 3;
	}
	*/
	
	// �� �ڵ�� ��������� �������� Ȯ���Ѵ�.
	for(j=1; j<4; j++){
		if(l[idx] > l[j]){
			idx = j;
		}
	}
	if(idx != 0){
		imsi = l[idx];
		l[idx] = l[0];
		l[0] = imsi;
	}
	
	for(j=2; j<4; j++){
		if(l[idx] > l[j]){
			idx = j;
		}
	}
	if(idx != 1){
		imsi = l[idx];
		l[idx] = l[1];
		l[1] = imsi;
	}
	
	for(j=3; j<4; j++){
		if(l[idx] > l[j]){
			idx = j;
		}
	}
	if(idx != 2){
		imsi = l[idx];
		l[idx] = l[2];
		l[2] = imsi;
	}
	
	printf("%d\n", idx);
	
	// ��ġ �ٲٱ�
	// �ּҰ��� 0�� �ƴ϶��, 0�� �ּҰ��� ��ġ�� �ٲٱ�.
	/*
	if(idx != 0){
		imsi = l[idx];
		l[idx] = l[0];
		l[0] = imsi;
	}
	printf("%d\n", idx);
	*/
	

	return 0;
}

// �����Ʈ. ����� cpu�� �����Ƿ� Ȱ��󵵰� ����.
// ���ĵ� �����͸� ������ �ʿ䰡 �ִٸ� ����Ʈ���� Ȱ���ϴ� ���� ���� ����.