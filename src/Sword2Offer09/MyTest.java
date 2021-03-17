package Sword2Offer09;

/**
 * @Classname Sword2Offer14_I.MyTest
 * @Description TODO
 * @Date 2021/3/12 17:32
 * @Created by nxt
 */
public class MyTest {
    public static void main(String[] args) {
        CQueue cQueue = new CQueue();
        cQueue.appendTail(11);
        System.out.println(cQueue.deleteHead());
        cQueue.appendTail(1);
        cQueue.appendTail(17);
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());
        cQueue.appendTail(19);
        cQueue.appendTail(20);
        cQueue.appendTail(13);
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());
        cQueue.appendTail(12);
        cQueue.appendTail(3);
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());
        cQueue.appendTail(10);
        cQueue.appendTail(19);
        System.out.println(cQueue.deleteHead());

    }
}
