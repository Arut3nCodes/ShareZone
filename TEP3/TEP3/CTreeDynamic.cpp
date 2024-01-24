#include <iostream>
#include <string>
#include <vector>
#include "CNodeDynamic.h"

CTreeDynamic::CTreeDynamic() {
	pcRoot = new CNodeDynamic();
}

CTreeDynamic::~CTreeDynamic() {
	delete pcRoot;
}

CNodeDynamic* CTreeDynamic::pcGetRoot() {
	return pcRoot;
}

void CTreeDynamic::printTree() {
	pcRoot->printAllBelow();
}