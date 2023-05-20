import random

def randomTabMaker(size, upperLimit):
    listOfRandomNumbers = []
    for i in range(0, size):
        listOfRandomNumbers.append(random.randint(0, upperLimit))
    return listOfRandomNumbers


def insertSort(listToSort):
    for i in range(1, len(listToSort)):
        j = i
        while j > 0 and listToSort[j-1] < listToSort[j]:
            temp = listToSort[j-1]
            listToSort[j-1] = listToSort[j]
            listToSort[j] = temp
            j = j - 1
    return listToSort

if __name__ == '__main__':
    randomListToSort = randomTabMaker(15, 1000)
    print(f'\nList before sorting: {randomListToSort}\n')
    print(f'Size of list: {len(randomListToSort)}\n')
    print(f'List after descending insert sort: {insertSort(randomListToSort)}\n')
