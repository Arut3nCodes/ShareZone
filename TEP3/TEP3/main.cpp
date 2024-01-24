#include <iostream>
#include <string>
#include <vector>

#include "CNodeStatic.h"
#include "CTreeStatic.h"
#include "CNodeDynamic.h"

void staticNodeTest()
{
    CNodeStatic c_root;
    c_root.addNewChild();
    c_root.addNewChild();
    c_root.pcGetChild(0)->setValue(1);
    c_root.pcGetChild(1)->setValue(2);
    c_root.pcGetChild(0)->addNewChild();
    c_root.pcGetChild(0)->addNewChild();
    c_root.pcGetChild(0)->pcGetChild(0)->setValue(11);
    c_root.pcGetChild(0)->pcGetChild(1)->setValue(12);
    c_root.pcGetChild(1)->addNewChild();
    c_root.pcGetChild(1)->addNewChild();
    c_root.pcGetChild(1)->pcGetChild(0)->setValue(21);
    c_root.pcGetChild(1)->pcGetChild(1)->setValue(22);
    c_root.printAllBelow();
    c_root.pcGetChild(1)->pcGetChild(1)->printUp();
}

void staticTreeTest() {
    CTreeStatic cTree;
    cTree.pcGetRoot()->addNewChild();
    cTree.pcGetRoot()->addNewChild();
    cTree.printTree();
}

void dynamicNodeTest()
{
    CNodeDynamic c_root;
    c_root.addNewChild();
    c_root.addNewChild();
    c_root.pcGetChild(0)->setValue(1);
    c_root.pcGetChild(1)->setValue(2);
    c_root.pcGetChild(0)->addNewChild();
    c_root.pcGetChild(0)->addNewChild();
    c_root.pcGetChild(0)->pcGetChild(0)->setValue(11);
    c_root.pcGetChild(0)->pcGetChild(1)->setValue(12);
    c_root.pcGetChild(1)->addNewChild();
    c_root.pcGetChild(1)->addNewChild();
    c_root.pcGetChild(1)->pcGetChild(0)->setValue(21);
    c_root.pcGetChild(1)->pcGetChild(1)->setValue(22);
    c_root.printAllBelow();
}



int main(){
    //staticNodeTest();
    // staticTreeTest();
    dynamicNodeTest();
	return 0;
}