/*
Programmer: Shayna Stewart
Due Date: 5/07/2017
Exercise 1 in Programming Projects for Chapter 7 (10 points):
Description: Takes in scores, finds the average and displays that average and the sum of all scores, then displays the scores with 
an asterisk next to the scores that are below the average. 
*/


#include <iostream>
#include <array>
#include <cmath> 
#include <iomanip>
using std::setw;
using namespace std;

int main(){
	double scoreArray [35];
	string scoreArrayString[35];
	double score;
	double sum = 0;
	double avg;
	int numOfScores = 0;
	cout << "Please enter up to 35 scores." << endl;
	for (int x = 0; x < 35; x++){
		cout << "Enter a score or a negative number to exit:" << endl;
		cin >> score;
		if (score < 0){
			break;
		}
		else if (score > 100){
			x--;
			cout << "Please enter a score between 0 and 100. Enter a value below 0 to exit." << endl;
		}
		else{
			scoreArray[x] = score;
			sum += score;
			numOfScores++;
		}

	}
	if (numOfScores < 1){
		cout << "You did not enter any scores." << endl;
	}
	else {
		avg = sum / numOfScores;
		cout << "A total of " << numOfScores << " scores were entered." << endl;
		cout << "The sum of these scores is: " << sum << endl;
		cout << "The average of these scores is: " << avg << endl;
		cout << "The individual scores entered were: " << endl;
		for (int s = 0; s < numOfScores; s++){
			if (scoreArray[s] > 89){
				if (scoreArray[s] < avg){
					cout << setw(5) << "* " << setw(10) << scoreArray[s] << setw(10) << " A" << endl;
				}
				else {
					cout << setw(5) << "  " << setw(10) << scoreArray[s] << setw(10) << setw(10) << " A" << endl;
				}
			}
			else if (scoreArray[s] > 79 && scoreArray[s] < 90){
				if (scoreArray[s] < avg){
					cout << setw(5) << "* " << setw(10) << scoreArray[s] << setw(10) << " B " << endl;
				}
				else {
					cout << setw(5) << " " << setw(10) << scoreArray[s] << setw(10) << " B" << endl;
				}
			}
			else if (scoreArray[s] > 69 && scoreArray[s] < 80){
				if (scoreArray[s] < avg){
					cout << setw(5) << "* " << setw(10) << scoreArray[s] << setw(10) << " C" << endl;
				}
				else {
					cout << setw(5) << " " << setw(10) << scoreArray[s] << setw(10) << " C" << endl;
				}
			}
			else if (scoreArray[s] > 59 && scoreArray[s] < 70)
			{
				if (scoreArray[s] < avg){
					cout << setw(5) << "* " << setw(10) << scoreArray[s] << setw(10) << " D" << endl;
				}
				else {
					cout << setw(5) << " " << setw(10) << scoreArray[s] << setw(10) << " D" << endl;
				}
			}
			else  {
				if (scoreArray[s] < avg){
					cout << setw(5) << "* " << setw(10) << scoreArray[s] << setw(10) << " F" << endl;
				}
				else {
					cout << setw(5) << " " << setw(10) << scoreArray[s] << setw(10) << " F" << endl;
				}
			}
			
			
		}
		cout << "(An asterisk * denotes a score which is lower than average.)" << endl;
			
	}

	cin.ignore(2); 
	return 0;

}
