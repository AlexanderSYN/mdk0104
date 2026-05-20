package com.zelmex.messages;

import static com.zelmex.messages.IO.perr;
import static com.zelmex.messages.IO.println;

public class PutMessage {
    synchronized void printMessage(String nameThread) {
        String[] msg = {
                "1. No pains, no gains",
                "2. No gain without pain",
                "3. He is lifeless that is faultless",
                "4. Idieness rusts the mind",
                "5. Keen eyes are small gain in the head without brain"
        };

        println(nameThread);
        for (int i =0; i < msg.length; i++) {
            println(msg[i]);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ie) {
                perr("Thread Interrupted");
            }
        }
    }
}
