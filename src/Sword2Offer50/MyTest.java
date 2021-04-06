package Sword2Offer50;

import java.util.*;

//在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
//示例:s = "abaccdeff" 返回 "b"
//s = "",返回 " "
public class MyTest {
    public static void main(String[] args) {
        String a = "abaccdeff";
        char c = firstUniqChar(a);
        System.out.println(c);
    }

    public static char firstUniqChar(String s) {
        if(s.equals("")){
            return " ".toCharArray()[0];
        }else {
            Map<Character,Integer> map = new HashMap<>();
            for(int i=0;i<s.length();i++){
                char input = s.charAt(i);
                if(map.get(input)==null){
                    map.put(input,1);
                }else {
                    map.put(input,map.get(input)+1);
                }
            }
            for(int i=0;i<s.length();i++){
                if(map.get(s.charAt(i))==1){
                    return s.charAt(i);
                }
            }
            return " ".toCharArray()[0];
        }
    }
}
