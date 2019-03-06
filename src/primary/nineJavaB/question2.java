package primary.nineJavaB;

public class question2 {
    // 法一 暴力法
    // 以圆心为原点建立平面直角坐标系，只需要考虑第一象限的四分之一圆内有几个完整正方格再乘以4就可以得到答案
    // 对每个正方格去它的右上角的点，考虑到原点的距离是否大于圆的半径，如果大于，则该正方格不完全在圆的内部。
    private static void method1(int radius){
        // 预先算好圆的半径的平方，下面要用到，防止重复计算
        int radiusPow2 = radius * radius;
        int count = 0;
        for(int i = 1; i <= radius; i++){
            for(int j = 1; j <= radius; j++){
                // 这里把正方形右上角到原点的距离小于圆的半径转化为
                // 距离的平方小于半径的平方
                // 一个好处是能减少计算量
                // 第二个好处是更精确（开方计算会有误差）
                if(i * i + j * j <= radiusPow2){
                    count++;
                }
            }
        }
        System.out.println(count * 4);
    }
    private static int radiusPow2;
    private static boolean containPoint(int x, int y){
        return (x * x + y * y) <= radiusPow2;
    }

    // 法二
    // 从(radius - 1, 0)这一点开始搜索边界， 然后计算边界内点的个数。
    private static void method2(int radius){
        int total = 0;
        int x = 0, y = radius;
        radiusPow2 = radius * radius;
        while (true){
            if(containPoint(x + 1, y)){
                total += y;
                x++;
            }else{
                y--;
            }
            if(y == 0) break;
        }
        System.out.println(total * 4);
    }
    public static void main(String[] args){
        // 测试一下方法1
        method1(3);

        // 运行
        method1(1000);
        method2(1000);
    }
}
