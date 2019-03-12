package lanqiaoPractice.sort;
import java.util.Arrays;
import java.util.Scanner;

public class POJ1002 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = Integer.parseInt(in.nextLine());
        String[] arr = new String[N];
        for(int i = 0; i < N; i++){
            char[] c = in.nextLine().toCharArray();
            char[] formatted = new char[7];
            int j = 0;
            for(char item : c){
                if(item >= '0' && item <= '9'){
                    formatted[j++] = item;
                }else if(item != '-'){
                    switch (item){
                        case 'A':
                        case 'B':
                        case 'C':
                            formatted[j++] = '2';
                            break;
                        case 'D':
                        case 'E':
                        case 'F':
                            formatted[j++] = '3';
                            break;
                        case 'G':
                        case 'H':
                        case 'I':
                            formatted[j++] = '4';
                            break;
                        case 'J':
                        case 'K':
                        case 'L':
                            formatted[j++] = '5';
                            break;
                        case 'M':
                        case 'N':
                        case 'O':
                            formatted[j++] = '6';
                            break;
                        case 'P':
                        case 'R':
                        case 'S':
                            formatted[j++] = '7';
                            break;
                        case 'T':
                        case 'U':
                        case 'V':
                            formatted[j++] = '8';
                            break;
                        case 'W':
                        case 'X':
                        case 'Y':
                            formatted[j++] = '9';
                            break;
                        default:
                            break;
                    }
                }
            }
            arr[i] = new String(formatted);
        }
        Arrays.sort(arr);
        boolean flag = false;
        String current = arr[0];
        int count = 1;
        for(int i = 1; i < N; i++){
            if(arr[i].equals(current)){
                count++;
            }else{
                if(count > 1){
                    System.out.printf("%s-%s %d\n",current.substring(0, 3), current.substring(3, 7), count);
                    flag = true;
                }
                count = 1;
                current = arr[i];
            }
        }
        if(count > 1){
            System.out.printf("%s-%s %d\n",current.substring(0, 3), current.substring(3, 7), count);
        }
        if(!flag)System.out.print("No duplicates.");
    }
}
