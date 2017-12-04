### JVM Memory Management Tools ###

#### Summary ####

Playground app with which to visualize garbage collection. 

The `MemoryDevour` class creates a number of trash objects which are dumped into Eden Space.
Hook up `jvisualvm` with the [Visual GC Plugin](https://visualvm.github.io/plugins.html) 
to see the sawtooth wave.

#### How to Use ####
Default:

`java -jar org.expansellc.profiling-1.0-SNAPSHOT-jar-with-dependencies.jar` 

+ Young Generation Collector - Parallel Scavenge
+ Old Generation Collector - Parallel Mark Sweep

```bash
JVM Management Tools
Name: PS Scavenge
Number of Collections: 0
Collection Times: 0 ms
Pool Names: 
    PS Eden Space
    PS Survivor Space
----
Name: PS MarkSweep
Number of Collections: 0
Collection Times: 0 ms
Pool Names: 
    PS Eden Space
    PS Survivor Space
    PS Old Gen
----
```

Concurrent Mark Sweep:

`java -jar  -XX:+UseConcMarkSweepGC org.expansellc.profiling-1.0-SNAPSHOT-jar-with-dependencies.jar`

```
Management Tools
Name: ParNew
Number of Collections: 0
Collection Times: 0 ms
Pool Names: 
    Par Eden Space
    Par Survivor Space
----
Name: ConcurrentMarkSweep
Number of Collections: 0
Collection Times: 0 ms
Pool Names: 
    Par Eden Space
    Par Survivor Space
    CMS Old Gen
----
```

G1:
`java -jar  -XX:+UseG1GC org.expansellc.profiling-1.0-SNAPSHOT-jar-with-dependencies.jar`

```
JVM Management Tools
Name: G1 Young Generation
Number of Collections: 0
Collection Times: 0 ms
Pool Names: 
    G1 Eden Space
    G1 Survivor Space
----
Name: G1 Old Generation
Number of Collections: 0
Collection Times: 0 ms
Pool Names: 
    G1 Eden Space
    G1 Survivor Space
    G1 Old Gen
----


```

#### References ####
[FasterJ](http://www.fasterj.com/articles/oraclecollectors1.shtml)