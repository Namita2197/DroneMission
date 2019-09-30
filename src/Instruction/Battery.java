package Instruction;

import Controller.Communicator;

public class Battery extends Instruction {
    @Override
    public void executeInstruction(Communicator communicator) throws Exception {
//        communicator.sendSignal("battery?");
//        String batteryPercentage=communicator.receiveSignal();
//        System.out.println(batteryPercentage+" received");
        communicator.sendSignal("battery?");
        System.out.println(communicator.receiveSignal());
    }

    @Override
    public String getMessageType() {
        return null;
    }
}
