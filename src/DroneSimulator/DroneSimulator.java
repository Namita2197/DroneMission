package DroneSimulator;

import Controller.Communicator;
import Controller.DroneState;
import Instruction.Status;
import java.net.InetAddress;

public class DroneSimulator{

    public static void main(String[] args) throws Exception {
        DroneState droneState=new DroneState();
        StatePublisher statePublisher=new StatePublisher(droneState);
        Thread thread=new Thread(statePublisher);
        thread.start();
        droneState.setInCommandMode(true);
        ResponseHandler responseHandler= new ResponseHandler(droneState);
        responseHandler.handleResponse();
    }
//
//    public DroneState getDroneState() {
//        return droneState;
//    }



}

