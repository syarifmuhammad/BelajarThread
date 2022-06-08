package com.dayatsyarif;

import java.util.ArrayList;

public class Main {
    public static String pass = "gilang";
    public static Thread s;
    public static Thread s2;
    public static void main(String[] args) {

        ThreadPertama t = new ThreadPertama(0);
        ThreadPertama t2 = new ThreadPertama(1);

        s = new Thread(t);
        s2 = new Thread(t2);

        s.start();
        s2.start();



    }
}
