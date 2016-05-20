#include <stdio.h>
#include <assert.h>

// This excercise deals with function pointers

void InvokeFunction(void (*f)(int), int arg) {
	assert(f != NULL);
	f(arg);
}

void FirstFunction(int a) {
	printf("In first function with the argument %d\n", a);
}

void SecondFunction(int b) {
	printf("In second function with the argument %d\n", b);
}

void ThirdFunction(int c) {
	printf("In third function with the argument %d\n", c);
}

int main(int argc, char **argv) {
	void (*g)(int);

	InvokeFunction(&FirstFunction, 5);
	InvokeFunction(&SecondFunction, 6);

	g = &ThirdFunction;
	InvokeFunction(g, 7);
	return 0;
}