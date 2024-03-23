package com.javaForTesters.collections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class HashMapDemo {
    public static void main(String[] args) {
        //HashMap contains data as key, value pairs
        //Contains only unique Keys
        //Not synchronized and No order
        //Java HashMap may have one null key and multiple null values

        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("qa","http://qa.com");
        hashMap.put("uat","http://uat.com");
        hashMap.put("preprod","http://preprod.com");
        hashMap.put("prod","http://prod.com");
        System.out.println(hashMap);

        hashMap.remove("qa");
        hashMap.remove("uat","test");

        System.out.println(hashMap);

        Set<String> set= hashMap.keySet();

        for(String key: set){
            System.out.println("key is " + key + " Value is " + hashMap.get(key));
        }

        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()){
            String key = iterator.next();
            System.out.println("key is " + key + " Value is " + hashMap.get(key));;
        }
    }
}