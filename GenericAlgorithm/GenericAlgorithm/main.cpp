#include <iostream>
#include "Individual.h"
#include "KnapsackProblem.h"
#include "GeneticAlgorithm.h"

#define NUMBEROFITERATIONS = 1000;
#define POPULATIONSIZE = 4;
#define MUTATIONPROBABILITY = 0.1;
#define CROSSINGPROBABILITY = 0.6;

void indTest() {
	Individual i1(10), i2(10);
	std::cout << "Gen Uno -> ";
	i1.printOutGenotype();
	std::cout << "Gen Dos -> ";
	i2.printOutGenotype();

	i1.mutate(0.6);
	i1.printOutGenotype();

	Individual* crossed = i1.crossParents(i2);
	crossed[0].printOutGenotype();
	crossed[1].printOutGenotype();
	delete[] crossed;
}

int main() {
	//indTest();
	
	GeneticAlgorithm GAInstance(1000, 100, 0.1, 0.6);
	GAInstance.runSimulation();
	
	return 0;
}



