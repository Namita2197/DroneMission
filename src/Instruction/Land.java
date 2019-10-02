package Instruction;

import Common.Communicator;
import Common.DroneState;

public class Land extends Instruction {

//    public Land(Communicator communicator) {
//        super(communicator);
//    }

    @Override
    public void executeInstruction(Communicator communicator, DroneState droneState) throws Exception {

        communicator.sendSignal("land");
        System.out.println("drone has landed");
        System.out.println(communicator.receiveSignal());
        double yCoordinate;
        double zCoordinate;
        double xCoordinate;
        yCoordinate=droneState.getPositionY();

        zCoordinate=droneState.getPositionZ();
        xCoordinate=droneState.getPositionX();
        System.out.println("Coordinates before landing:"+"("+xCoordinate+","+yCoordinate+","+zCoordinate+")");
        droneState.move(0.00,0.00,0.00);
        Thread.sleep(2000);
    }

    @Override
    public String getMessageType() {
        return null;
    }
}
