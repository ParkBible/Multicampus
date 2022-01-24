#include <stdio.h>

int* sort(int* t, int len){
     int* l;
	 int i, j;
	 int idx, imsi;
     l = (int*)malloc(sizeof(int)*len);
	 
	 // 배열 값 복사하기
	 for(i=0; i<(len-1); i++){
		 *(l+i) = *(t+i);
	 }
	 
	 for(j=1; j<len; j++){
		 if(*(l+j) < *(l+idx)){
			 idx = j;
		 }
	 }
	 
	 printf("-- %d\n", *(l+idx));  // 최솟값.
	 
	 // 위치 바꾸기
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
     t = sort( l, len );    // 정렬된 배열: t

     // 아래의 반복문에서는 2 7 4 8 이 출력되어야 함
     
     for( i = 0 ; i < len ; i++ ) {
     printf("%d\n", l[i] );
     }
     
     printf("%d\n", t);
     // 아래의 반복문에서는 배열 요소를 정렬시킨 결과 즉 2 4 7 8 이 출력되어야 함
     
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
     

<채점표>
1. 결과가 제대로 나왔나?(3점) +0
2. 함수의 리턴 자료형, 매개변수 자료형 선언이 올바른가?(1점) +1
3. malloc을 사용해서 메모리를 확보한 코드가 있나?(1점) +0 (있긴한데 크기설정을 잘못함...)
4. 최 외각의 반복이 len-1회만큼 되어있나?(1점) +1
5. 최소값의 위치를 구해서 교환하는 로직이 있나?(2점)

1번 : 0
2번 : 1
3번 : 1
4번 : 1
5번 : 0

     */