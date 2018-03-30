/*
Shayna Stewart
Program 2.11
Due: 3/8/17
Program2-11.cpp
Description: Finds the speed of a car
*/


#include <iostream> 
using namespace std;

int main() {
	double speed, fe, fr;
	fe = 2e-10;   
	fr = 2.00000035e-10;
	speed = 6.685e8 * (fr - fe) / (fr + fe);  

	cout << "The speed is " << speed << " miles/hour" << endl;
	cin.ignore();
	return 0;
}