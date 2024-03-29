package DroneSimulator;

import Common.Communicator;
import Common.DroneState;
import Message.Status;

public class StatePublisher implements Runnable{

    DroneState droneState;

    public StatePublisher(DroneState droneState){
        this.droneState=droneState;
    }
    public DroneState getDroneState(){
        return droneState;
    }

    @Override
    public void run() {
        Communicator communicator=null;
        try {
            communicator=new Communicator("127.0.0.1",8890);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Status status = new Status(20,12,67,18,16,14,12,10,39,66,9,56.89,65,7.9,5.0,8.0);
        droneState.updateFlyingInfo(status);
        String updateStatus=status.getMessageText();
        while(true) {
            try {
                communicator.sendSignal(updateStatus);
                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
