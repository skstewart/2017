/*
Programmer: Shayna Stewart
Date: 3/29/17
reynoldsnum.cpp
Exercise 6 in the Programming Projects for Chapter 4
Description: requests the velocity of water flowing
through a pipe, the pipe’s diameter and the water’s temperature. Then, calculates Reynold's number
*/


#include <iostream>
#include <cmath> 
using namespace std;

int main() {
	double reyNum; //  the Reynolds number(a dimensionless value).
	double velocity; //the velocity(m / s or ft / sec).
	double diameter; // the diameter of the pipe(m or ft).
	double viscosity = 0; // the kinematic viscosity of the fluid(m / s2 or ft / sec2)
	double temperature; // temperature in degrees celsius

	cout << "Please enter the temperature in degrees celsius (either 5, 10, or 15)" << endl;
	cin >> temperature;
	cout << "Please enter the velocity in m/s" << endl;
	cin >> velocity;
	cout << "Please enter the diameter of the pipe in m" << endl;
	cin >> diameter;

	while (viscosity == 0){
	if (temperature == 5)
		viscosity = 1.49 * pow(10, -6);
	else if (temperature == 5)
		viscosity = 1.49 * pow(10, -6);
	else if (temperature == 5)
		viscosity = 1.49 * pow(10, -6);
	else{
		cout << "Please re-enter the temperature in degrees celsius (either 5, 10, or 15)" << endl;
		cin >> temperature;
		}
	}

	reyNum = (velocity*diameter) / viscosity;
	cout << "The Reynold's number is " << reyNum << " ." << endl;

	cin.ignore(2);
	return 0;
}