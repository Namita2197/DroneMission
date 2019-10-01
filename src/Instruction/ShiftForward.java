package Instruction;

import Controller.Communicator;
import Controller.DroneState;

import java.util.Scanner;

public class ShiftForward extends Instruction {
    //public ShiftForward(Communicator communicator) {
       // super(communicator);
   // }

    @Override
    public void executeInstruction(Communicator communicator, DroneState droneState) throws Exception {
        Scanner sc =new Scanner(System.in);
        System.out.print("Enter x cm to move forward=");

        int distance=sc.nextInt();
        String instruction = "forward "+distance;
        communicator.sendSignal(instruction);
        System.out.println(communicator.receiveSignal());
        double yCoordinate;
        double zCoordinate;
        double xCoordinate;
        yCoordinate=droneState.getPositionY();
        yCoordinate=yCoordinate+distance;
        zCoordinate=droneState.getPositionZ();
        xCoordinate=droneState.getPositionX();
        droneState.move(xCoordinate,yCoordinate,zCoordinate);
        Thread.sleep(2000);
    }

    @Override
    public String getMessageType() {
        return null;
    }
}
