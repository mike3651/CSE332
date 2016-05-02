#include <cstdlib>
#include <iostream>

using namespace std;


void CalcArea(const int &width, const int &height, int *const area) {
	*area = width * height;
}

int main(int argc, char **argv) {
	int w = 10, h = 20, a;
	CalcArea(w, h, &a);
	printf("The value of the area should be 200, it is: %d\n", a);
	return EXIT_SUCCESS;
}