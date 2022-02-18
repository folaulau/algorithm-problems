package com.folatech.linkedlist.removeduplicates;

import java.util.HashMap;
import java.util.Map;

public class RemoveDuplicatesMain {

    public static void main(String[] args) {

    }

    static LinkedList removeDuplicatesFromLinkedList(LinkedList linkedList) {

        Map<Integer, Integer> map = new HashMap<>();

        while (linkedList != null) {

            int value = linkedList.value;
            LinkedList next = linkedList.next;

            if (next != null && next.value == value) {
                if (next.next != null) {
                    linkedList.next = next.next;
                } else {
                    linkedList.next = null;
                }
            } else {
                linkedList = linkedList.next;
            }

        }

        return linkedList;
    }

    public static class LinkedList {
        public int        value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }
}
