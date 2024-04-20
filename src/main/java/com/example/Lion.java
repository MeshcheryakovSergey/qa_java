package com.example;

import java.util.List;

public class Lion {

    boolean hasMane;

    private IFeline iFeline;

    public Lion(String sex, IFeline iFeline) throws Exception {
        this.iFeline = iFeline;
        if ("Самец".equals(sex)) {
            hasMane = true;
        } else if ("Самка".equals(sex)) {
            hasMane = false;
        } else {
            throw new Exception("Используйте допустимые значения пола животного - самей или самка");
        }
    }

    public int getKittens() {
        return iFeline.getKittens();
    }

    public boolean doesHaveMane() {
        return hasMane;
    }

    public List<String> getFood() throws Exception {
        return iFeline.getFood("Хищник");
    }
}
