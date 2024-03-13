package com.javaForTesters;

public class Arrays{
    public static void main(String[] args) {

        singleDimensionalArray();
        multidimensionalArray();
    }

    public static void singleDimensionalArray(){
        System.out.println("singleDimensionalArray");
        int number = 10;
        int[] myIntArray = new int[number];
        myIntArray[0] = 10;
        myIntArray[1] = 20;
        myIntArray[2] = 30;
        myIntArray[3] = 40;
        myIntArray[4] = 50;
        System.out.println(myIntArray[3]);
        System.out.println(myIntArray.length);

        int[] myIntArray1 = {10,20,30,40,50};
        System.out.println(myIntArray1[1]);

        for(int i=0; i<myIntArray1.length;i++){
            System.out.print(myIntArray1[i] + ",");
        }
        System.out.println();
    }

    public static void multidimensionalArray(){
        System.out.println("multidimensionalArray");

        int[][] myMultiDimArray = new int[2][3];
        myMultiDimArray[0][0]= 2;
        myMultiDimArray[0][1]= 3;
        myMultiDimArray[0][2]= 5;
        myMultiDimArray[1][0]= 6;
        myMultiDimArray[1][1]= 8;
        myMultiDimArray[1][2]= 9;

        System.out.println(myMultiDimArray[1][2]);

        int[][] myMultiDimArray1 = {{2,3,5},{6,8,9}};

        System.out.println(myMultiDimArray1[0][1]);

        for (int i=0;i<myMultiDimArray1.length;i++){
            System.out.print("{");
            for(int j=0;j<myMultiDimArray1[i].length;j++){
                System.out.print(myMultiDimArray1[i][j]);
            }
            System.out.print("}");
        }

    }
}
