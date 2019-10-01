package Instruction;

import Controller.Communicator;
import Controller.DroneState;

public class TakeOff extends Instruction {

 //   public TakeOff() {

        //super(communicator);
   // }

    @Override
    public void executeInstruction(Communicator communicator, DroneState droneState) throws Exception {
        double zCoordinate;
        zCoordinate=droneState.getPositionZ();
        double xCoordinate=droneState.getPositionX();
        double ycoordinate=droneState.getPositionY();
        xCoordinate=ycoordinate=zCoordinate=0.00;
        communicator.sendSignal("takeoff");
        zCoordinate=zCoordinate+70.00;
        droneState.move(0.00,0.00,zCoordinate);
        System.out.println(communicator.receiveSignal());
        Thread.sleep(2000);
    }

    @Override
    public String getMessageType() {
        return null;
    }
}
