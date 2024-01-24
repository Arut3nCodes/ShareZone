#include <iostream>
#include <string>
#include <vector>
#include <iterator>

#include "CNodeStatic.h"

CNodeStatic::CNodeStatic() {
	val = 0; 
	pcParentNode = NULL; 
}


CNodeStatic::~CNodeStatic() {
	std::cout << "Object removed KEK" << std::endl;;
	children.clear();
}

void CNodeStatic::setValue(int newValue) {
	val = newValue;
}

int CNodeStatic::getChildrenNumber() {
	return (children.size());
}


void CNodeStatic::setParent(CNodeStatic* pcNode) {
	pcParentNode = pcNode;
}

void CNodeStatic::addNewChild() {
	CNodeStatic node;
	node.setParent(this);
	children.push_back(node);
}

CNodeStatic* CNodeStatic::pcGetChild(int childOffset) {
	if (childOffset + 1 > children.size()) return NULL;
	else return &children[childOffset];
}

void CNodeStatic::print() { 
	std::cout << " " << val; 
}

void CNodeStatic::printAllBelow() {
	print();
	std::cout << "( ";
	for (std::vector<CNodeStatic>::iterator it = children.begin(); it != children.end(); it++) {
		(*it).printAllBelow();
	}
	std::cout << ") ";
}

void CNodeStatic::printUp() {
	print();
	if (pcParentNode != NULL) pcParentNode->printUp();
	else std::cout << std::endl;
}