package Instruction;

import Controller.Communicator;

public class FlipForward extends Instruction {
//    public FlipForward(Communicator communicator) {
//        super(communicator);
//    }

    @Override
    public void executeInstruction(Communicator communicator) throws Exception {
        communicator.sendSignal("flip f");
        Thread.sleep(2000);
    }
}
