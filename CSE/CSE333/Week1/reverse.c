#include <stdio.h>	
#include <stdint.h>	// use for uint32_int for 32 bit unsigned chars
#include <assert.h>	// used for the assertion

void ReverseArray(uint32_t *arr,  unsigned int len) {
	int i;

	if (len <= 1)
		return;

	// checks to see if the array was valid.
	assert(arr != NULL);

	// does the actual reversal of the array
	for (i = 0; i < (len/2); i++) {
		uint32_t tmp;

		tmp = arr[i];
		arr[i] = arr[len - i - 1];
		arr[len - i - 1] = tmp;
	}
}

// prints out the contents of the array
void printArray(uint32_t *arr, int len) {
	int i;

	for (i = 0; i < len; i++) {
		if (i == 0)
			printf("%u\n", arr[0]);
		else
			printf(" %u\n", arr[i]);
	}
	printf("\n");
}

int main(int argc, char **argv) {
	uint32_t arr[3] = {1, 2, 3};
	uint32_t arr2[4] = {1, 2, 3, 4};

	printArray(arr, 3);
	ReverseArray(arr, 3);
	printArray(arr, 3);

	printArray(arr2, 4);
	ReverseArray(arr2, 4);
	printArray(arr2, 4);

	return 0;
}