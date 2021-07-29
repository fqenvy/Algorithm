package cn.fq.stackDemo_1;

import java.util.Stack;

/**
 * 题目：设计一个有getMin功能的栈
 *
 * 在设计时，使用两个栈，一个用来保存当前栈中的元素(StackDate)
 * 另一个用来保存每一步的最小指(StackMin)
 */
public class Stack_1 {

    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public Stack_1(){
        this.stackData = new Stack<Integer>();
        this.stackMin = new Stack<Integer>();
    }

    //1 加入输入的值为newNum，先将其压入StackData，
    public void push(int newNum){
        //2 判断stackMin是否为空
        if(this.stackMin.isEmpty()){
            //2.1 如果为空，则将newNum也压入StackMin
            this.stackMin.push(newNum);
            //2.2 如果不为空，则比较newNum和stackMin的栈顶元素中哪一个最小
        }else if(newNum <= this.getMin()){
            //2.3 如果newNum更小或者两者相等，则newNum也压入stackMin；
            this.stackMin.push(newNum);
        }
        //2.4 如果stackMin中栈顶元素小，则stackMin不压入任何类容；
        this.stackData.push(newNum);
    }

    public int pop(){
        if(this.stackData.isEmpty()){
            throw new RuntimeException("Your Stack is Empty");
        }
        //3 弹出数据规则，先在stackData中弹出元素，计作pop。
        Integer pop = this.stackData.pop();
        //3.1 然后比较当前stackMin的栈顶元素和value哪一个更小。
        if(pop == this.getMin()){
            this.stackMin.pop();
        }
        /*4 通过压入规则克制，stackMin中存在的元素是从栈底到栈顶逐渐变小的，
         * stackMin栈顶的元素既是stackMin栈的最小值，也是当前stackData的最小值，
         * 所以不会出现value比StackMin的栈顶元素更小的情况
         */
        return pop;
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
        Stack_1 stack_1 = new Stack_1();
        stack_1.push(3);
        stack_1.push(4);
        stack_1.push(5);
        stack_1.push(2);
        stack_1.push(1);
        stack_1.push(2);
        stack_1.stackMin.pop();
    }

}
