package Instruction;

import Controller.Communicator;

public class Land extends Instruction {

//    public Land(Communicator communicator) {
//        super(communicator);
//    }

    @Override
    public void executeInstruction(Communicator communicator) throws Exception {
        communicator.sendSignal("land");
        Thread.sleep(2000);
    }

    @Override
    public String getMessageType() {
        return null;
    }
}
