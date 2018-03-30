/*
Programmer: Shayna Stewart
Date: 3/29/17
Exercise 5 in the Programming Projects for Chapter 4
Description:  prompts the user for the type of beam, 1 for I-beam, 2 for rectangular
beam and 3 for cylindrical beam, the necessary measurement data (based on the type of beam), and
then computes and displays the beam’s rectangular moment of inertia, I.
*/


#include <iostream>
#include <cmath> 
using namespace std;

int main() {
	int totalNum; // total number of data values to be averaged
	double sum;
	double average;
	double entry;


	cout << "Please type in the total number of data values to be averaged:\n" << endl;
	cin >> totalNum;
			
	for (int x = 0; x < totalNum; x++){
		cout << "Please enter data value (entry number " << x << ")." << endl;
		cin >> entry;
		sum += entry;
	}
	average = sum / totalNum;
	cout << "The average of the entered data values is " << average << "." << endl;
		cin.ignore(2);
	return 0;
}