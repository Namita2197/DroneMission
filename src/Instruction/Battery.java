package Instruction;

import Controller.Communicator;
import Controller.DroneState;

public class Battery extends Instruction {
    @Override
    public void executeInstruction(Communicator communicator, DroneState droneState) throws Exception {
        communicator.sendSignal("battery?");
        System.out.println(communicator.receiveSignal());
        int batteryPercentage=droneState.getBatteryPercentage();
        System.out.println("Battery remaining:"+batteryPercentage);
    }

    @Override
    public String getMessageType() {
        return null;
    }
}
