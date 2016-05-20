#include <stdio.h>

// pass by value
void add_pbv(int c) {
	c += 10;
	printf("The value of C is %d\n", c);
}

// pass by reference
void add_pbr(int *c) {
	*c += 10;
	printf("The reference value of C is %d\n", *c);
}

int main(int argc, char **argv) {
	int x = 1;

	printf("x: %d\n", x);

	add_pbv(x);
	printf("x: %d\n", x);	// stays the same

	add_pbr(&x);
	printf("x: %d\n", x);	// changes the value of x
	return 0;
}