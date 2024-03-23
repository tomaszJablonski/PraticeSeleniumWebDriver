package com.javaForTesters.collections;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetDemo {
    public static void main(String[] args) {

        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.add(5);
        hashSet.add(10);
        hashSet.add(15);
        hashSet.add(20);
        hashSet.add(25);
        hashSet.add(25);
        hashSet.add(25);

        //nie są wyświetlane po kolei
        System.out.println(hashSet);

        hashSet.remove(10);
        System.out.println(hashSet);

        System.out.println("while");
        Iterator<Integer> iterator = hashSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("foreach");
        for (Integer integer : hashSet) {
            System.out.println(integer);
        }
    }
}