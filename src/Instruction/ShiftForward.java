package Instruction;

import Common.Communicator;
import Common.DroneState;
import java.util.Scanner;

public class ShiftForward extends Instruction {

    @Override
    public void executeInstruction(Communicator communicator, DroneState droneState) throws Exception {
        if(droneState.getBatteryPercentage()<=7||droneState.getHighTemperature()>=70) {
            System.out.println("Low Battery!\nDrone is landing now...");
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
            System.out.print("Enter x cm to move forward=");
            int distance = sc.nextInt();
            String instruction = "forward " + distance;
            communicator.sendSignal(instruction);
            System.out.println("drone has moved forward");
            System.out.println(communicator.receiveSignal());
            droneState.move(0, distance, 0);
            Thread.sleep(2000);
        }
    }

    @Override
    public String getMessageType() {
        return null;
    }
}
