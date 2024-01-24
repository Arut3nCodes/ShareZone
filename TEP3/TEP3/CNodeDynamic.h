#pragma once
class CNodeDynamic
{
private:
    std::vector<CNodeDynamic*> children;
    CNodeDynamic* pcParentNode;
    int val;
public:
    CNodeDynamic();
    ~CNodeDynamic();
    void setValue(int newVal);
    int getChildrenNumber();
    void addNewChild();
    CNodeDynamic* pcGetChild(int childOffset);
    void print();
    void printAllBelow();

};

class CTreeDynamic
{
public:
    CTreeDynamic();
    ~CTreeDynamic();
    CNodeDynamic* pcGetRoot();
    void printTree();
private:
    CNodeDynamic* pcRoot;
};