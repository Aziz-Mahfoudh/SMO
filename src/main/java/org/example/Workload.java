package org.example;

public class Workload {
    private int cpuDemand;
    private int memoryDemand;

    public Workload(int cpuDemand, int memoryDemand) {
        this.cpuDemand = cpuDemand;
        this.memoryDemand = memoryDemand;
    }


    public int getCpuDemand() {
        return this.cpuDemand;
    }

    public int getMemoryDemand() {
        return this.memoryDemand;
    }
}
