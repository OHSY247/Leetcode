"""
    输入： 第1行为n代表用户的个数 第2行为n个整数，第i个代表用户标号为i的用户对某类文章的喜好度 第3行为一个正整数q代表查询的组数  第4行到第（3+q）行，每行包含3个整数l,r,k代表一组查询，即标号为l<=i<=r的用户中对这类文章喜好值为k的用户的个数。 数据范围n <= 300000,q<=300000 k是整型

    输出描述:
    输出：一共q行，每行一个整数代表喜好值为k的用户的个数

    输入例子1:
5
1 2 3 3 5
3
1 2 1
2 4 5
3 5 3   

    输出例子1:
1
0
2

    例子说明1:
    样例解释:
    有5个用户，喜好值为分别为1、2、3、3、5，
    第一组询问对于标号[1,2]的用户喜好值为1的用户的个数是1
    第二组询问对于标号[2,4]的用户喜好值为5的用户的个数是0
    第三组询问对于标号[3,5]的用户喜好值为3的用户的个数是2
"""
# Python版
num = int(input())
fav_list = list(map(int,input().split()))
_num = int(input())
_list = [list(map(int,input().split())) for _ in range(_num)]

for _ in _list:
    print(fav_list[_[0]-1:_[1]].count(_[-1]))

