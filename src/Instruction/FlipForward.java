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
        String direction=sc.next();
        String instruction = "flip "+direction;
        communicator.sendSignal(instruction);
        System.out.println(communicator.receiveSignal());
        Thread.sleep(2000);
    }

    @Override
    public String getMessageType() {
        return null;
    }
}
