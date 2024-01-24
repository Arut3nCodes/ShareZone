#pragma once

class CNodeStatic
{
private:
    std::vector<CNodeStatic> children;
    CNodeStatic* pcParentNode;
    int val;
public:
    CNodeStatic();
    ~CNodeStatic();
    void setValue(int newValue);
    int getChildrenNumber();
    void addNewChild();
    void setParent(CNodeStatic* pcNode);
    CNodeStatic* pcGetChild(int iChildOffset);
    void print();
    void printAllBelow();
    void printUp();
};

