#include <stdio.h>

int* sort(int* ll, int len2){
     int i, j;
     int min, minnum;
     int tmp;
     int* t;
     t = (int*)malloc(sizeof(int)*5);
     minnum=0;

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
if(ll[2] > ll[1] && ll[3] > ll[1]){
          minnum = 1;
          min = ll[1];
     }
     else if(ll[1] > ll[2] && ll[3] > ll[2]{
          minnum = 2;
          min = ll[2];
     }
     else{
          minnum = 3;
          min = ll[3];
     }
     
     if (ll[stnum] > min){
          ll[stnum] = ll[minnum];
          stnum = min;
     }
     

<ä��ǥ>
1. ����� ����� ���Գ�?(3��) +0
2. �Լ��� ���� �ڷ���, �Ű����� �ڷ��� ������ �ùٸ���?(1��) +1
3. malloc�� ����ؼ� �޸𸮸� Ȯ���� �ڵ尡 �ֳ�?(1��) +0 (�ֱ��ѵ� ũ�⼳���� �߸���...)
4. �� �ܰ��� �ݺ��� len-1ȸ��ŭ �Ǿ��ֳ�?(1��) +1
5. 

     */