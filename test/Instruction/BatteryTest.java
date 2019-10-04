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

        Communicator communicator=new Communicator("127.0.0.1",1111);
        Status testingStatus=new Status(20,12,67,18,16,14,12,10,39,66,9,56.89,65,7.9,5.0,8.0);
        DroneState droneState=new DroneState();
        droneState.setInCommandMode(true);
        droneState.setHasTakenOff(true);
        droneState.updateFlyingInfo(testingStatus);
        Battery testingBattery= new Battery();
        testingBattery.executeInstruction(communicator,droneState);
    }
}

//class DummyResponder{
//    String response=null;
//    public void testDummyresponder()throws Exception{
//       Communicator communicator= new Communicator(1111);
//       String reply=communicator.receiveSignal();
//    }
//}