#include <iostream>
#include <cstdlib>
#include <iomanip>

using namespace std;

int main(int argc, char **argv) {
	cout << "Hi! " << setw(4) << 5 << " " << 5 << endl;
	cout << hex << 16 << " " << 13 << endl;
	cout << dec << 16 << " " << 13 << endl;
	return EXIT_SUCCESS;
}