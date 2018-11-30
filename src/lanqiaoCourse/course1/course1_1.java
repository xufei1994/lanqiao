package lanqiaoCourse.course1;

import java.util.Arrays;

/**
基本思路：首先考虑 年龄的立方是四位数，年龄的四次方是六位数这个条件，把不符合条件的过滤掉。接着把他们转换成字符串拼接起来，对这个字符串重新进行排列（字符串->字符数组->排列字符数组->转化回字符串），然后和字符串"0123456789"进行比较。
 */
public class course1_1 {
    public static void main(String[] args){
        for(int age = 1; age < 150; age++){
            int pow3 = age * age * age;
            // 年龄的立方不是4位数，执行下一轮循环
            if(pow3 < (int)1e3 || pow3 >= (int)1e4) continue;
            int pow4 = pow3 * age;
            // 年龄的四次方不是6位数，执行下一轮循环
            if(pow4 < (int)1e5 || pow4 >= (int)1e6) continue;
            // 把这个两个数字拼接成字符串，再转化成字符数组
            char[] c = ("" + pow3 + pow4).toCharArray();
            // 对这个字符数组进行排序
            Arrays.sort(c);
            // 将排序好的字符数组再转化成字符串，如果正好和0123456789相等，则输出对应年龄
            if(new String(c).equals("0123456789")){
                System.out.println(age);
                break;
            }
        }
    }
}
