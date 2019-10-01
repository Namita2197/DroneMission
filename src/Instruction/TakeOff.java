package Instruction;

import Controller.Communicator;
import Controller.DroneState;

public class TakeOff extends Instruction {

 //   public TakeOff() {

        //super(communicator);
   // }

    @Override
    public void executeInstruction(Communicator communicator, DroneState droneState) throws Exception {
        communicator.sendSignal("takeoff");
        System.out.println(communicator.receiveSignal());
        Thread.sleep(2000);
    }

    @Override
    public String getMessageType() {
        return null;
    }
}
