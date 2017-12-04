package org.expansellc.profiling.memory;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.math3.random.RandomDataGenerator;

public class MemoryDevour {
    
    private boolean isRunning = false;
    private List<Long> refuse = new ArrayList<Long>(100);
    private List<GarbageCollectorMXBean> gcBeans = ManagementFactory.getGarbageCollectorMXBeans();

    private void execute(){
        
        while (isRunning) {

            for(int i = 0; i < 100; i++) {
                refuse.add(i, Factory.generateRefuse());
            }

            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println("Error sleeping this thread . . ." + e.getMessage());
            }

            for (GarbageCollectorMXBean gcBean : gcBeans) {
                System.out.println("Name: " + gcBean.getName());
                System.out.println("Number of Collections: " + gcBean.getCollectionCount());
                System.out.println("Collection Time: " + gcBean.getCollectionTime() + " ms");
                System.out.println("Pool Names: ");

                for(String name: gcBean.getMemoryPoolNames()) {
                    System.out.println("\t" + name);
                }

                System.out.println("----");
            }
        }
    }
    
    public void start() {
        System.out.println(" Starting the Memory Devour Process . . .");
        this.isRunning = true;
        this.execute();
    }

    // TODO
    public void stop() {
        this.isRunning = false;
    }
}

/**
 * Makes huge numbers to consume memory
 */
final class Factory {

    static final long LEFT_LIMIT = 100000000L;
    static final long RIGHT_LIMIT = 10000000000000L;

    static long generateRefuse() {
        return new RandomDataGenerator().nextLong(LEFT_LIMIT, RIGHT_LIMIT);
    }
}
