package demo4;

/**
 * 本本题实现将不通的实例盖上时间戳的方法，但是又不能改变用户本身的类，所以定义一个新的类
 * 具体的实现参看类.
 */
public class PetEnterQueue {

    private Pet pet;
    private long count;

    public PetEnterQueue(Pet pet, long count) {
        this.pet = pet;
        this.count = count;
    }

    public Pet getPet() {
        return pet;
    }


    public long getCount() {
        return count;
    }

    public String getEnterPetType(){
        return this.pet.getPetType();
    }
}
