package com.zelmex.messages;

import static com.zelmex.messages.IO.perr;

public class MessagesApp {
    public static void main(String[] args) {
        PutMessage target = new PutMessage();

        MakeMessage ob1 = new MakeMessage(target);
        MakeMessage ob2 = new MakeMessage(target);
        MakeMessage ob3 = new MakeMessage(target);

        try {
            ob1.t.join();
            ob2.t.join();
            ob3.t.join();
        } catch (InterruptedException ie) {
            perr("Main Thread Interrupted");
        }
    }
}

