#pragma once
#include "Individual.h"

class GeneticAlgorithm
{
private:
	int numOfIter;
	int popSize;
	double mutProb;
	double crossProb;
	std::vector<Individual>* population;
	KnapsackProblem problem;
	Individual bestGenotype;
	void evaluateGeneration();
public:
	GeneticAlgorithm(int numberOfIterations, int populationSize, double mutationProbability, double crossingProbability);
	void runSimulation();
	void runOneIteration();
	void generateFirstPopulation();
	std::vector<bool>& getBestSolution();
};

