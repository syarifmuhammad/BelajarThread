package com.dayatsyarif;

import java.util.ArrayList;

public class ThreadPertama implements Runnable{

    private int awal;
    private int setAwal;
    private int penambahan;
    public ThreadPertama(int awal) {
        this.awal = awal;
        this.setAwal = awal;
        this.penambahan = Main.jumlahThread;
    }

    @Override
    public void run() {
        class Letter {
            public int i = awal;
            private String[] abjad = {
                    " ", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k",
                    "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v",
                    "w", "x", "y", "z",
//                    "0", "1", "2", "3", "4", "5", "6", "7", "8", "9"
            };
            public int increment(){
                if(this.i + penambahan > this.abjad.length-1){
                    this.i = awal;
                    return 1;
                }else{
                    this.i+=penambahan;
                    return 0;
                }
            }

            public String get(){
                if(i<=this.abjad.length-1){
                    return this.abjad[this.i];
                }else{
                    return this.abjad[0];
                }
            }
        }
        class Word {
            ArrayList<Letter> letters = new ArrayList<Letter>();
            Word(){
                this.letters.add(new Letter());
            }
            public void increment(){
                int i=0;
                while(this.letters.get(i).increment() == 1) {
                    if (i + 1 < this.letters.size()) {
                        i++;
                        awal = 0;
                        penambahan = 1;
                    } else {
                        awal = 0;
                        penambahan = 1;
                        this.letters.add(new Letter());
                        break;
                    }

                }
            }

            public String get(){
                String hasil = "";
                for(int i=0; i<this.letters.size(); i++){
                    hasil += this.letters.get(i).get();
                }
                return hasil;
            }
        }
        Word word = new Word();
        System.out.println("Masih mencari ...");
        int i = 0;
        while(!Thread.interrupted() &&!Main.pass.equals(word.get())) {
            awal = setAwal;
            penambahan = Main.jumlahThread;
            word.increment();
            i++;
        }
        if(Main.pass.equals(word.get())) {
            System.out.println("Pencarian Selesai dengan hasil : " + word.get());
            for(var j=0; j<Main.jumlahThread; j++){
                Main.kumpulanThread.get(j).interrupt();
            }
        }
    }
}




//    private int idThread;
//    public ThreadPertama(int idThread) {
//        this.idThread = idThread;
//    }
//
//    @Override
//    public void run() {
//        var found = false;
//        var hasil = "";
//        var max= 26;
//        var angka = max - (13 * idThread);
//        var batas = angka + 13 ;
//        while(!found){
//            var h = getHasil(angka);
//            if(h.equals(Main.pass)){
//                found = true;
//                hasil = h;
//            }
//            angka++;
//            if(angka==batas){
//                max = max*2;
//                angka = max - (13*idThread);
//                batas = angka + 13 ;
//            }
//            System.out.println("Aku thread " + idThread + " max " + max + " batas " + batas + " i " + angka );
//        }
//        System.out.println("Aku hasil dari thread " + idThread + " : " + hasil);
//    }
//
//    private static String getHasil(int i) {
//        var penyebut = i;
//        var hasilBagi = Math.floor(penyebut/26);
//        ArrayList<Integer> hasil = new ArrayList<>();
//        hasil.add(penyebut%26);
//        while(hasilBagi != 0){
//            if(penyebut == 26 && hasilBagi == 1){
//                hasil.add(0);
//                hasilBagi = 0;
//            }else {
//                penyebut = (int) hasilBagi;
//                hasilBagi = Math.floor(penyebut/26);
//                hasil.add(penyebut%26);
//            }
//
//        }
//        var result = "";
//        for(var j=0; j<hasil.size(); j++){
//            result+=Main.abjad[hasil.get(j)];
//        }
//        return result;
//    }
