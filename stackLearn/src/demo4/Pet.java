package demo4;

/**
 * 题目：猫狗队列
 * 提供方法：
 * add方法将cat或者dog放入队列
 * pullAll：先后顺序排序弹出
 * pullDog：先后顺序排序弹出
 * pullCat：先后顺序排序弹出
 * isEmpty：判断队列是否还有cat or dog
 * isDogEmpty：判断队列是否还有Dog
 * isCatEmpty：同上Cat
 */
public class Pet {

    private String type;

    public Pet(String type) {
        this.type = type;
    }

    public String getPetType(){
        return this.type;
    }


}
