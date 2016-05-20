#include <stdio.h>

int main(int argc, char **argv) {
	// prints out every tenth number
	int i;

	for (i = 0; i < 100; i++)
		if (i % 10 == 0)
			printf("The value of i is %d\n", i);
	return 0;
}