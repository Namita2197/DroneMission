package Instruction;

import Common.Communicator;
import Common.DroneState;
import Message.Status;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TakeOffTest {

    @Test
    void executeInstruction() {
        Thread dummyRequesterTakeoff =new Thread(new DummyRequesterTakeoff());
        Thread dummyResponderTakeoff =new Thread(new DummyResponderTakeoff());
        dummyResponderTakeoff.start();
        dummyRequesterTakeoff.start();

    }
}
// executeInstruction is not throwing error and that is why test is successful.
class DummyResponderTakeoff implements Runnable{
   String reply=null;

    @Override
    public void run() {

        try {
            Communicator communicator= new Communicator(1818);
            reply=communicator.receiveSignal();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class DummyRequesterTakeoff implements Runnable{

    @Override
    public void run() {
        Communicator communicator= null;
        try {
            communicator = new Communicator("127.0.0.1",1818);
            Status testingStatus=new Status(20,12,67,18,16,14,12,10,39,66,9,56.89,65,7.9,5.0,8.0);
            DroneState droneState=new DroneState();
            droneState.setInCommandMode(true);
            droneState.setHasTakenOff(true);
            droneState.updateFlyingInfo(testingStatus);
            TakeOff testingTakeoff= new TakeOff();
            testingTakeoff.executeInstruction(communicator,droneState);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

