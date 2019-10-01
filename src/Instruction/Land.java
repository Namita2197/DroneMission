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
        double yCoordinate;
        double zCoordinate;
        double xCoordinate;
        yCoordinate=droneState.getPositionY();

        zCoordinate=droneState.getPositionZ();
        xCoordinate=droneState.getPositionX();
        System.out.println("Coordinates before landing:"+"("+xCoordinate+","+yCoordinate+","+zCoordinate+")");
        zCoordinate=0.00;
        droneState.move(xCoordinate,yCoordinate,zCoordinate);
        Thread.sleep(2000);
    }

    @Override
    public String getMessageType() {
        return null;
    }
}
