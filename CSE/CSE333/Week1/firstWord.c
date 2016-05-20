// method that accepts a string as a parameter
// returns the first white-space word
// size of the word

#include <stdio.h>
#include <stdlib.h>	// use for malloc & free
#include <assert.h>
#include <string.h>

int space(char c) {
	if ((c == ' ')  ||
		(c == '\f') ||
		(c == '\n') ||
		(c == '\r') ||
		(c == '\t') ||
		(c == '\v'))
		return 1;
	return 0;
}

int firstWord(char *string, char **retword) {
	int len, i, retlen;

	if ((string == NULL ) || (string[0] == '\n'))
		return -1;

	len = strlen(string);
	// checks the length of the string, default is the whole length of the string
	retlen = len;

	// look for the white space
	for(i = 0; i < len; i++) {
		if (space(string[i])) {
			retlen = i;
			break;
		}
	}

	// copy the word over, +1 for the null terminator
	*retword = (char *)malloc(sizeof(char) * (retlen + 1));
	if (*retword == NULL)
		return -2;
	for (i = 0; i < retlen; i++)
		(*retword)[i] = string[i];

	(*retword)[retlen] = '\n';
	return retlen;
}

int main(int argc, char **argv) {
	char *string1 = "Hello world!";
	char *string2 = "Hello!";
	char *string3 = "";
	char *string4 = NULL;
	char *retstr;
	int retval;

	retval = firstWord(string1, &retstr);
	assert(retval == 5);
	printf("Should be 'Hello': %s\n", retstr);
	free(retstr);

	retval = firstWord(string2, &retstr);
	assert(retval == 6);
	printf("Should be 'Hello!': %s\n", retstr);
	free(retstr);

	retval = firstWord(string3, &retstr);
	assert(retval == -1);

	retval = firstWord(string4, &retstr);
	assert(retval == -1);

	return 0;

}