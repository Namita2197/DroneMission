package DroneSimulator;

import Controller.Communicator;
import Instruction.Status;
import Mission.DroneFlyBehaviour;

import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class DroneSimulator implements Runnable {
    public static void main(String[] args) throws Exception {
        DroneSimulator droneSimulator=new DroneSimulator();
        Thread thread=new Thread(droneSimulator);
        thread.start();
        Communicator communicator=new Communicator(8889);
        while(true) {
            String reply = communicator.receiveSignal();
            System.out.println("Command received:"+reply);
            InetAddress address = communicator.getAddress();
            int portNumber = communicator.getPortNumber();
            communicator.setAddress(address, portNumber);
            //communicator.sendSignal("ok");
            MessageManager messageManager=new MessageManager(reply,communicator);
            messageManager.selectMessage();
        }
    }


    @Override
    public void run() {
        Communicator communicator=null;
        try {
            communicator=new Communicator("127.0.0.1",8890);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Status status = new Status(20,12,67,18,16,14,12,60,39,66,80,56.89,65,7.9,5.0,8.0);
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

