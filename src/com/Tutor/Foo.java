package com.Tutor;

import java.util.concurrent.atomic.AtomicBoolean;

public class Foo {
    private volatile AtomicBoolean isFirstFinished;
    private volatile AtomicBoolean isSecondFinished;
    private volatile AtomicBoolean isThirdFinished;

    public Foo() {
        this.isFirstFinished = new AtomicBoolean();
        this.isSecondFinished = new AtomicBoolean();
        this.isThirdFinished = new AtomicBoolean();
    }

    public AtomicBoolean getIsFirstFinished() {
        return isFirstFinished;
    }

    public void setIsFirstFinished(AtomicBoolean isFirstFinished) {
        this.isFirstFinished = isFirstFinished;
    }

    public AtomicBoolean getIsSecondFinished() {
        return isSecondFinished;
    }

    public void setIsSecondFinished(AtomicBoolean isSecondFinished) {
        this.isSecondFinished = isSecondFinished;
    }

    public AtomicBoolean getIsThirdFinished() {
        return isThirdFinished;
    }

    public void setIsThirdFinished(AtomicBoolean isThirdFinished) {
        this.isThirdFinished = isThirdFinished;
    }

    public void first(Runnable r){
        r.run();
        this.isFirstFinished.set(true);
    };
    public void second(Runnable r){
        while (!this.isFirstFinished.get()){

        }
        r.run();
        this.isSecondFinished.set(true);
    };
    public void third(Runnable r){
        while (!this.isSecondFinished.get()){

        }
        r.run();
        this.isThirdFinished.set(true);
    };
}


