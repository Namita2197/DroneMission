package Instruction;

import Controller.Communicator;

public class TakeOff extends Instruction {

 //   public TakeOff() {

        //super(communicator);
   // }

    @Override
    public void executeInstruction(Communicator communicator) throws Exception {
        communicator.sendSignal("takeoff");
        Thread.sleep(2000);
    }

    @Override
    public String getMessageType() {
        return null;
    }
}
