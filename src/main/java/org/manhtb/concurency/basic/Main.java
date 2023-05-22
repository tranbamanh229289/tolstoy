package org.manhtb.concurency.basic;

public class Main {
    public static void main(String[] args) {
        ShareData shareData = new ShareData();
        Thread t1 = new Thread(new ThreadOne(shareData));
        Thread t2 = new Thread(new ThreadTwo(shareData));
        Thread t3 = new Thread(new ThreadThree(shareData));
        t1.start();
        t2.start();
        t3.start();
    }
}
