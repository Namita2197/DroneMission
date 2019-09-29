package Instruction;

import Controller.Communicator;

import java.util.Scanner;

public class ShiftForward extends Instruction {
    //public ShiftForward(Communicator communicator) {
       // super(communicator);
   // }

    @Override
    public void executeInstruction(Communicator communicator) throws Exception {
        Scanner sc =new Scanner(System.in);
        System.out.print("Enter x cm to move forward=");
        int distance=sc.nextInt();
        String instruction = "forward "+distance;
        communicator.sendSignal(instruction);
        Thread.sleep(2000);
    }
}
