package demo4;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 构造这个类时，pet是用户原有的实例。
 * 大体来说，需要一个不断累加的数据项，用来表示实例进队列的时间；
 * 同时有两个队列，一个只用来放dog类实例的队列dogQ；另一个是只放cat类实例的队列catQ
 * 加入实例的时候，如果加入的实例是dog，就盖上时间戳，生成对应的PetEnterQueue类的实例，然后放入dogQ
 * 弹出实例时，从dogQ不断弹出就可以 pollDog
 * pollAll就比较队列两头的时间戳
 */
public class DogCatQueue {

    private Queue<PetEnterQueue> dogQ;
    private Queue<PetEnterQueue> catQ;
    private long count;

    public DogCatQueue() {
        dogQ = new LinkedList<>();
        catQ = new LinkedList<>();
        this.count = 0;
    }

    public void add(Pet pet){
        if(pet.getPetType().equals("dog")){
            this.dogQ.add(new PetEnterQueue(pet,this.count++));
        }else if(pet.getPetType().equals("cat")){
            this.catQ.add(new PetEnterQueue(pet,this.count++));
        }else {
            throw new RuntimeException("error");
        }
    }

    public Pet pullAll(){
        if(!this.dogQ.isEmpty() && !this.catQ.isEmpty()){
            if(this.dogQ.peek().getCount() < this.catQ.peek().getCount()){
                {
                    return this.dogQ.poll().getPet();
                }
            }else return this.catQ.poll().getPet();
        }else if(!this.dogQ.isEmpty()){
            return this.dogQ.poll().getPet();
        }else if(!this.catQ.isEmpty()){
            return this.catQ.poll().getPet();
        }else {
            throw new RuntimeException("error");
        }
    }

    public Cat pullCat(){
        if(!this.isCatQueueEmpty()){
            return (Cat) this.catQ.poll().getPet();
        }else {
            throw new RuntimeException("error");
        }
    }

    public Dog pullDog(){
        if(!this.isCatQueueEmpty()){
            return (Dog) this.catQ.poll().getPet();
        }else {
            throw new RuntimeException("error");
        }
    }

    public boolean isEmpty(){
        return this.catQ.isEmpty() && this.dogQ.isEmpty();
    }

    public boolean isDogQueueEmpty(){
        return this.dogQ.isEmpty();
    }
    public boolean isCatQueueEmpty(){
        return this.catQ.isEmpty();
    }
}
