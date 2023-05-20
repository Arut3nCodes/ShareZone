import string


def caesarCipher(stringToEncode):
    try:
        shiftParameter = int(input('Podaj parametr przesunięcia: '))
        encodedString = ''
        lowercase = string.ascii_lowercase
        uppercase = string.ascii_uppercase
        for letter in stringToEncode:
            if letter in lowercase:
                encodedString += lowercase[(lowercase.index(letter) + shiftParameter) % 26]
            else:
                encodedString += uppercase[(uppercase.index(letter) + shiftParameter) % 26]
                return encodedString

    except ValueError:
        print('Podany ciąg znaków nie był liczbą całkowitą')


def secretWordToAlphabeticalOrderList(secretWord='SECRET'): #secretWord.
    if(secretWord.isupper() and secretWord.isalpha()):
        orderList = [None] * len(secretWord)
        i = 0
        for letter in string.ascii_uppercase:
            for j in range(0, len(secretWord)):
                if secretWord[j] == letter:
                    orderList[j] = i
                    i+=1
        return orderList

    print('not ok')

    # [4, 1, 0, 3, 2, 5]


def columnCipher(stringToEncode):
    encryptedString = ''
    key = input('Podaj klucz szyfrujący: ')
    key = secretWordToAlphabeticalOrderList(key)
    cipherTable = [''] * len(key)
    i = 0
    for letter in stringToEncode:
        cipherTable[i] += letter
        i = (0 if i == len(key) - 1 else i+1)

    for i in range(0, len(key)):
        encryptedString += cipherTable[key.index(i)]

    return encryptedString


def runCipherScript(stringToEncode):
    if(stringToEncode.isalpha()):
        choice = input("Run: \n\t1 -> Column Cipher\n\t2 -> Caesar's Cipher\nYour choice: ")
        match choice:
            case '1':
                print(caesarCipher(stringToEncode))
            case '2':
                print(columnCipher(stringToEncode))
            case _:
                print('Your choice was incorrect.')
    else:
        print("String to encode isn't correct. StringToEncode must only contain letters")


if __name__ == '__main__':
    # print('Witaj w zaszyfrowaczu słów!', end='\n\n')
    stringToEncode = input('Podaj ciąg znaków do zakodowania (Nie używaj polskich znaków bo je pominie): ')
    print(columnCipher(stringToEncode.upper()))