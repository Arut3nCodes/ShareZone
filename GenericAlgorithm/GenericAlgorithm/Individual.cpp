#include <iostream>
#include <random>
#include "Individual.h"



Individual::Individual() {
	 std::cout << "create" << std::endl;
}

Individual::Individual(int genotypeLength) {
	std::cout << "create" << std::endl;
	std::random_device rd;
	std::mt19937 e2(rd());
	std::uniform_int_distribution<> dist(0, 1);
	
	for (int i = 0; i < genotypeLength; i++) {
		genotype.push_back((dist(e2) % 2) == 1);
	}
}

Individual::Individual(std::vector<bool>* vector) {
	genotype = *vector;
}

double Individual::calculateFitness(KnapsackProblem& problemInstance) {
	return problemInstance.evaluateIndividual(genotype);
}

void Individual::mutate(double mutationProbability) {
	std::random_device rd;
	std::mt19937 e2(rd());
	std::uniform_real_distribution<> dist(0, 1);

	for (int i = 0; i < genotype.size(); i++) {
		if (dist(e2) < mutationProbability) {
			genotype[i] = !genotype[i];
		}
	}
	//std::cout << std::endl;
}

std::vector<bool>& Individual::getGenotype() {
	return genotype;
}

Individual* Individual::crossParents(Individual& parent) {
	std::random_device rd;
	std::mt19937 e2(rd());
	std::uniform_int_distribution<> dist(0, genotype.size()-1);

	int splitIndex = dist(e2);

	// std::cout << "Punkt rozciecia: "<< splitIndex << std::endl;

	std::vector<bool> split_lo(genotype.begin(), genotype.begin() + splitIndex);
	std::vector<bool> split_hi(genotype.begin() + splitIndex, genotype.end());
	std::vector<bool> split_lo2((parent.getGenotype()).begin(), (parent.getGenotype()).begin() + splitIndex);
	std::vector<bool> split_hi2((parent.getGenotype()).begin() + splitIndex, (parent.getGenotype()).end());
	split_lo.insert (split_lo.end(), split_hi2.begin(), split_hi2.end());
	split_lo2.insert (split_lo2.end(), split_hi.begin(), split_hi.end());

	Individual* array = new Individual[2];
	array[0] = Individual(&split_lo);
	array[1] = Individual(&split_lo2);
	return array;
}

void Individual::printOutGenotype() {
	for (bool b : genotype) std::cout << b;
}




