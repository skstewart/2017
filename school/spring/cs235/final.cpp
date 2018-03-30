/*
Name: Shayna Stewart
Date Due: 5/31/2017
Final Exam Project
Description: Takes in a user-specified file of temperatures. Reads the arraysize and creates a dynamic array,
then reads the temperature data into the array. Sorts the array, then computes a sum and average of 
temperatures. Computes the number of temperatures above the averagetemperature, then writes
the arraySize (number of elements), the sorted temperatures, the average temperature, and the number 
of temperatures that are above the average temperature into a file. Closes both files, then exits.
Program exits if there is an error opening either the user-specified file, or the new file.
*/
#include <iostream>
#include <algorithm>
#include <fstream>
#include <cstdlib>
#include <string>
#include <iomanip>
using namespace std;


int main()
{
	ofstream outFile;
	string outFileName;
	ifstream inputFile; //the file to take data from
	string fileName; //name of the file to save
	int arraySize; //number of elements (first number read from inFile)
	double sum = 0;
	double avg;
	int aboveAvg = 0; //number of elements that are above the average



	cout << "Please enter file name you wish to open: ";
	getline(cin, fileName);

	// Open the file
	inputFile.open(fileName.c_str());

	// Check for successful opening
	if (inputFile.fail())
	{
		cout << "The file was opened unsuccessfully. Program will exit." << endl;
		exit(1);
	}

	cout << "\nThe file has been successfully opened for reading.\n";

	inputFile >> arraySize;

	double* temperatures = new double[arraySize]; //creates dynamic array that adjusts to arraySize

	for (int x = 0; x < arraySize; x++){
		inputFile >> temperatures[x];
	}

	/* test the array
	for (int x = 0; x < arraySize; x++){
		cout << "\n" << temperatures[x];
	} */

	

	sort(temperatures, temperatures+arraySize);

	for (int x = 0; x < arraySize; x++){
		sum += temperatures[x];
	} 

	avg = sum / arraySize;

	for (int x = 0; x < arraySize; x++){
		if (temperatures[x] > avg){
			aboveAvg++;
		}
	}
	


	cout << "\nPlease enter file name you wish to write: ";
	getline(cin, outFileName);

	outFile.open(outFileName.c_str());

	outFile << arraySize << "\n";

	for (int i = 0; i < arraySize; i++){
		outFile << temperatures[i] << endl;
	}
	outFile << avg << "\n" << aboveAvg;

	// Check for successful opening
	if (outFile.fail())
	{
		cout << "The file was opened unsuccessfully. Program will exit." << endl;
		exit(1);
	}

    cout << "\n" << outFileName << " has been successfully written.";

	outFile.close();
	inputFile.close();
	cin.ignore();
	return 0;
}