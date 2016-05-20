#include <stdio.h>

// calculates a sum of two numbers and returns it
int calc(int i, int j);

int main(int argc, char **argv) {
	printf("The sum of 1 + 2 is %d\n", calc(1, 2));
	return 0;
}

int calc(int i, int j) {
	return i + j;
}