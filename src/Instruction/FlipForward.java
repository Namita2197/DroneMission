package Instruction;

import Common.Communicator;
import Common.DroneState;
import java.util.Scanner;

public class FlipForward extends Instruction {

    Instruction instruction;

    @Override
    public void executeInstruction(Communicator communicator, DroneState droneState) throws Exception {
        if(droneState.getBatteryPercentage()<=7||droneState.getHighTemperature()>=70) {
            System.out.println("Low Battery!\nDrone is landing now...");
            communicator.sendSignal("land");
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
            if (droneState.getBatteryPercentage() <= 10) {
                System.out.println("Battery too low to make a flip!");
                Scanner sc = new Scanner(System.in);
                System.out.print("Rather enter x cm to move forward=");
                int distance = sc.nextInt();
                String instruction = "forward " + distance;
                droneState.move(0, distance, 0);

                if(droneState.getPositionX()>=300 || droneState.getPositionY()>=300){
                    System.out.println("Drone is getting out of the 3 meter zone\nPausing mission for 5 seconds.....");
                    Thread.sleep(5000);
                }
                communicator.sendSignal(instruction);
                System.out.println("drone has moved forward");
                System.out.println(communicator.receiveSignal());

                Thread.sleep(2000);
            } else {
                Scanner sc = new Scanner(System.in);
                System.out.print("Enter the initials of the direction you want to flip towards(l/r/f/b)=");
                String direction = sc.next();
                if (direction.equals("l") || direction.equals("r") || direction.equals("f") || direction.equals("b")) {
                    String instruction = "flip " + direction;
                    communicator.sendSignal(instruction);
                    System.out.println("drone has flipped");
                    System.out.println(communicator.receiveSignal());
                    double yCoordinate;
                    double xCoordinate;
                    if (direction.equals("f")) {
                        yCoordinate = 10;
                        droneState.move(0.00, yCoordinate, 0.00);
                    } else if (direction.equals("b")) {
                        yCoordinate = -10;
                        droneState.move(0.00, yCoordinate, 0.00);
                    } else if (direction.equals("l")) {
                        xCoordinate = -10;
                        droneState.move(xCoordinate, 0.00, 0.00);
                    } else if (direction.equals("r")) {
                        xCoordinate = 10;
                        droneState.move(xCoordinate, 0.00, 0.00);
                    }
                } else {
                    System.out.println("Invalid Direction.");
                }
            }
        }
        Thread.sleep(2000);
    }
}
