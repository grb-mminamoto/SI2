package com.exemplo;

import org.apache.commons.collections.map.LRUMap;

public class App {
    public static void main(String[] args) {
        LRUMap map = new LRUMap();
        map.put("key", "value");
        System.out.println("Funcionou!");
    }
}
