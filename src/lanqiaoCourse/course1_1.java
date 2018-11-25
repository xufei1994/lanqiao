package lanqiaoCourse;

import java.util.Arrays;

/**
 美国数学家维纳(N.Wiener)智力早熟，11岁就上了大学。
 他曾在1935~1936年应邀来中国清华大学讲学。
 一次，他参加某个重要会议，年轻的脸孔引人注目。
 于是有人询问他的年龄，他回答说：
 “我年龄的立方是个4位数。我年龄的4次方是个6位数。这10个数字正好包含了从0到9这10个数字，每个都恰好出现1次。”
 请你推算一下，他当时到底有多年轻。
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
