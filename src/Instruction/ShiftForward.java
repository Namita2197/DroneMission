package Instruction;

import Controller.Communicator;

public class ShiftForward extends Instruction {
    //public ShiftForward(Communicator communicator) {
       // super(communicator);
   // }

    @Override
    public void executeInstruction(Communicator communicator) throws Exception {
        communicator.sendSignal("forward 25");
        Thread.sleep(2000);
    }
}
