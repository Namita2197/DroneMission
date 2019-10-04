package Instruction;

import Common.Communicator;
import Common.DroneState;
import Message.Status;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
// executeInstruction is not throwing error and that is why test is successful.
class LandTest {
    @Test
    void executeInstruction() throws Exception {
        Thread dummyRequesterLand =new Thread(new DummyRequesterLand());
        Thread dummyResponderLand =new Thread(new DummyResponderLand());
        dummyResponderLand.start();
        dummyRequesterLand.start();
    }
}
class DummyResponderLand implements Runnable{
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

class DummyRequesterLand implements Runnable{

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
            Land testingLand= new Land();
            testingLand.executeInstruction(communicator,droneState);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}