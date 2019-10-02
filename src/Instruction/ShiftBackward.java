package Instruction;

import Common.Communicator;
import Common.DroneState;

import java.util.Scanner;

public class ShiftBackward extends Instruction {
//    public ShiftBackward(Communicator communicator) {
//
//        super(communicator);
//    }
    public void executeInstruction(Communicator communicator, DroneState droneState) throws  Exception{

        if(droneState.getBatteryPercentage()<=7||droneState.getHighTemperature()>=70) {

            System.out.println("Low Battery!\nDrone is landing now...");
//                Land land = new Land();
//                land.executeInstruction(communicator,droneState);
            // instruction.executeInstruction(communicator,droneState);
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

        }else {

            Scanner sc = new Scanner(System.in);
            System.out.print("Enter x cm to move back=");
            int distance = sc.nextInt();
            String instruction = "back " + distance;
            communicator.sendSignal(instruction);
            System.out.println("drone has moved backward");
            System.out.println(communicator.receiveSignal());
            droneState.move(0.0, -distance, 0.0);
            Thread.sleep(2000);
        }
    }

    @Override
    public String getMessageType() {
        return null;
    }
}
