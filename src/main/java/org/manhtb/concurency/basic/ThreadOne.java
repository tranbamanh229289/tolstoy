package org.manhtb.concurency.basic;

import java.util.Random;

public class ThreadOne implements Runnable {
    private ShareData shareData;

    public ThreadOne(ShareData shareData) {
        this.shareData = shareData;
    }

    @Override
    public void run() {
        Random random = new Random();
        while(this.shareData.checkAvaiable()) {
            synchronized (shareData) {
                int rand = random.nextInt(100) + 1;
                this.shareData.setRand(rand);
                this.shareData.plus(rand);
                System.out.println("T1 generate random: " + rand);

                if (rand % 3 == 0) {
                    this.shareData.setIndex(2);
                } else {
                    if (rand % 2 == 0) {
                        this.shareData.setIndex(3);
                    }
                }
                shareData.notifyAll();
                try {
                    shareData.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        System.out.println("t1 stop");
        synchronized (shareData){
            shareData.notifyAll();
        }
    }
}
