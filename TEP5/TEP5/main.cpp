#include <iostream>
#include "CMySmartPointer.h"
#include "CTab.h"
#include "CTable.h"

CTab cCreateTab()
{
	CTab c_result;
	c_result.bSetSize(5);
	return(c_result);
}//CTab cCreateTab()

int i_ms_test()
{
	CTab c_tab = cCreateTab();
	/*DO STH WITH c_tab*/
	return 1;
}//int i_ms_test() 

CTab cCreateTabIntelligent()
{
	CTab c_result;
	c_result.bSetSize(5);
	return(std::move(c_result));
}//CTab cCreateTab()

void test4() {
	CTab c_tab;
	CTab c_other;
	c_tab.bSetSize(5);
	c_other.bSetSize(7);
	c_tab = std::move(c_other);
	std::cout << (c_tab.iGetSize()) << std::endl;
}

void test5() {
	CTable cTab0, cTab1, cTab00;
	cTab0.setNewSize(6);
	cTab1.setNewSize(4);
	cTab0.initArray();
	cTab1.initArray();
	std::cout << "Operator przypisania" << std::endl;
	cTab0 = cTab1; 
	std::cout << "Operator przypisania i move" << std::endl;
	cTab00 = std::move(cTab0);
	cTab1.setValueAt(2, 123);
	cTab0.printOutAllInformation();
	cTab1.printOutAllInformation();
	cTab0.printArray();
	cTab1.printArray();
	std::cout << "Operator przypisania sumy klas" << std::endl;
	CTable cTab2;
	cTab2 = cTab0 + cTab1;
	cTab2.printOutAllInformation();
	cTab2.printArray();
	std::cout << "Z semantyka move" << std::endl;
	CTable cTab3;
	cTab3 = std::move(cTab0 + cTab1);
	cTab3.printOutAllInformation();
	
}

int main() {
	std::cout << "Podejscie 1: " << std::endl;
	cCreateTab();
	std::cout << std::endl << "Podejscie 2:" << std::endl;
	cCreateTabIntelligent();
	std::cout << std::endl << "Zadanie 4: " << std::endl;
	test4();
	std::cout << std::endl << "Zadanie 5: " << std::endl;
	test5();
	return 0;
}