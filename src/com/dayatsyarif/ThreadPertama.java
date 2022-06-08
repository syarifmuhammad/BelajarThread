package com.dayatsyarif;

import java.util.ArrayList;

public class ThreadPertama implements Runnable{

    private int awal;
    private int setAwal;
    private int penambahan = 2;
    public ThreadPertama(int awal) {
        this.awal = awal;
        this.setAwal = awal;
    }

    @Override
    public void run() {
        class Letter {
            public int i = awal;
            private String[] abjad = {
                    "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k",
                    "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v",
                    "w", "x", "y", "z"
            };
            public int increment(){
                if(this.i + penambahan > 25){
                    this.i = awal;
                    return 1;
                }else{
                    this.i+=penambahan;
                    return 0;
                }
            }

            public String get(){
                if(i<=25){
                    return this.abjad[this.i];
                }else{
                    return "a";
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
        while(!Main.pass.equals(word.get())) {
//            if(i==0){
                awal = setAwal;
                penambahan = 2;
//                System.out.println("harus kembali ke awal");
//            }
            word.increment();
//            System.out.println(word.get());
//            System.out.println("hasil : ini thread " + awal + " " + word.get());
            i++;
        }
        System.out.println("Pencarian Selesai dengan hasil : " + word.get());
            Main.s.stop();
            Main.s2.stop();
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
