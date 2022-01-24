#include <stdio.h>
#include <string.h>

int main(){
	char l[7] = "Apple\0";
	char* t = "Hello\0";
	int len;
	
	
	printf("%s\n", l);
	printf("%d\n", strlen(l));
	printf("%s\n", t);
	printf("%d\n", strlen(t));
	
	return 0;
}

/*
	java¿¡¼­´Â ¹®ÀÚ¿­À» StringÀ¸·Î »ç¿ëÇßÀ½
	int[] i = {1,2};
	Appleÿ@u??Pÿ@?@  // char l[5] = "Apple"; ¾²·¹±â°ªÀÌ Ãâ·Â.
	
	char l[5] = "Apple\0"; ÀÌ¶ó°í Àû¾îÁà¾ßÇÑ´Ù.(¸¶Áö¸·¿¡ \0À¸·Î ³¡³ª°Ô ÇÑ´Ù.)
	
	¹è¿­Çü º¯¼ö´Â Æ÷ÀÎÅÍ¿¡ ´ëÀÔ °¡´ÉÇÏ´Ï±î À§¿Í °°ÀÌ Æ÷ÀÎÅÍ·Î ¹®ÀÚ¿­À» ¿î¿ëÇØµµ ¹è¿­°ú °°Àº °³³äÀÌ´Ù.
	
	¹®ÀÚ¿­ÀÇ ±æÀÌ¸¦ Àê ¶§´Â \0Àº °í·ÁÇÏÁö ¾Ê¾Æ¾ß ÇÏ±â ¶§¹®¿¡ sizeofº¸´Ù´Â strlen ÇÔ¼ö¸¦ ¾¸.
	c¿¡´Â boolean ÀÚ·áÇüÀÌ ¾ø´Ù.
	Á¤¼öÇüÀ» ¾²´Âµ¥ 0Àº false, 0ÀÌ ¾Æ´Ñ°ÍµéÀº true
*/