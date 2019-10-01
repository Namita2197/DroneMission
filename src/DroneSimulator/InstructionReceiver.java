package DroneSimulator;

import Common.Communicator;

import java.net.InetAddress;

public class InstructionReceiver {
//    DroneState droneState;
//    public InstructionReceiver(DroneState droneState) {
//        this.droneState=droneState;
//    }

    public void receiveInstruction() throws Exception {
        Communicator communicator = new Communicator(8889);
        while (true) {
            String reply = communicator.receiveSignal();
            System.out.println("Command received:" + reply);
            InetAddress address = communicator.getAddress();
            int portNumber = communicator.getPortNumber();
            communicator.setAddress(address, portNumber);
            ResponseHandler responseHandler = new ResponseHandler(reply, communicator);
            responseHandler.selectMessage();
        }
    }
}
