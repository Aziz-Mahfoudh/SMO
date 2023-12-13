package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class VirtualMachine {

    private static int number=0;
    private int instanceNumber;
    private int cpu;
    private int unusedCpu;
    private int memory;
    private int unusedMemory;
    private int storage;
    private int unusedStorage;
    private List<Workload> workloads;


    public VirtualMachine(int cpu, int memory, int storage) {
        VirtualMachine.number++;
        this.instanceNumber = VirtualMachine.number;
        this.cpu = cpu;
        this.unusedCpu = cpu;
        this.memory = memory;
        this.unusedMemory = memory;
        this.storage = storage;
        this.unusedStorage = storage;
        this.workloads = new ArrayList<>();
    }



    public void processWorkload() {
        for (Workload workload: workloads) {
            if ( cpu >= workload.getCpuDemand() && memory >= workload.getMemoryDemand()) {
                unusedCpu -= workload.getCpuDemand();
                unusedMemory -= workload.getMemoryDemand();
                System.out.println("VM "+ instanceNumber +" Processing Workload CPU="+unusedCpu+", Memory="+unusedMemory+ ", Storage="+unusedStorage);

            } else {
                System.out.println("VM "+ instanceNumber +" Insufficient Resources for Workload");
            }
        }
    }

    public void adjustParameters(int cpuAdjustment, int memoryAdjustment, int storageAdjustment) {
        Random rand = new Random();

        // Adjust CPU within the range [0, cpuAdjustment]
        this.cpu = Math.max(0, this.cpu - rand.nextInt(cpuAdjustment + 1));

        // Adjust memory within the range [0, memoryAdjustment]
        this.memory = Math.max(0, this.memory - rand.nextInt(memoryAdjustment + 1));

        // Adjust storage within the range [0, storageAdjustment]
        this.storage = Math.max(0, this.storage - rand.nextInt(storageAdjustment + 1));

        System.out.println("VM "+ instanceNumber +" Adjusted Parameters: CPU=" + cpu + ", Memory=" + memory + ", Storage=" + storage);
    }
    public double calculateEnergyConsumption() {
        // Adjust these coefficients based on the impact of each resource on energy consumption
        double cpuFactor = 0.1;
        double memoryFactor = 0.05;
        double storageFactor = 0.02;

        // Non-linear transformations to capture the impact of resource usage
        double cpuFactorTransformed = Math.pow(cpuFactor, cpu);
        double memoryFactorTransformed = Math.pow(memoryFactor, memory);
        double storageFactorTransformed = Math.pow(storageFactor, storage);

        // Combine the transformed factors to model the non-linear relationship
        double energyConsumption = cpuFactorTransformed * memoryFactorTransformed * storageFactorTransformed;

        return energyConsumption;
    }


    public int getInstanceNumber() {
        return instanceNumber;
    }

    public void addWorkload(Workload workload) {
        workloads.add(workload);
    }

}
