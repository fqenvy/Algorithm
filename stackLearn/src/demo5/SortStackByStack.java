package demo5;

import java.nio.file.Paths;
import java.util.Stack;

/**
 * 题目：一个栈中类型为int，顶到低从大到小进行排序，只允许申请一个栈
 * 解法：将排序的栈记做stack，申请的为help，在stack上执行pop，定义为cur
 */
public class SortStackByStack {

    public static void solute(Stack<Integer> stack){
        Stack<Integer> help = new Stack<>();

        while(!stack.isEmpty()){
            Integer cur = stack.pop();
            //如果help中的顶上元素大于cur，那么就讲help的顶上元素弹出，并存入stack中,cur就放入help中，交换位置
            while(!help.isEmpty() && help.peek() < cur){
                Integer pop = help.pop();
                stack.push(pop);
            }
            help.push(cur);
        }
        while (!help.isEmpty()){
            stack.push(help.pop());
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(3);
        stack.push(2);

        solute(stack);

        System.out.println(stack);

    }
}
