package Instruction;

import Controller.Communicator;

import java.util.Scanner;

public class ShiftBackward extends Instruction {
//    public ShiftBackward(Communicator communicator) {
//
//        super(communicator);
//    }
    public void executeInstruction(Communicator communicator) throws  Exception{
        Scanner sc =new Scanner(System.in);
        System.out.print("Enter x cm to move back=");
        int distance=sc.nextInt();
        String instruction = "back "+distance;
        communicator.sendSignal(instruction);
        Thread.sleep(2000);
    }
}
