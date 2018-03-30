/*
Name: Shayna Stewart
Quiz 3
Chapter 3, figure 3.14
Description: finds a mass
*/


#include <iostream>
#include <math.h>
using namespace std;


int main(){
	double r1, r2, m1, m2;



	cout << "Enter the mass supported by the first piston(kg) :" << endl;
	cin >> m1;
	cout << "Enter the radius of the first piston(cm) :" << endl;
	cin >> r1;
	cout << "Enter the radius of the second piston(cm) :" << endl;
	cin >> r2;
	m2 = ((pow(r2, 2)) / (pow(r1, 2)) * m1);
	cout << "The mass m2 of the second piston is equal to " << m2 << " kg." << endl;

	cin.ignore(4);
	return 0;


}
