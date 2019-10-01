package Instruction;

import Common.Communicator;
import Common.DroneState;

import java.util.Scanner;

public class ShiftForward extends Instruction {

    @Override
    public void executeInstruction(Communicator communicator, DroneState droneState) throws Exception {
        Scanner sc =new Scanner(System.in);
        System.out.print("Enter x cm to move forward=");

        int distance=sc.nextInt();
        String instruction = "forward "+distance;
        communicator.sendSignal(instruction);
        System.out.println(communicator.receiveSignal());
        droneState.move(0,distance,0);
        Thread.sleep(2000);
    }

    @Override
    public String getMessageType() {
        return null;
    }
}
