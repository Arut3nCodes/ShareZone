#pragma once
#include <vector>
#include "KnapsackProblem.h"

class Individual
{
private:
	std::vector<bool> genotype;
	//KnapsackProblem* parent();
public:
	Individual();
	Individual(int genotypeLength);
	Individual(std::vector<bool>* wektorek);
	double calculateFitness(KnapsackProblem& problemInstance);
	void mutate(double mutationProbability);
	Individual* crossParents(Individual& parent);
	std::vector<bool>& getGenotype();
	void printOutGenotype();
};



