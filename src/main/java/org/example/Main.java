package org.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {

        CloudProvider cloudProvider = new CloudProvider();

        VirtualMachine vm2 = new VirtualMachine(4, 8, 100);
        VirtualMachine vm1 = new VirtualMachine(8, 16, 200);

        cloudProvider.addVirtualMachine(vm1);
        cloudProvider.addVirtualMachine(vm2);

        ExecutorService threadPool = Executors.newFixedThreadPool(cloudProvider.getVirtualMachines().size());



        //Add Workloads to VMs
        Workload workload1 = new Workload(3,5);
        Workload workload2 = new Workload(2,3);

        vm1.addWorkload(workload1);
        vm2.addWorkload(workload2);

        //Simulate processing workloads in the Cloud Provider
        cloudProvider.processWorkloads();

        SMO smoOptimizer = new SMO();
        smoOptimizer.optimizeEnergyConsumption(cloudProvider, 50);

        threadPool.shutdown();

        double totalEnergyConsumption = cloudProvider.calculateTotalEnergyConsumption();
        System.out.println("Totale Energy Consumption "+ totalEnergyConsumption);

    }




}