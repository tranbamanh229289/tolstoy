package org.manhtb.concurency.basic;

public class ThreadTwo implements Runnable {
    private ShareData shareData;

    public ThreadTwo(ShareData shareData) {
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
                    while (shareData.getIndex() != 2 && shareData.checkAvaiable()) {
                        shareData.wait();
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                int rand = shareData.getRand();
                System.out.println("T2 print: " + rand*rand);
                shareData.setIndex(1);

            }
        }
        System.out.println("t2 stop");
        synchronized (shareData){
            shareData.notifyAll();
        }
    }
}
