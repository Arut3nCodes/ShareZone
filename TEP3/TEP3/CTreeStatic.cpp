#include <iostream>
#include <string>
#include <vector>

#include "CNodeStatic.h"
#include "CTreeStatic.h"

CTreeStatic::CTreeStatic() {
	c_root;
}

CTreeStatic::~CTreeStatic() {
}

CNodeStatic* CTreeStatic::pcGetRoot() { 
	return(&c_root); 
}

void CTreeStatic::printTree() {
	c_root.printAllBelow();
}
