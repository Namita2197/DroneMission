package Instruction;

import Controller.Communicator;
import Controller.DroneState;

public class TakeOff extends Instruction {

    @Override
    public void executeInstruction(Communicator communicator, DroneState droneState) throws Exception {
        communicator.sendSignal("takeoff");
        double zCoordinate=70.00;
        droneState.move(0.00,0.00,zCoordinate);
        System.out.println(communicator.receiveSignal());
        Thread.sleep(2000);
    }

    @Override
    public String getMessageType() {
        return null;
    }
}
