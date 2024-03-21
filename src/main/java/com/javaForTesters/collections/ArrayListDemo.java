package com.javaForTesters.collections;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListDemo {
    public static void main(String[] args) {

        arrayListObject();
        arrayListInteger();

    }

    private static void arrayListInteger() {

        ArrayList<Integer> integerArrayList = new ArrayList<>();
        integerArrayList.add(5);
        integerArrayList.add(10);
        integerArrayList.add(15);
        integerArrayList.add(20);

        for(Integer i: integerArrayList){
            System.out.println(i);
        }

    }

    private static void arrayListObject() {
        //add
        ArrayList<Object> arrayList = new ArrayList<>();
        arrayList.add(10);
        arrayList.add("Test");
        arrayList.add(true);
        System.out.println(arrayList.size());
        System.out.println(arrayList);

        //remove
        arrayList.remove(1);
        System.out.println(arrayList);

        //can store duplicate items
        arrayList.add(10);
        arrayList.add(true);
        arrayList.add(10);
        arrayList.add(true);
        System.out.println(arrayList);

        //fetch
        System.out.println(arrayList.get(1));

        for(int i = 0; i< arrayList.size();i++){
            System.out.println(arrayList.get(i));
        }

        for(Object object: arrayList){
            System.out.println(object);
        }
        System.out.println();
        System.out.println("while");
        Iterator<Object> iterator = arrayList.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
