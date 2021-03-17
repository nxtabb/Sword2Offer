package Others;

import java.util.Arrays;
import java.util.Scanner;
public class MyTest {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String babyStr = scanner.nextLine();
        String candyStr = scanner.nextLine();
        String[] babyStrArr = babyStr.split(" ");
        int[] baby = new int[babyStrArr.length];
        for(int i=0;i<baby.length;i++){
            baby[i] = Integer.parseInt(babyStrArr[i]);
        }
        String[] candyStrArr = candyStr.split(" ");
        int[] candy = new int[candyStrArr.length];
        for(int i=0;i<candy.length;i++){
            candy[i] = Integer.parseInt(candyStrArr[i]);
        }
        shellSort(baby);
        shellSort(candy);
        System.out.println(Arrays.toString(baby));
        System.out.println(Arrays.toString(candy));
        int num = 0;
        boolean flag = false;
        for(int i=0;i<baby.length;i++){
            for(int j =0;j<candy.length;j++){
                flag = false;
                if(candy[j]>=baby[i]){
                    flag = true;
                    candy[j] = 0;
                    num++;
                    break;
                }
            }
            if(flag==true){
                continue;
            }
        }
        System.out.println(num);
    }

    public static int[] shellSort(int[] arr){
        int n = arr.length/2;
        while(n>=1){
            for(int i =n;i<arr.length;i+=n){
                for(int j=i;j>0;j-=n){
                    if(arr[j]<arr[j-n]){
                        arr[j] = arr[j]^arr[j-n];
                        arr[j-n] = arr[j]^arr[j-n];
                        arr[j] = arr[j]^arr[j-n];
                    }
                }
            }
            n = n/2;
        }
        return arr;
    }




}
