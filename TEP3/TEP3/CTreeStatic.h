#pragma once

class CTreeStatic
{
public:
    CTreeStatic();
    ~CTreeStatic();
    CNodeStatic* pcGetRoot();
    void printTree();
private:
    CNodeStatic c_root;
};
