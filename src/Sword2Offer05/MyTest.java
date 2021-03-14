package Sword2Offer05;
//请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
//示例 1：输入：s = "We are happy."输出："We%20are%20happy."
public class MyTest {
    public static void main(String[] args) {
        String a = new String("We are happy");
        System.out.println(replaceSpace(a));
    }


    public static String replaceSpace(String s) {
        StringBuffer sb = new StringBuffer(s);
        while (sb.indexOf(" ")!=-1){
            sb = sb.replace(sb.indexOf(" "),sb.indexOf(" ")+1,"%20");
        }
        return sb.toString();
    }
}
