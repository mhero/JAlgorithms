package com.mac.algorithms.tortoiseandhare;

public class TortoiseHare {

    public static Boolean hasLoop(Node first) {

        //empty list
        if (first == null) {
            return false;
        }

        Node slow, fast; // create two references.

        slow = fast = first; // make both refer to the start of the list.

        while (true) {

            slow = slow.getNext();          // 1 hop.

            if (fast.getNext() != null) {
                fast = fast.getNext().getNext(); // 2 hops.
            } else {
                return false;          // next node null => no loop.
            }

            // if either hits null..no loop.
            if (slow == null || fast == null) {
                return false;
            }

            // if the two ever meet...we must have a loop.
            if (slow == fast) {
                return true;
            }
        }
    }
}
