package demo3;

import java.util.Stack;

/**
 * 题目：一个栈依次压入数字，然后逆序
 * 使用两个递归函数完成
 */
public class ReverseStack {

    //将stack的栈低元素返回并移除

    public static int getAndRemoveLastElement(Stack<Integer> stack){
        //记录每依次弹出的元素
        int res = stack.pop();
        if(stack.empty()){
            return res;
        } else {
            //通过递归获得最后一个元素
            int lastElement = getAndRemoveLastElement(stack);
            stack.push(res);//用于还原之前的栈
            return lastElement;
        }
    }

    //逆序一个栈

    public static void reverse(Stack<Integer> stack){

        if(stack.empty()){
            return;
        }

        int i = getAndRemoveLastElement(stack);
        reverse(stack);
        stack.push(i);
    }

    public static void main(String[] args) {
        ReverseStack s = new ReverseStack();
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack);
        s.reverse(stack);
        System.out.println(stack);
    }


}
