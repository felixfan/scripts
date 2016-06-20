def isIn(char, aStr):
    '''
    char: a single character
    aStr: an alphabetized string
    
    returns: True if char is in aStr; False otherwise
    '''
    # Your code here
    start = 0
    end = len(aStr)
    m = (start + end) // 2
    if aStr == '':
        return False
    elif char == aStr[m]:
        return True
    elif char > aStr[m]:
        start = m + 1
        return isIn(char, aStr[start:])
    elif char < aStr[m]:
        end = m
        return isIn(char, aStr[start:end])
