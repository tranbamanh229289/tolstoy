package org.manhtb.concurency.basic;

public class ShareData {
    private int rand;
    private int total;

    private int index;

    ShareData() {
        this.total = 0;
        this.index = 1;
    }

    public int getRand() {
        return rand;
    }

    public void setRand(int rand) {
        this.rand = rand;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void plus(int rand) {
        this.total += rand;
    }

    public boolean checkAvaiable() {
        if (this.total > 200) {
            return false;
        }
        return true;
    }
}
