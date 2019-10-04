package Controller;

import Common.Communicator;
import Common.DroneState;
import Message.Status;

public class StateReceiver implements Runnable{
    DroneState droneState;
    public StateReceiver(DroneState droneState) {
        this.droneState=droneState;
    }
    public DroneState getDroneState(){
        return droneState;
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
