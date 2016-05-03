// Michael Wilson
// I/O Practice
// A bit rough, but it works
// This program reads input from a file, organizes it in two manners
// and then writes out the appropriate outputs

#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <stdbool.h>

// each name is no longer than 29 characters
#define NAME_LENGTH 29

// no more than 10 orders per customer
#define MAX_ITEM 10

// max number of customers
#define MAX_CUSTOMER 20


// no more than 20 customers
// --> no more than 200 orders total

// This the struct for the items of the customers
typedef struct {
	char itemName[NAME_LENGTH];		// keeps hold of the items name
	int amountPurchased;			// keeps track of the number of items
	float itemPrice;					// keeps track of the price of the item
}item ;

// This is the struct for the customer
typedef struct {
	char name[NAME_LENGTH];			
	item items[MAX_ITEM]; 				
	int itemCount;					// count of the items that the customer has so far
	float totalCost;
} customer;

/** This will read in the input file. **/
int readFile(FILE *infile, customer customerList[]);

/** This will create the timeline output file. **/
void writeToTime(FILE *outfile, customer customerList[]);

/** This will create the financial output file. **/
void writeToFinance();

/** This will sort the customers based on total value of purchases. 
 *  This method uses insertion sorting.
 **/
void sortByCustomers(customer customerList[], int length);

/** This will sort the items based on total value of the item. **/
void sortByValue(customer *thePerson);

/** Checks to see if we have seen the customer. */
bool doesNotExist(customer customerList[], char theName[], int length);

/** Updates the customers itemcount. */
void updateCustomer(customer customerList[], char theName[], int length, item theItem);

/** Method that prints out the items of the customer. */
void printItems(customer thePerson);

/** Method that prints out the customer list. */
void printCustomers(customer customerList[], int length);

/** Reverses the order of the customer list. */
void reverseList(customer customerList[], int length);

/** Reverses the order of the prices. */
void reversePrices(customer *thePerson);

int main() {
	FILE *infile = fopen("input.txt", "r");
	FILE *outfile1 = fopen("priority.txt", "w");
	FILE *outfile2 = fopen("moneyorder.txt", "w");
	
	customer customerList[MAX_CUSTOMER];

	readFile(infile, customerList);
	writeToTime(outfile1, customerList);
	reverseList(customerList, 5);
	writeToFinance(outfile2, customerList);

	// input format
	// name + number of items + name of item + price of item

}

int readFile(FILE *infile, customer customerList[]) {
	int quantity; 
	float price;
	char name[NAME_LENGTH], items[MAX_ITEM];
	int customerCount = 0;
	while(fscanf(infile, "%s %d %s %*c %f", name, &quantity, items,  &price) == 4)
	{
		customer c;
		// create the item
		item i;
		strcpy(i.itemName, items);
		i.amountPurchased = quantity;
		i.itemPrice = price;

		// see if the customer doesn't exist
		if (doesNotExist(customerList, name, customerCount)) {
			strcpy(customerList[customerCount].name, name);
			// create the customer			
			strcpy(c.name, name);		
			c.itemCount = 1;	
			customerCount++;
			c.items[c.itemCount - 1] = i;	
			c.totalCost = quantity * price;
			customerList[customerCount - 1] = c;
		} else {
			updateCustomer(customerList, name, customerCount, i);
		}				
	}

	for (int k = 0; k < customerCount; k++) {
		sortByValue(&customerList[k]);
	}		

	for (int k = 0; k < customerCount; k++) {
		reversePrices(&customerList[k]);
	}		

	// ITEMS HAVE BEEN SORTED //


	sortByCustomers(customerList, customerCount);

	// CUSTOMERS HAVE BEEN SORTED//

	return customerCount;
}

void writeToTime(FILE *outfile, customer customerList[]) {
	for (int i = 0; i < 5; i++) {
		// read through the customer
		customer temp = customerList[i];
		fprintf(outfile, "%s\n", temp.name);

		// get their items
		for (int j = 0; j < customerList[i].itemCount; j++) {
			item temporary = temp.items[j];
			fprintf(outfile, "%s %d $%.2f\n", temporary.itemName, temporary.amountPurchased
					, temporary.itemPrice);
		}
		fprintf(outfile, "\n");
	}
}

void writeToFinance(FILE *outfile, customer customerList[]) {
	for (int i = 0; i < 5; i++) {
		// read through the customer
		customer temp = customerList[i];
		fprintf(outfile, "%s, Total Order = $%.2f\n", temp.name, temp.totalCost);

		// get their items
		for (int j = 0; j < customerList[i].itemCount; j++) {
			item temporary = temp.items[j];
			fprintf(outfile, "%s %d $%.2f, Item Value = %.2f\n", 
					temporary.itemName, temporary.amountPurchased
					, temporary.itemPrice, temporary.itemPrice * temporary.amountPurchased);
		}
		fprintf(outfile, "\n");
	}
}

void sortByCustomers(customer customerList[], int length) {
	int j;
	// compare the customers by the total costs
	for (int i = 1;  i < length; i++) {
		customer tmp = customerList[i];
		int temp = customerList[i].totalCost;
		for (j = i; j > 0 && temp < customerList[j - 1].totalCost; j--)
			customerList[j] = customerList[j - 1];
		customerList[j] = tmp;
	}
}

void sortByValue(customer *thePerson) {
	int j, length = thePerson->itemCount;
	for (int i = 1; i < length; i++) {
		item tmp = thePerson->items[i];
		for (j = i; j > 0 && tmp.itemPrice < thePerson->items[j - 1].itemPrice; j--) {
			thePerson->items[j] = thePerson->items[j - 1];
		}
		thePerson->items[j] = tmp;
	}		
}


bool doesNotExist(customer customerList[], char theName[], int length) {
	bool DNE = true;
	for (int i = 0; i < length; i++) {
		if (strcmp(customerList[i].name, theName) == 0) {
			DNE = false;
			break;
		}
	}
	return DNE;
}

void updateCustomer(customer customerList[], char theName[], int length, item theItem) {
	for (int i = 0; i < length; i++) {
		// found the customer
		if (strcmp(customerList[i].name, theName) == 0) {			
			customerList[i].items[customerList[i].itemCount] = theItem;
			customerList[i].itemCount++;
			customerList[i].totalCost += theItem.itemPrice * theItem.amountPurchased;
		}
	}
}

void printItems(customer thePerson){
	for (int i = 0; i < thePerson.itemCount; i++)
		printf("Item: %s; Cost: %f\n", thePerson.items[i].itemName, thePerson.items[i].itemPrice);
}

void printCustomers(customer customerList[], int length) {
	for (int k = 0; k < length; k++) {
		printf("Person: %s; ItemCount: %d\n", customerList[k].name, customerList[k].itemCount);
	}		
}

void reverseList(customer customerList[], int length) {
	for (int i = 0; i < length / 2; i++) {
		customer temp = customerList[i];
		customerList[i] = customerList[length - i - 1];
		customerList[length - i - 1] = temp;
	}
}

void reversePrices(customer *thePerson) {
	for (int i = 0; i < thePerson->itemCount / 2; i++) {
		item temp = thePerson->items[i];
		thePerson->items[i] = thePerson->items[thePerson->itemCount - i - 1];
		thePerson->items[thePerson->itemCount - i - 1] = temp;
	}
}
