#include <iostream>
#include <string>
#include <vector>
#include "CNodeDynamic.h"

CNodeDynamic::CNodeDynamic() {
	val = 0; 
	pcParentNode = NULL;
}

CNodeDynamic::~CNodeDynamic() {
	std::cout << "BloodTrail" << std::endl;
	if (!children.empty()) {
		for (int i = 0; i < children.size(); i++) {
			//children[i]->~CNodeDynamic();
			delete children[i];
		}
	}
	children.clear();
}

void CNodeDynamic::setValue(int newVal) {
	val = newVal;
}

int CNodeDynamic::getChildrenNumber() {
	return children.size();
}

void CNodeDynamic::addNewChild() {
	CNodeDynamic* node = new CNodeDynamic();
	children.push_back(node);
}

CNodeDynamic* CNodeDynamic::pcGetChild(int childOffset) {
	if (childOffset + 1 > children.size()) return NULL;
	else return children[childOffset];
}

void CNodeDynamic::print() { 
	std::cout << " " << val; 
}

void CNodeDynamic::printAllBelow() {
	print();
	std::cout << "( ";
	for (std::vector<CNodeDynamic*>::iterator it = children.begin(); it != children.end(); it++) {
		(**it).printAllBelow();
	}
	std::cout << ") ";
}
