package Instruction;

import Controller.Communicator;

import java.util.Scanner;

public class FlipForward extends Instruction {
//    public FlipForward(Communicator communicator) {
//        super(communicator);
//    }

    @Override
    public void executeInstruction(Communicator communicator) throws Exception {
        Scanner sc =new Scanner(System.in);
        System.out.print("Enter the initials of the direction you want to flip towards(l/r/f/b)=");
        int distance=sc.nextInt();
        String instruction = "flip "+distance;
        communicator.sendSignal(instruction);
        Thread.sleep(2000);
    }
}
