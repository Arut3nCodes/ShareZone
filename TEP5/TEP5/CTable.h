#pragma once
class CTable
{
private:
	std::string s_name;
	int size;
	int* array;
	bool copied;
public:
	CTable();
	CTable(std::string sName, int iTableLen);
	CTable(CTable& pcOther);
	CTable(CTable&& cOther);
	~CTable();
	void initArray();
	void setName(std::string sName);
	bool setNewSize(int iTableLen);
	void setValueAt(int iOffset, int iNewVal);
	void printOutAllInformation();
	void printArray();
	CTable* pcClone();
	CTable* share();

	//operatory
	CTable operator=(const CTable& pcNewVal);
	CTable& operator=(CTable&& pcNewVal);
	CTable operator+(const CTable& toMergeTab);
};