package ru.pasharik.chapter_3_stacks_queues.question_3_6;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

public class AnimalShelter {
    private AtomicInteger idx = new AtomicInteger(0);
    private LinkedList<AnimalNode> dogList = new LinkedList<>();
    private LinkedList<AnimalNode> catList = new LinkedList<>();

    private class AnimalNode {
        public Animal animal;
        public int id;
        public AnimalNode(Animal animal) {
            this.animal = animal;
            this.id = idx.getAndIncrement();
        }
    }

    private static class Animal {
        public String name;
    }
    private static class Dog extends Animal {}
    private static class Cat extends Animal {}

    public void enqueue(Animal animal) {
        if (animal instanceof Dog)      dogList.add(new AnimalNode(animal));
        else if (animal instanceof Cat) catList.add(new AnimalNode(animal));
    }

    public Animal dequeueAny() {
        if (dogList.isEmpty() && catList.isEmpty()) throw new NullPointerException("Shelter is empty");
        if (dogList.isEmpty()) return catList.removeFirst().animal;
        if (catList.isEmpty()) return dogList.removeFirst().animal;
        Animal result = dogList.getFirst().id < catList.getFirst().id ?
                dogList.removeFirst().animal :
                catList.removeFirst().animal;
        resetIdx();
        return result;
    }

    private void resetIdx() {
        if (dogList.isEmpty() && catList.isEmpty()) idx.set(0);
    }

    public Dog dequeueDog() {
        if (dogList.isEmpty()) throw new NullPointerException("There is no dogs");
        Dog dog = (Dog) dogList.removeFirst().animal;
        resetIdx();
        return dog;
    }

    public Cat dequeueCat() {
        if (catList.isEmpty()) throw new NullPointerException("There is no cats");
        Cat cat = (Cat) catList.removeFirst().animal;
        resetIdx();
        return cat;
    }

    private void doStart() {
        for (int i = 0; i < 5; i++) {
            Dog d = new Dog();
            d.name = "Dog_" + i;
            enqueue(d);

            Cat c = new Cat();
            c.name = "Cat_" + i;
            enqueue(c);
        }
        System.out.println("Oldest animal of all: " + dequeueAny().name);
        System.out.println("Oldest animal of all: " + dequeueAny().name);
        System.out.println("Oldest Cat: " + dequeueCat().name);
        System.out.println("Oldest Dog: " + dequeueDog().name);
    }

    public static void main(String[] args) {
        new AnimalShelter().doStart();
    }
}
