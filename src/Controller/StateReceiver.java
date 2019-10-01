package Controller;

import Common.Communicator;
import Common.DroneState;
import Instruction.Status;

public class StateReceiver implements Runnable{
    DroneState droneState;
    public StateReceiver(DroneState droneState) {
        this.droneState=droneState;
    }

    @Override
    public void run() {
        Status status;
        Communicator communicator;
        try {
            communicator = new Communicator(8890);
            while(true) {
                String updatedStatus = communicator.receiveSignal();
                status = new Status(updatedStatus);
                droneState.updateFlyingInfo(status);
                Thread.sleep(100);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
