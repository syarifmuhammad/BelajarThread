package com.dayatsyarif;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static String pass = "nauval";
    public static ArrayList<Thread> kumpulanThread = new ArrayList<Thread>();
    public static int jumlahThread = 2;
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.print("Masukkan password yang akan di cari : ");
        pass = sc.nextLine();
        if(!pass.equals("")){
            System.out.print("Masukkan jumlah thread yang ingin digunakan : ");
            jumlahThread = sc.nextInt();
            if(jumlahThread != 0){
                for(var i=0; i<jumlahThread; i++){
                    kumpulanThread.add(new Thread(new ThreadPertama(i)));
                }
                for(var i=0; i<jumlahThread; i++){
                    kumpulanThread.get(i).start();
                }
            }else{
                System.out.println("Pencarian tidak dilakukan karena thread yang digunakan 0");
            }
        }else{
            System.out.println("Pencarian Selesai dengan hasil : Tidak ada hasil atau passsword adalah (string kosong)");
        }

    }
}
