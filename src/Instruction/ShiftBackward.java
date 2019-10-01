package Instruction;

import Controller.Communicator;
import Controller.DroneState;

import java.util.Scanner;

public class ShiftBackward extends Instruction {
//    public ShiftBackward(Communicator communicator) {
//
//        super(communicator);
//    }
    public void executeInstruction(Communicator communicator, DroneState droneState) throws  Exception{
        Scanner sc =new Scanner(System.in);
        System.out.print("Enter x cm to move back=");
        int distance=sc.nextInt();
        String instruction = "back "+distance;
        communicator.sendSignal(instruction);
        System.out.println(communicator.receiveSignal());
        double yCoordinate;
        double zCoordinate;
        double xCoordinate;
        yCoordinate=droneState.getPositionY();
        yCoordinate=yCoordinate-distance;
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
