package chapter_1_stackandqueue;

import java.util.LinkedList;
import java.util.Queue;

public class Problem_04_DogCatQueue {
    public static class Pet {
        private String type;
        public Pet(String type)
        {
            this.type = type;
        }
        public String getPetType()
        {
            return this.type;
        }
    }
    public static class Dog extends Pet{
        public Dog()
        {
            super("dog");
        }
    }
    public static class Cat extends Pet{
        public Cat()
        {
            super("cat");
        }
    }
    public static class PetEnterQueue {
        private long cnt;
        private Pet pet;
        public PetEnterQueue(Pet pet, long cnt)
        {
            this.pet = pet;
            this.cnt = cnt;
        }
        public long getCnt()
        {
            return cnt;
        }
        public Pet getPet()
        {
            return pet;
        }
    }
    public static class DogCatQueue
    {
        private Queue<PetEnterQueue> dogQueue;
        private Queue<PetEnterQueue> catQueue;
        private long cnt;
        public DogCatQueue()
        {
            dogQueue = new LinkedList<PetEnterQueue>();
            catQueue = new LinkedList<PetEnterQueue>();
            cnt = 0;
        }
        public void add(Pet pet)
        {
            if(pet.getPetType().equals("dog"))
            {
                dogQueue.add(new PetEnterQueue(pet, cnt++));
            }
            else if (pet.getPetType().equals("cat"))
            {
                catQueue.add(new PetEnterQueue(pet, cnt++));
            }
            else
            {
                throw new RuntimeException("err: not dog or cat");
            }
        }
        public Pet pollAll()
        {
            if(!catQueue.isEmpty() && !dogQueue.isEmpty())
            {
                if(dogQueue.peek().getCnt() < catQueue.peek().getCnt())
                {
                    return dogQueue.poll().getPet();
                }
                else
                {
                    return catQueue.poll().getPet();
                }
            }
            else if(!catQueue.isEmpty())
            {
                return catQueue.poll().getPet();
            }
            else if(!dogQueue.isEmpty())
            {
                return dogQueue.poll().getPet();
            }
            else
            {
                throw new RuntimeException("all queue is empty");
            }
        }
        public Dog pollDog()
        {
            if(!dogQueue.isEmpty())
            {
                return (Dog) dogQueue.poll().getPet();
            }
            else
            {
                throw new RuntimeException("dog queue is empty");
            }
        }
        public Cat pollCat()
        {
            if(!catQueue.isEmpty())
            {
                return (Cat) catQueue.poll().getPet();
            }
            else
            {
                throw new RuntimeException("cat queue is empty");
            }
        }
        public boolean isEmpty()
        {
            if(dogQueue.isEmpty() && catQueue.isEmpty())
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        public boolean isDogEmpty()
        {
            if(dogQueue.isEmpty())
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        public boolean isCatEmpty()
        {
            if(catQueue.isEmpty())
            {
                return true;
            }
            else
            {
                return false;
            }
        }
    }
    public static void main(String[] args)
    {
        DogCatQueue dogCatq = new DogCatQueue();
        Cat c1 = new Cat();
        Cat c2 = new Cat();
        Dog d1 = new Dog();
        Dog d2 = new Dog();
        dogCatq.add(c1);
        dogCatq.add(d2);
        dogCatq.add(d1);
        dogCatq.add(c2);
        while (!dogCatq.isCatEmpty())
        {
            System.out.println(dogCatq.pollCat().getPetType());
        }
        while (!dogCatq.isEmpty())
        {
            System.out.println(dogCatq.pollAll().getPetType());
        }
    }
}
