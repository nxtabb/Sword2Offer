package Sword2Offer12;
//请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、
// 下移动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径
// （路径中的字母用加粗标出）。
//[["a","b","c","e"],
//["s","f","c","s"],
//["a","d","e","e"]]
//但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。

//思路：本题需要使用到深度优先搜索和回溯方法
//具体：先编写一个深度优先搜索的方法：即 在当前位置的四周查看是否有要寻找的元素，如果有则进行下一步，如果没有则返回false

public class MyTest {
    public static void main(String[] args) {
        char[][] board = new char[][]{{'a','b','c','e'},{'s','f','c','s'},{'a','d','e','e'}};
        String word = "bfce";
        boolean result = exist(board, word);
        System.out.println(result);
    }



    public static boolean exist(char[][] board, String word) {
        //1、先把word转化为一个char[]
        char[] wordChar = word.toCharArray();
        //2、使用一个双层循环 遍历开始的位置
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                boolean result = dfs(board, i, j, wordChar, 0);
                if(result){
                    return true;
                }
            }
        }
        return false;
        //3、每一个开始的位置，进行深度优先搜索，如果失败返回false，如果成功直接返回true，跳出循环。给出结果
    }

    private static boolean dfs(char[][] board, int i, int j, char[] wordChar, int index) {
        if(i<0||i>=board.length||j<0||j>=board[0].length||wordChar[index]!=board[i][j]){
            return false;
        }
        if(index == wordChar.length-1){
            return true;
        }
        board[i][j]='!';
        boolean result = dfs(board, i-1, j, wordChar, index+1)||
                        dfs(board, i+1, j, wordChar, index+1)||
                        dfs(board, i, j-1, wordChar, index+1)||
                        dfs(board, i, j+1, wordChar, index+1);
        return result;
    }


}
