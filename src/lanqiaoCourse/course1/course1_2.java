package lanqiaoCourse.course1;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
/*

古罗马帝国开创了辉煌的人类文明，但他们的数字表示法的确有些繁琐，尤其在表示大数的时候，现在看起来简直不能忍受，所以在现代很少使用了。
之所以这样，不是因为发明表示法的人的智力的问题，而是因为一个宗教的原因，当时的宗教禁止在数字中出现0的概念！
罗马数字的表示主要依赖以下几个基本符号：

I --> 1
V --> 5
X --> 10
L --> 50
C --> 100
D --> 500
M --> 1000

这里，我们只介绍一下1000以内的数字的表示法。
单个符号重复多少次，就表示多少倍。最多重复3次。
比如：CCC表示300  XX表示20，但150并不用LLL表示，这个规则仅适用于I X C M。

如果相邻级别的大单位在右，小单位在左，表示大单位中扣除小单位。
比如：IX表示9  IV表示4  XL表示40
49 = XLIX

更多的示例参见下表，你找到规律了吗？
I = 1
II = 2
III = 3
IV = 4
V = 5
VI = 6
VII = 7
VIII = 8
IX = 9
X = 10
XI = 11
XII = 12
XIII = 13
XIV = 14
XV = 15
XVI = 16
XVII = 17
XVIII = 18
XIX = 19
XX = 20
XXI = 21
XXII = 22
XXIX = 29
XXX = 30
XXXIV = 34
XXXV = 35
XXXIX = 39
XL = 40
L = 50
LI = 51
LV = 55
LX = 60
LXV = 65
LXXX = 80
XC = 90
XCIII = 93
XCV = 95
XCVIII = 98
XCIX = 99
C = 100
CC = 200
CCC = 300
CD = 400
D = 500
DC = 600
DCC = 700
DCCC = 800
CM = 900
CMXCIX = 999

本题目的要求是：请编写程序，由用户输入若干个罗马数字串，程序输出对应的十进制表示。

输入格式是：第一行是整数n,表示接下来有n个罗马数字(n<100)。
以后每行一个罗马数字。罗马数字大小不超过999。
要求程序输出n行，就是罗马数字对应的十进制数据。

例如，用户输入：
3
LXXX
XCIII
DCCII


49
I
II
III
IV
V
VI
VII
VIII
IX
X
XI
XII
XIII
XIV
XV
XVI
XVII
XVIII
XIX
XX
XXI
XXII
XXIX
XXX
XXXIV
XXXV
XXXIX
XL
L
LI
LV
LX
LXV
LXXX
XC
XCIII
XCV
XCVIII
XCIX
C
CC
CCC
CD
D
DC
DCC
DCCC
CM
CMXCIX
 */
public class course1_2 {
    static Map<Character, Integer> unitVal = new HashMap<>();
    static Map<String, Integer> deltaItems = new HashMap<>();
    public static void main(String[] args) throws IOException{
        char[] units = new char[]{'I', 'V', 'X', 'L', 'C', 'D', 'M'};
        int[] vals = new int[]{1, 5, 10, 50, 100, 500, 1000};
        for(int i = 0; i < units.length; i++){
            unitVal.put(units[i], vals[i]);
            for(int j = 0; j < i; j++){
                deltaItems.put(new String(new char[]{units[j], units[i]}), vals[j] * -2);
            }
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out), 1 << 16);
        int T = Integer.parseInt(reader.readLine());
        while (T-- > 0){
            writer.write(convert(reader.readLine()) + "\n");
        }
        writer.flush();
    }
    private static int convert(String s){
        int r = 0;
        for(String t : deltaItems.keySet()){
            if(s.contains(t)){
                r += deltaItems.get(t);
            }
        }
        for(char c : s.toCharArray()){
            r += unitVal.get(c);
        }
        return r;
    }
}
