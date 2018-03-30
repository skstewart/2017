/*
Name: Shayna Stewart
Date Due: 5/17/2017
Quiz #7 Question 1
Description: Calculates the final grade of the students by taking input from the user, 
including exam1 score, exam2 score, final exam score, and homework score, for each student. 
Calculates the grade for each student entered, then outputs the data into a text file named
"grades.dat"

*/
#include <iostream>
#include <fstream>
#include <cstdlib>
#include <string>
#include <iomanip>
using namespace std;

int main(){
	string filename = "student.dat";
	string name;
	double exam1;
	double exam2;
	double hw;
	double final;
	double finalAvg;
	char letterGrade;
	int numOfStudents = 0;

	ofstream file;
	file.open(filename.c_str());

	while (numOfStudents < 1 || numOfStudents > 20){
		cout << "Enter the number of students: ";
		cin >> numOfStudents;
	}

	for (int i = 0; i < numOfStudents; i++){
		cout << "\nEnter the name for student: " << i + 1 << " : ";
		cin >> name;

		cout << "\nEnter the Exam 1 grade for student: " << i + 1 << " : ";
		cin >> exam1;

		cout << "\nEnter the Exam 2 grade for student: " << i + 1 << " : ";
		cin >> exam2;

		cout << "\nEnter the homework score for student: " << i + 1 << " : ";
		cin >> hw;

		cout << "\nEnter the final exam score for student: " << i + 1 << " : ";
		cin >> final;

		finalAvg = ((.2 * exam1) + (.2*exam2) + (.35*hw) + (.25 * final));
		if (finalAvg >= 90 && finalAvg <= 100)
			letterGrade = 'A';
		else if (finalAvg >= 80 && finalAvg <= 90)
			letterGrade = 'B';
		else if (finalAvg >= 70 && finalAvg <= 80)
			letterGrade = 'C';
		else if (finalAvg >= 60 && finalAvg <= 70)
			letterGrade = 'D';
		else
			letterGrade = 'F';

		cout << "Name: " << name << "\nexam1: " << exam1 << "\nexam2: " << exam2 << "\nhomework grade: "
			<< hw << "\nfinal exam: " << final << "\ngrade: " << finalAvg << "\nletter grade: " << letterGrade << endl;
		file << name << "\t" << exam1 << "\t" << exam2 << "\t"
			<< final << "\t" << finalAvg << "\t" << letterGrade << endl;
}
	file.close();
	cin.ignore(2);
	return 0;
}