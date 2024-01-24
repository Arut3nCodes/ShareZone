#include <iostream>
#include "CTab.h"

CTab::CTab(const CTab& cOther)
{
    v_copy(cOther);
    std::cout << "Copy ";
}//CTab::CTab(const CTab &cOther)


CTab::~CTab()
{
    if (pi_tab != NULL) delete[] pi_tab;
    std::cout << "Destr ";
}//CTab::~CTab()

bool CTab::bSetSize(int iNewSize) {
    int* newTab = new int[iNewSize];
    //for (int i = 0; i < i_size; i++)
    //  newTab[i] = pi_tab[i];
    delete[] pi_tab;
    i_size = iNewSize;
    pi_tab = newTab;
    return true;
}

CTab CTab::operator=(const CTab& cOther)
{
    if (pi_tab != NULL) delete pi_tab;
    v_copy(cOther);
    std::cout << "op= ";
    return(*this);
}//CTab CTab::operator=(const CTab &cOther)

CTab& CTab::operator=(CTab&& cOther) {

    if(this != &cOther){
      if(pi_tab != NULL) delete[] pi_tab;
        pi_tab = cOther.pi_tab;
        i_size = cOther.i_size;
        cOther.pi_tab = nullptr;
        std::cout << "op= ";
        return(*this);
    }
}
void CTab::v_copy(const CTab& cOther)
{
    pi_tab = new int[cOther.i_size];
    i_size = cOther.i_size;
    for (int ii = 0; ii < cOther.i_size; ii++)
        pi_tab[ii] = cOther.pi_tab[ii];
}//void CTab::v_copy(CTab &cOther)

CTab::CTab(CTab&& cOther)
{
    pi_tab = cOther.pi_tab;
    i_size = cOther.i_size;
    cOther.pi_tab = NULL;
    std::cout << "MOVE ";
}//CTab::CTab(CTab &&cOther)



