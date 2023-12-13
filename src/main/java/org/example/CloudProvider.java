package org.example;

import java.util.ArrayList;
import java.util.List;

public class CloudProvider {

    private List<VirtualMachine> vms;

    public CloudProvider() {
        this.vms = new ArrayList<>();
    }

    public void addVirtualMachine(VirtualMachine vm) {
        vms.add(vm);
    }
    public List<VirtualMachine> getVirtualMachines() {
        return vms;
    }

    public void processWorkloads() {
        for (VirtualMachine vm : vms) {
            vm.processWorkload();
        }
    }

    public double calculateTotalEnergyConsumption() {
        double totalEnergyConsumption = 0;
        for (VirtualMachine vm : vms) {
            totalEnergyConsumption += vm.calculateEnergyConsumption();
        }
        return totalEnergyConsumption;
    }
}
