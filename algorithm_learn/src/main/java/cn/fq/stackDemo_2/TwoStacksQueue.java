package cn.fq.stackDemo_2;

import java.util.Stack;

/**
 * 题目：编写一个类，用两个栈实现队列，支持队列的基本操作(add,poll,peek)
 *
 * 栈的特点是FILO，而队列的特点是FIFO。我们用两个栈正好能把顺序反过来实现累死队列的操作。
 * 具体实现时是一个栈作为压入栈，在压入数据时z只往这个栈压入，计作stackPush；另一个只作为弹出栈stackPop
 *
 * 听上去简单，实际上要做到两点。
 * 1 如果stackPush要往stackPop中压入数据，那么必须一次性把stackPush中的数据全部压入
 * 2 如果stackPop不为空，stackPush绝对不能向stackPop中压入数据。
 * 如果不做到这两点，就会出现乱序的情况
 */

public class TwoStacksQueue {

    public Stack<Integer> stackPush;
    public Stack<Integer> stackPop;

    public TwoStacksQueue(){
        this.stackPop = new Stack<Integer>();
        this.stackPush = new Stack<Integer>();
    }

    //push栈向pop栈导入数据
    private void pushToPop(){
        if(stackPop.empty()){
            while (!stackPush.empty()){
                stackPop.push(stackPush.pop());
            }
        }
    }

    public void add(int pushInt){
        stackPush.push(pushInt);
        pushToPop();;
    }

    public int poll(){
        if(stackPop.empty() && stackPush.empty()){
            throw new RuntimeException("Queue is empty");
        }
        pushToPop();
        return stackPop.pop();
    }

    public int peek(){
        if(stackPop.empty() && stackPush.empty()){
            throw new RuntimeException("Queue is empty");
        }
        pushToPop();;
        return stackPop.peek();
    }



}
