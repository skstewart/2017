/*
Shayna Stewart
Chapter 2.6  Exercise 5
Due: 3/8/17
2-6E5.cpp
Takes in a temperature in fahrenheit and converts it to celsius.
*/


#include <iostream> 
using namespace std;

int main() {
	double f, c;
	f = 86.5;
	c = ((5.0 / 9.0)*(f - 32.0));
	cout << "For a Fahrenheit temperature of " << f << " degrees, the equivalent Celsius temperature is " << c << " degrees." << endl;
	cin.ignore();
	return 0;
}