package com.zelmex.messages;

public class MakeMessage implements Runnable {
    PutMessage myMsg;
    Thread t;

    public MakeMessage(PutMessage targ) {
        myMsg = targ;
        t = new Thread(this);
        t.start();
    }

    public void run() {
        myMsg.printMessage(t.getName());
    }
}