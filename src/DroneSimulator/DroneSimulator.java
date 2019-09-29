package DroneSimulator;

import Controller.Communicator;

import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class DroneSimulator {
    public static void main(String[] args) throws Exception {
        Communicator communicator=new Communicator(8889);
        while(true) {
            String reply = communicator.receiveSignal();
            System.out.println(reply);
            InetAddress address = communicator.getAddress();
            int portNumber = communicator.getPortNumber();
            communicator.setAddress(address, portNumber);
            communicator.sendSignal("ok");
        }
    }


}
