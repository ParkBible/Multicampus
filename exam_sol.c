#include <stdio.h>

int* sort(int* t, int len){
     int* l;
	 int i, j;
	 int idx, imsi;
     l = (int*)malloc(sizeof(int)*len);
	 
	 // �迭 �� �����ϱ�
	 for(i=0; i<(len-1); i++){
		 *(l+i) = *(t+i);
	 }
	 
	 for(j=1; j<len; j++){
		 if(*(l+j) < *(l+idx)){
			 idx = j;
		 }
	 }
	 
	 printf("-- %d\n", *(l+idx));  // �ּڰ�.
	 
	 // ��ġ �ٲٱ�
	 idx = 0;
	 if(idx != 0){
		 imsi = *(l+idx);
		 *(l+idx) = *(l+0);
		 *(l+0) = imsi;
	 }
	 
	 idx = 1;
	 if(idx != 1){
		 imsi = *(l+idx);
		 *(l+idx) = *(l+1);
		 *(l+1) = imsi;
	 }
	 
	 return l;
     
}



int main() {
     int l[] = {2,7,4,8};
     int i, len;
     int* t;
     len = sizeof( l ) / sizeof( int );
     t = sort( l, len );    // ���ĵ� �迭: t

     // �Ʒ��� �ݺ��������� 2 7 4 8 �� ��µǾ�� ��
     
     for( i = 0 ; i < len ; i++ ) {
     printf("%d\n", l[i] );
     }
     
     printf("%d\n", t);
     // �Ʒ��� �ݺ��������� �迭 ��Ҹ� ���Ľ�Ų ��� �� 2 4 7 8 �� ��µǾ�� ��
     
     for( i = 0 ; i < len ; i++ ) {
     printf("%d\n", *(t+i) );
     }
     
     free( t );

     return 0;
}

/*
for(j=0; j<(len2-1); j++){
          for(i=j; i<(len2-1); i++){
               if(ll[i+2] > ll[i+1] && ll[i+3] > ll[i+1]){
               minnum = i+1;
               min = ll[i+1];
               }
               else if(ll[i+1] > ll[i+2] && ll[i+3] > ll[i+2]){
                    minnum = i+2;
                    min = ll[i+2];
               }
               else{
                    minnum = i+3;
                    min = ll[i+3];
               }
               
               if (ll[i] > min){
               tmp = ll[i];
               ll[i] = min;
               ll[minnum] = tmp;
               }
          }
     }
     
     t = ll[minnum];
     return t;
     

<ä��ǥ>
1. ����� ����� ���Գ�?(3��) +0
2. �Լ��� ���� �ڷ���, �Ű����� �ڷ��� ������ �ùٸ���?(1��) +1
3. malloc�� ����ؼ� �޸𸮸� Ȯ���� �ڵ尡 �ֳ�?(1��) +0 (�ֱ��ѵ� ũ�⼳���� �߸���...)
4. �� �ܰ��� �ݺ��� len-1ȸ��ŭ �Ǿ��ֳ�?(1��) +1
5. �ּҰ��� ��ġ�� ���ؼ� ��ȯ�ϴ� ������ �ֳ�?(2��)

1�� : 0
2�� : 1
3�� : 1
4�� : 1
5�� : 0

     */