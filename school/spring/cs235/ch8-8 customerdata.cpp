/*
Name: Shayna Stewart
Date Due: 5/17/2017
Quiz #7 Question 2
Description: Takes input from .dat file "customers.dat", puts into four respective arrays for 
first name, last name, account number, and balance amount. Takes input from the user to find 
an account number, and displays the data for that account number. Allows user to make as many
searches as desired, and exits when user inputs "-1". Also tells a customer if an account
number entered does not exist.

*/

#include <iostream>
#include <string>
#include <fstream>
using namespace std;

int main(){
	
	ifstream data("customers.dat");
	int accountNumber[5];
	string firstName[5];
	string lastName[5];
	double balance[5];

	int x = 0;
	while (!data.eof()){

		data >> accountNumber[x];
		data >> firstName[x];
		data >> lastName[x];
		data >> balance[x];
		x++;
	}

	int toFind;
	
	while (bool search = true)
	{
		cout << "Enter an account number to search. Enter -1 to exit: ";
		cin >> toFind;
		bool found = false;
		for (int i = 0; i < 5; ++i){
			if (accountNumber[i] == toFind){
				cout << endl;
				cout << "Account Number: " << accountNumber[i] << endl;
				cout << "First Name: " << firstName[i] << endl;
				cout << "Last Name: " << lastName[i] << endl;
				cout << "Account Balance: " << balance[i] << endl;
				cout << endl;
				found = true;
				search = false;
				break;
			}
		}
		if (found == false && toFind != -1){
				cout << "Account Number dosen't Exist\n";
			
			}
		else if (toFind == -1){
			cout << "program exit." << endl;
			data.close();
			return 0;
		}

		
	}

	data.close(); 
	return 0;
}