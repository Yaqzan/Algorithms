#include <sys/types.h> 
#include <stdio.h>
#include <iostream>
#include <string>
#include <sstream>
#include <string.h>
#include <stdlib.h>
#include <errno.h>
#include "uandf.h"
#include <fstream>

void CountingSort(int arr[], int sz) {
	int i, j, k;
	int idx = 0;
	int min, max;

	min = max = arr[0];
	for (i = 1; i < sz; i++) {
		min = (arr[i] < min) ? arr[i] : min;
		max = (arr[i] > max) ? arr[i] : max;
	}

	k = max - min + 1;
	/* creates k buckets */
	int *B = new int[k];
	for (i = 0; i < k; i++) B[i] = 0;

	for (i = 0; i < sz; i++) B[arr[i] - min]++;
	for (i = min; i <= max; i++)
	for (j = 0; j < B[i - min]; j++) arr[idx++] = i;


	delete[] B;
}

int main(){
	int size = 71 * 71;
	size++;
	std::string line;
	int count = 1;
	char plus = '+';
	int picArray[71 * 71 + 1];
	std::ifstream pFile("girl.img");
	if (pFile.is_open()){
		while (pFile.good()){
			getline(pFile, line);
			std::cout << line << "\n";
			for (int i = 0; i < 71; i++){
				if (line.at(i) == plus)
					picArray[count] = 1;
				else
					picArray[count] = 0;

				count++;
			}
		}
		pFile.close();
	}
	else
		std::cout << "unable to open da file";




	uandf array = uandf(size);

	for (int i = 1; i < size; i++){
		if (picArray[i] == 1)
			array.make_set(i);
	}

	for (int i = 1; i < size; i++){
		if (picArray[i] == 1){
			if (picArray[i + 1] == 1 && ((i % 71) != 0))
				array.union_set(i, (i + 1));
			if (picArray[i + 71] == 1)
				array.union_set(i, (i + 71));
		}
	}


	//Make letters
	char abc[(71 * 71) + 1];
	for (int i = 0; i < size; i++){
		abc[i] = '1';
	}

	int root, inc = 0;
	for (int i = 1; i < size; i++){
		// Check if set has already been visited
		root = array.find_set(i);
		if (abc[root] == '1' && picArray[i] == 1){
			abc[root] = (inc + 65);
			inc++;
		}
	}

	//Print Array with Letters
	count = 1;
	for (int i = 0; i < 71; i++){
		for (int j = 0; j < 71; j++){
			root = array.find_set(count);
			if (abc[root] == '1')
				std::cout << " ";
			else
				std::cout << abc[root];
			count++;
		}
		std::cout << "\n";
	}

	// Make array of all the sizes
	int sizes[71*71];
	char abc2[(71 * 71) + 1];
	for (int i = 0; i < size; i++){
		abc2[i] = abc[i];
	}

	//Dupicates array for help with later function
	count = 0;
	for (int i = 1; i < size; i++){
		if (abc[i] != '1'){
			sizes[count]= array.get_size(i);
			abc2[i] = abc[i];
			count++;
		}
	}

	//Sort the sizes
	CountingSort(sizes, 21);

	// Print the list
	for (int i = 0; i < count; i++){
		for (int j = 0; j < size; j++){
			if (abc2[j] != '1'){
				if (sizes[i] == array.get_size(j)){
					std::cout << abc2[j] << " = ";
					abc2[j] = '1';
					break;
				}
			}
		}
		std::cout << sizes[i] << "\n";
	}

	//Print Array with Letters omitting size 1
	count = 1;
	for (int i = 0; i < 71; i++){
		for (int j = 0; j < 71; j++){
			if (array.get_size(count) != 1){
				root = array.find_set(count);
				if (abc[root] == '1')
					std::cout << " ";
				else
					std::cout << abc[root];
			}
			else
				std::cout << " ";

			count++;
		}
		std::cout << "\n";
	}
	std::cout << "number of sets: " << array.get_sets() << "\n";

	system("pause");
	return 0;
}
