#include <stdio.h>

int main(int argc, char **argv) {
	int x = 42;
	int *p;
	p = &x;

	printf("x is %d\n", x);
	*p = 99;
	printf("x is %d\n", x);w
}