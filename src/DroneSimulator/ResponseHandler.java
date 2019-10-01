package DroneSimulator;

import Controller.Communicator;
import Controller.DroneState;

import java.net.InetAddress;

public class ResponseHandler {
    DroneState droneState;
    public ResponseHandler(DroneState droneState) {
        this.droneState=droneState;
    }

    public void handleResponse() throws Exception {
        Communicator communicator = new Communicator(8889);
        while (true) {
            String reply = communicator.receiveSignal();
            System.out.println("Command received:" + reply);
            InetAddress address = communicator.getAddress();
            int portNumber = communicator.getPortNumber();
            communicator.setAddress(address, portNumber);
            MessageManager messageManager = new MessageManager(reply, communicator);
            messageManager.selectMessage();
        }
    }
}
