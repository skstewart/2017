/*
Name: Shayna Stewart
Quiz 3
Chapter 3 Exercise 4, page 173
Description: Takes in user input to calculate amount of bacteria in the culture at a given time
*/


#include <iostream>
#include <math.h>
using namespace std;


	int main(){
		double t = 72;
		double e = 2.71828;
		
		//cout << "Enter the amount of hours passed" << endl;
		//cin >> t;
		double B = 300000 * (pow(e, (-0.032 * t)));
		cout << "There are " << B << " bacteria in the culture after " << t << " hours." << endl;

		cin.ignore(2);
		return 0;

		
}