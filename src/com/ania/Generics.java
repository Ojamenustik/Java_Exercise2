package com.ania;

import java.util.ArrayList;

public class Generics {

    public class Camera{

    }

    public class Obscura extends Camera{


    }

    public static void showList(ArrayList<String> list){
        for(String value: list){
            System.out.println(value);
        }
    }

}
