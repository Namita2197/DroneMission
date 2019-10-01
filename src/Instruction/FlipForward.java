package Instruction;

import Controller.Communicator;
import Controller.DroneState;

import java.util.Scanner;

public class FlipForward extends Instruction {

    Instruction instruction;
    @Override
    public void executeInstruction(Communicator communicator, DroneState droneState) throws Exception {

        if(droneState.getBatteryPercentage()<=10) {
            System.out.println("Battery too low to make a flip!");
            instruction = new ShiftForward();
            instruction.executeInstruction(communicator,droneState);
        }else {

            Scanner sc = new Scanner(System.in);
            System.out.print("Enter the initials of the direction you want to flip towards(l/r/f/b)=");
            String direction = sc.next();
            if (direction.equals("l") || direction.equals("r") || direction.equals("f") || direction.equals("b")) {
                String instruction = "flip " + direction;
                communicator.sendSignal(instruction);
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
                    xCoordinate =  -10;
                    droneState.move(xCoordinate, 0.00, 0.00);
                } else if (direction.equals("r")) {
                    xCoordinate = 10;
                    droneState.move(xCoordinate,0.00, 0.00);
                }
               // droneState.move(xCoordinate, yCoordinate, zCoordinate);
            } else {
                System.out.println("Invalid Direction.");
            }
        }
        Thread.sleep(2000);
    }

    @Override
    public String getMessageType() {
        return null;
    }
}
