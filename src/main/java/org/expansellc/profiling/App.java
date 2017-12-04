package org.expansellc.profiling;

import org.expansellc.profiling.memory.MemoryDevour;

public class App {

    public static void main(String[] args) {
        MemoryDevour devour = new MemoryDevour();
        devour.start();
    }
}


