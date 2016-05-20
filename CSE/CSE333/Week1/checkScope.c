#include <stdio.h>

int main(int argc, char **argv) {
	int x, y = 5;		// x was defaulted to '0'
	long z = x + y;

	printf("z is '%ld'\n", z);

	{
		int y = 10;
		printf("y is '%d'\n", y);
	}
	int w = 20;
	printf("y is '%d', w is '%d'\n", y, w);	// takes the original y do to scope
	return 0;
}