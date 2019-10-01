package Instruction;

import Controller.Communicator;
import Controller.DroneState;

public class Land extends Instruction {

//    public Land(Communicator communicator) {
//        super(communicator);
//    }

    @Override
    public void executeInstruction(Communicator communicator, DroneState droneState) throws Exception {
        communicator.sendSignal("land");
        System.out.println(communicator.receiveSignal());
        Thread.sleep(2000);
    }

    @Override
    public String getMessageType() {
        return null;
    }
}
