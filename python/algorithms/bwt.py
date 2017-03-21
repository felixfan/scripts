#encoding=utf-8
import sys

def bwt(string):
    '''
    Burrows-Wheeler transform
    ref: https://zh.wikipedia.org/wiki/Burrows-Wheeler%E5%8F%98%E6%8D%A2
    '''

    ## step 1 生成s所有的循环字符串
    length = len(string)
    stringArray = [string]
    for i in range(1, length):
        tmp = stringArray[i-1][1:]+stringArray[i-1][0]
        stringArray.append(tmp)

    ## step 2 将这些字符串按字典序排序
    sortedStringArray = sorted(stringArray)

    ## step3 返回最后排序后字符串的最后一列
    lastCharacter = [x[-1] for x in sortedStringArray]
    ans = ''.join(lastCharacter)

    ## step 4 获取已排序表每个字符串在未排序表中
    ##        对应字符串的下一个字符串在已排序表中的索引值
    nextValue = []
    for i in sortedStringArray:
        index1 = stringArray.index(i)
        index1 = index1 + 1 if index1 < length - 1 else 0
        index2 = sortedStringArray.index(stringArray[index1])
        nextValue.append(index2)

    return ans, nextValue

def ibwt(string, nextValue):
    ans = ''
    x = nextValue[0]
    for i in string:
        x = nextValue[x]
        ans += string[x]
    return ans


if __name__ == '__main__':
    string = sys.argv[1]
    ans, nv = bwt(string)
    print ans
    for v in nv:
        print v
    org = ibwt(ans, nv)
    print org
