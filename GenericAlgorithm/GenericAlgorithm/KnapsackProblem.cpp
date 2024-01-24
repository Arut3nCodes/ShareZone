#include <vector>
#include <fstream>
#include <iostream>
#include "KnapsackProblem.h"

// DATA INPUT FROM FILE -> SIZE ONCE >> WEIGHT >> VALUE

KnapsackProblem::KnapsackProblem() {
	sizeOfBackpack = 10;
	maxPossibleValue = 0;
}

KnapsackProblem::KnapsackProblem(double sizeOfBp) {
	sizeOfBackpack = sizeOfBp;
	maxPossibleValue = 0;
}

double KnapsackProblem::getSize() {
	return sizeOfBackpack;
}

double KnapsackProblem::getMaxPossibleValue() {
	return maxPossibleValue;
}

int KnapsackProblem::getGenotypeLength() {
	return weights.size();
}

std::vector<double>& KnapsackProblem::getWeights() {
	return weights;
}

std::vector<double>& KnapsackProblem::getValues() {
	return values;
}

double KnapsackProblem::evaluateIndividual(std::vector<bool>& genotype) {
	double genotypeWeight = 0;
	double genotypeValue = 0;
	for (int i = 0; i < genotype.size(); i++) {
		if (genotype[i]) {
			genotypeWeight += getWeights()[i];
			genotypeValue += getValues()[i];
		}
	}
	if (genotypeWeight > getSize()) return 0;
	else return genotypeValue / getMaxPossibleValue();
}

void KnapsackProblem::loadItemsFromFile(std::string fileName) {
	std::ifstream file(fileName);
	if (file.is_open()) {
		int weight, value, lines;
		file >> lines;
		for (int i = 0; i < lines; i++) {
			file >> weight >> value;
			weights.push_back(weight);
			values.push_back(value);

			std::cout << weight << " " << value << std::endl;

			maxPossibleValue += value;
		}
		std::cout << maxPossibleValue;
		file.close();
	}
}

