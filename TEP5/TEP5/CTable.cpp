#include <iostream>
#include <string>
#include "CTable.h"
#include "CMySmartPointer.h"

void copyArray(int* copiedArray, int* toBeCopiedIntoArray, int sizeCA, int sizeTBCA) {
	if (sizeCA > sizeTBCA) {
		for (int i = 0; i < sizeTBCA; i++) {
			toBeCopiedIntoArray[i] = copiedArray[i];
		}
	}

	else {
		for (int i = 0; i < sizeCA; i++) {
			toBeCopiedIntoArray[i] = copiedArray[i];
		}
	}
}

CTable::CTable() {
	s_name = "Default name";
	size = 10;
	array = new int[size];
	copied = false;
	std::cout << "bezp: '" + s_name + "'" << std::endl;
}

CTable::CTable(std::string sName, int iTableLen) {
	s_name = sName;
	size = iTableLen;
	array = new int[size];
	copied = false;
	std::cout << "parametr: '" << s_name << "'" << std::endl;
}

CTable::CTable(CTable& pcOther) {
	s_name = pcOther.s_name + "_copy";
	size = pcOther.size;
	array = new int[size];
	copied = false;
	copyArray(pcOther.array, array, pcOther.size, size);
	std::cout << "kopiuj: '" << s_name << "'" << std::endl;
}

CTable::CTable(CTable&& pcOther) {
	s_name = "syf";
	array = pcOther.array;
	size = pcOther.size;
	pcOther.copied = true;
	std::cout << "MOVE ";
}


CTable::~CTable() {
		if (!copied) delete[] array;
	std::cout << "usuwam: '" << s_name << "'" << std::endl;
}

void CTable::setName(std::string sName) {
	s_name = sName;
}

bool CTable::setNewSize(int iTableLen) {
	if (iTableLen > 0) {
		int* newArray = new int[iTableLen];
		copyArray(newArray, array, iTableLen, size);
		delete[] array;
		array = newArray;
		size = iTableLen;
		return true;
	}

	else return false;
}

CTable* CTable::pcClone() {

	CTable* newTable = new CTable(s_name, size);
	copyArray(array, (*newTable).array, size, (*newTable).size);
	return newTable;
}

CTable* CTable::share() {
	CTable* newTable = new CTable(s_name, size);
	delete[] newTable->array;
	newTable->array = array;
	return newTable;
}

void CTable::printOutAllInformation() {
	std::cout << "Nazwa klasy: " << s_name << " | Dlugosc tablicy: " << size << std::endl;
}

void CTable::initArray() {
	for (int i = 0; i < size; i++) {
		array[i] = INT_MAX;
	}
}

void CTable::setValueAt(int iOffset, int iNewVal) {
	if (iOffset >= 0 && iOffset < size) {
		array[iOffset] = iNewVal;
	}
	else {
		std::cout << "INCORRECT ARRAY POSITION" << std::endl;
	}

}

void CTable::printArray() {
	for (int i = 0; i < size; i++) {
		if (array[i] == INT_MAX) {
			std::cout << "x ";
		}
		else {
			std::cout << array[i] << " ";
		}
	}
	std::cout << std::endl;
}

CTable CTable::operator=(const CTable& pcOther)
{
	setName(pcOther.s_name);
	setNewSize(pcOther.size);
	copyArray(pcOther.array, array, pcOther.size, size);
	std::cout << "op= ";
	return (*this);
}

CTable& CTable::operator=(CTable&& pcOther) {
	if(this != &pcOther){
		//if (array != NULL) delete[] array;
		setName(pcOther.s_name);
		setNewSize(pcOther.size);
		array = pcOther.array;
		pcOther.copied = true;
		std::cout << "op= ";
		return (*this);
	}
}

CTable CTable::operator+(const CTable& toMergeTab) {
	CTable returnedTab;
	returnedTab.setNewSize(size + toMergeTab.size);
	int i = 0;
	int overallSize = size + toMergeTab.size;
	while (i < overallSize) {
		if (i < size) returnedTab.array[i] = array[i];
		else returnedTab.array[i] = toMergeTab.array[i - size];
		i++;
	}
	return returnedTab;
}