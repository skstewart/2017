/*
Shayna Stewart
Chapter 2 Exercise 4
Due: 3/8/17
2Exercise4.cpp
Description: finds the sum of a set of numbers, a through n.
*/


#include <iostream>
using namespace std;

int main() {
	//2.00000035 x 1010 sec - 1
	int a, n, sum, d;
	sum = 0;
	a = 100;
	n = 1000;
	d = 1;

	sum = ((n-a+1)*(a + n)*d)/2;
	
	cout << "The sum of " << a << " through " << n << " is " << sum << endl;    
	cin.ignore();
	return 0;
}
