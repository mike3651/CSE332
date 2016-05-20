#include <stdio.h>

int sumTo(int max) {
	int i, sum = 0;

	for (i = 1; i <= max; i++) 
		sum+=i;
	return sum;
}

int main(int argc, char **argv) {
	printf("sumTo[5] is: %d\n",  sumTo(5));
	return 0;
}