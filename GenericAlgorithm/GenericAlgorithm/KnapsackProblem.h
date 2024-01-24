#pragma once
#include <string>
#include <vector>

class KnapsackProblem
{
private:
	double sizeOfBackpack;
	double maxPossibleValue;
	std::vector<double> weights;
	std::vector<double> values;

public:
	KnapsackProblem();
	KnapsackProblem(double sizeOfBackpack);
	double getSize();
	double getMaxPossibleValue();
	int getGenotypeLength();
	std::vector<double>& getWeights();
	std::vector<double>& getValues();
	double evaluateIndividual(std::vector<bool>& genotype);
	void loadItemsFromFile(std::string fileName);
};
 




