package cn.fq.stackDemo_1;

import java.util.Stack;

/**
 * 题目：设计一个有getMin功能的栈
 *
 * 在设计时，使用两个栈，一个用来保存当前栈中的元素(StackDate)
 * 另一个用来保存每一步的最小指(StackMin)
 */
public class Stack_2 {

    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public Stack_2(){
        this.stackData = new Stack<Integer>();
        this.stackMin = new Stack<Integer>();
    }

    public void push(int newNum){
        //1 压入数据规则，先将其压入stackData。然后判断stackMin是否为空
        if(this.stackMin.isEmpty()){
            //1.1 如果为空，则newNum也压入stackMin；如果不为空，则比较newNum和stackMin的栈顶元素中哪一个更小
            this.stackMin.push(newNum);
        }else if(newNum < this.getMin()){
            this.stackMin.push(newNum);
        }else {
            //1.2 如果newNum更小或者两者相等，则newNum也压入stackMin；
            // 如果stackMin的栈顶元素小,则吧stackMin的栈顶元素重复压入stackMin，即在栈顶元素上在压入一个栈顶元素
            Integer newMin = this.stackMin.peek();
            this.stackMin.push(newMin);
        }
        this.stackData.push(newNum);
    }



    //2 因为两个栈都存储了相同的数据，所以弹出的数据是对应的。
    public int pop(){
        if(this.stackData.isEmpty()){
            throw new RuntimeException("Your Stack is Empty");
        }
        this.stackMin.pop();
        return this.stackData.pop();
    }


    //5 查询当前栈中的最小值操作，
    /* 由压入的规则和弹出的规则克制，stackMin始终记录着stackData的最小值
       StackMin的栈顶元素始终是stackData中的最小值
     */
    public int getMin(){
        if(this.stackMin.isEmpty()){
            throw new RuntimeException("Your Stack is Empty");

        }
        return this.stackMin.peek();
    }

    public static void main(String[] args) {
        Stack_2 stack_2 = new Stack_2();
        stack_2.push(3);
        stack_2.push(4);
        stack_2.push(5);
        stack_2.push(2);
        stack_2.push(1);
        stack_2.push(2);
        stack_2.stackMin.pop();
    }

}
