#include "GeneticAlgorithm.h"
#include <iostream>
#include <vector>
#include <random>

GeneticAlgorithm::GeneticAlgorithm(int numberOfIterations, int populationSize, double mutationProbability, double crossingProbability) {
	numOfIter = numberOfIterations;
	popSize = populationSize;
	mutProb = mutationProbability;
	crossProb = crossingProbability;
}

void GeneticAlgorithm::runSimulation(){
	
	double sizeOfBackpack = 26;

	problem = std::move(KnapsackProblem(sizeOfBackpack));
	problem.loadItemsFromFile("problem.txt");

	std::cout << "**Simulation start**" << std::endl;

	generateFirstPopulation();

	for (int i = 0; i < numOfIter; i++) {
		runOneIteration();
		evaluateGeneration();
		std::cout << "It " << 1 << ": Best Genotype -> ";
		bestGenotype.printOutGenotype();
		std::cout << " | Fitness -> " << bestGenotype.calculateFitness(problem) << std::endl << "Current Population -> ";
		for (Individual& i : (*population)) {
			i.printOutGenotype();
			std::cout << ", ";
		}
		std::cout << std::endl;
	}

	std::cout << "**Simulation finished**";
}

void GeneticAlgorithm::runOneIteration() {
	std::random_device rd;
	std::mt19937 e2(rd());
	std::uniform_int_distribution<> randInt(0, population->size() - 1);
	std::uniform_real_distribution<> randDouble(0, 1);
	std::vector<Individual>* newPopulation = new std::vector<Individual>;

	for (int i = 0; i < (*population).size()/2; i++) {
		Individual& PotentialParent1 = (*population)[randInt(e2)];
		Individual& PotentialParent2 = (*population)[randInt(e2)];
		Individual& PotentialParent3 = (*population)[randInt(e2)];
		Individual& PotentialParent4 = (*population)[randInt(e2)];
		Individual& finalParent1 = PotentialParent1.calculateFitness(problem) > PotentialParent2.calculateFitness(problem) ? PotentialParent1 : PotentialParent2;
		Individual& finalParent2 = PotentialParent3.calculateFitness(problem) > PotentialParent4.calculateFitness(problem) ? PotentialParent3 : PotentialParent4;

		if (randDouble(e2) < crossProb) {
			Individual* tabOfIndividuals = finalParent1.crossParents(finalParent2);
			newPopulation->push_back(std::move(tabOfIndividuals[0]));
			newPopulation->push_back(std::move(tabOfIndividuals[1]));
			delete[] tabOfIndividuals;
		}
		else {
			newPopulation->push_back(finalParent1);
			newPopulation->push_back(finalParent2);
		}
	}

	for (int i = 0; i < newPopulation->size(); i++) {
		(*newPopulation)[i].mutate(mutProb);
	}
	
	population->clear();
	delete population;
	population = newPopulation;
	std::cout << population->size() << std::endl;
	newPopulation = nullptr;
}

void GeneticAlgorithm::generateFirstPopulation() {
	population = new std::vector<Individual>;
	int genLen = problem.getGenotypeLength();
	for (int i = 0; i < popSize; i++)
		population->push_back(Individual(genLen));

	for (Individual& c : *population) {
		c.printOutGenotype();
		std::cout << " ";
	}
	std::cout << std::endl;
}

void GeneticAlgorithm::evaluateGeneration() {
	Individual currBest = (*population)[0];

	currBest.getGenotype();

	for (int i = 1; i < (*population).size(); i++) {
		if (currBest.calculateFitness(problem) < (*population)[i].calculateFitness(problem)) 
			currBest = (*population)[i];
	}

	if(bestGenotype.calculateFitness(problem) < currBest.calculateFitness(problem)) bestGenotype = currBest;
}

std::vector<bool>& GeneticAlgorithm::getBestSolution() {
	return bestGenotype.getGenotype();
}