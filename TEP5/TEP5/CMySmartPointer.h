#pragma once

class CRefCounter
{
public:
    CRefCounter() { i_count = 0; }
    int iAdd() { return(++i_count); }
    int iDec() { return(--i_count); }
    int iGet() { return(i_count); }
private:
    int i_count;
};//class CRefCounter

template < typename T > class CMySmartPointer
{
private:
    CRefCounter* pc_counter;
    T* pc_pointer;
public:
    CMySmartPointer(T* pcPointer)
    {
        pc_pointer = pcPointer;
        pc_counter = new CRefCounter();
        pc_counter->iAdd();
    }//CMySmartPointer(CSellData *pcPointer)
    CMySmartPointer(const CMySmartPointer& pcOther)
    {
        pc_pointer = pcOther.pc_pointer;
        pc_counter = pcOther.pc_counter;
        pc_counter->iAdd();
    }//CMySmartPointer(const CMySmartPointer &pcOther)
    ~CMySmartPointer()
    {
        if (pc_counter->iDec() == 0)
        {
            delete pc_pointer;
            delete pc_counter;
        }//if (pc_counter->iDec())
    }//~CMySmartPointer()
    T& operator*() { return(*pc_pointer); }
    T* operator->() { return(pc_pointer); }
    T& operator=(const CMySmartPointer& pcOther) { 
        if (this != &pcOther) {
            if (pc_counter->iDec() == 0) {
                delete pc_pointer;
                delete pc_counter;
                }
            pc_pointer = pcOther.pc_pointer;
            pc_counter = pc_counter;
            pc_counter->iAdd();
            return (*this);
        }
    }

};//class CMySmartPointer


