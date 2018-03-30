/*
Programmer: Shayna Stewart
Date: 4/17/2017
Program 5.7 for Quiz 4
Description: Asks the user how many entries to average, then takes the data in, adds to a sum variable, and takes the average.
*/


#include <iostream>
#include <cmath> 
using namespace std;

int main() {
	int totalNum; // total number of data values to be averaged
	double sum = 0;
	double average;
	double entry;


	cout << "Please type in the total number of data values to be averaged:\n" << endl;
	cin >> totalNum;

	for (int x = 0; x < totalNum; x++){
		cout << "Please enter data value (entry number " << (x+1) << ")." << endl;
		cin >> entry;
		sum += entry;
	}
	average = sum / totalNum;
	cout << "The average of the entered data values is " << average << "." << endl;
	cin.ignore(2);
	return 0;
}
