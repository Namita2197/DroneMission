package Instruction;

import Common.Communicator;
import Common.DroneState;
import Message.Status;
import org.junit.jupiter.api.Test;

import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

import static org.junit.jupiter.api.Assertions.*;

class BatteryTest {

    @Test
    void executeInstruction() throws Exception {
    Thread dummyRequester =new Thread(new DummyRequester());
    Thread dummyResponder =new Thread(new DummyResponder());
    dummyResponder.start();
    dummyRequester.start();

    }
}

class DummyResponder implements Runnable{
    String response=null;

    @Override
    public void run() {

        try {
            Communicator communicator= new Communicator(1111);
            String reply=communicator.receiveSignal();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class DummyRequester implements Runnable{

    @Override
    public void run() {
        Communicator communicator= null;
        try {
            communicator = new Communicator("127.0.0.1",1111);
            Status testingStatus=new Status(20,12,67,18,16,14,12,10,39,66,9,56.89,65,7.9,5.0,8.0);
            DroneState droneState=new DroneState();
            droneState.setInCommandMode(true);
            droneState.setHasTakenOff(true);
            droneState.updateFlyingInfo(testingStatus);
            Battery testingBattery= new Battery();
            testingBattery.executeInstruction(communicator,droneState);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}