#include <stdio.h>

int main(){
	int l[4] = {4,3,2,1};
	int idx, j;   //파악한 최소값의 위치
	int imsi;
	
	idx = 0;
	/*
	하나씩 비교해서 최소값의 위치를 찾는다.
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
	
	// 위 코드와 같은결과가 나오는지 확인한다.
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
	
	// 위치 바꾸기
	// 최소값이 0이 아니라면, 0과 최소값의 위치를 바꾸기.
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

// 버블소트. 요새는 cpu가 좋으므로 활용빈도가 높다.
// 정렬된 데이터를 유지할 필요가 있다면 이진트리를 활용하는 것이 가장 좋다.