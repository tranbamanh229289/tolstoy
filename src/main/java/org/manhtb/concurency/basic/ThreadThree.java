package org.manhtb.concurency.basic;

public class ThreadThree implements Runnable {
    private ShareData shareData;

    public ThreadThree(ShareData shareData) {
        this.shareData = shareData;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        while (shareData.checkAvaiable()) {
            synchronized (shareData) {
                shareData.notifyAll();
                try {
                    while (shareData.getIndex() != 3 && shareData.checkAvaiable()) {
                        shareData.wait();
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                int rand = shareData.getRand();
                if(rand % 4 == 0) {
                    System.out.println("T3 print: rand is " + rand + " divisible by 4");
                } else {
                    System.out.println("T3 print: rand is not " + rand + " divisible by 4");
                }
                shareData.setIndex(1);
            }
        }
        System.out.println("t3 stop");
        synchronized (shareData){
            shareData.notifyAll();
        }
    }
}
