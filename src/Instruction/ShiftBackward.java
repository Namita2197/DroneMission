package Instruction;

import Controller.Communicator;

public class ShiftBackward extends Instruction {
//    public ShiftBackward(Communicator communicator) {
//
//        super(communicator);
//    }
    public void executeInstruction(Communicator communicator) throws  Exception{
        communicator.sendSignal("back 25");
        Thread.sleep(2000);
    }
}
