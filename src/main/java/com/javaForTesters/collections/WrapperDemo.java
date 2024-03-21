package com.javaForTesters.collections;

public class WrapperDemo {
    public static void main(String[] args) {
        //prymitywne dane nie mogą być przechowywane w kolekcjach
        int i = 10;
        Integer integer = i; //Wrapping/autoboxing
        System.out.println(integer);

        int j = integer;
        System.out.println(j); //UnWrapping/auto unboxing




    }
}
