package DroneSimulator;

import Common.DroneState;

public class DroneSimulator{

    public static void main(String[] args) throws Exception {
        DroneState droneState=new DroneState();
        StatePublisher statePublisher=new StatePublisher(droneState);
        Thread thread=new Thread(statePublisher);
        thread.start();
        droneState.setInCommandMode(true);
        InstructionReceiver instructionReceiver = new InstructionReceiver();
        instructionReceiver.receiveInstruction();
    }
}

