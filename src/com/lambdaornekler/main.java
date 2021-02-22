package com.lambdaornekler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.function.Consumer;

public class main {
    public static void main(String[] args) {

        Calisan c1=new Calisan("Metin",22);
        Calisan c2=new Calisan("Çetkin",21);
        Calisan c3=new Calisan("Ahmet",23);

        ArrayList<Calisan> arrayList=new ArrayList<>();

        arrayList.add(c1);
        arrayList.add(c2);
        arrayList.add(c3);

        /*
        for (Calisan calisan : arrayList){
            calisanlariYazdir(new calisanYazdiranInterface() {
                @Override
                public void yazdir() {
                    System.out.println(calisan.getIsim()+" "+calisan.getYas());
                }
            });
        }
        */

        for (Calisan calisan: arrayList){
            calisanlariYazdir(()-> System.out.println(calisan.getIsim()+" "+calisan.getYas()));
        }

        /*new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread Çalıştı");
            }
        }).start();
        */

        new Thread(()-> System.out.println("Thread Çalıştı")).start();

        new Thread(new ThreadSinifi()).start();

        /*
        Collections.sort(arrayList, new Comparator<Calisan>() {
            @Override
            public int compare(Calisan o1, Calisan o2) {
                return o1.getIsim().compareTo(o2.getIsim());
            }
        });
        */

        Collections.sort(arrayList , ((o1, o2) -> o1.getIsim().compareTo(o2.getIsim())));

        /*arrayList.forEach(new Consumer<Calisan>() {
            @Override
            public void accept(Calisan calisan) {
                System.out.println(calisan.getIsim());
            }
        });

        for (Calisan calisan : arrayList ){
            System.out.println(calisan.getIsim());
        }
         */

        arrayList.forEach((calisan -> System.out.println(calisan.getIsim())));
    }

    public static void calisanlariYazdir(calisanYazdiranInterface calisanYazdiranInterface){
        calisanYazdiranInterface.yazdir();
    }
}

class ThreadSinifi implements Runnable{


    @Override
    public void run() {
        System.out.println("Thread SInıfı çalıştı");
    }
}

class Calisan{

    private String isim;
    private int yas;

    public Calisan(String isim, int yas) {
        this.isim = isim;
        this.yas = yas;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public int getYas() {
        return yas;
    }

    public void setYas(int yas) {
        this.yas = yas;
    }
}
