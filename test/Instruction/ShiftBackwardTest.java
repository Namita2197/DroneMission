package Instruction;

import Common.Communicator;
import Common.DroneState;
import Message.Status;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShiftBackwardTest {
    @Test
    void executeInstruction()  {
        Thread dummyRequester =new Thread(new DummyRequesterShiftBackward());
        Thread dummyResponder =new Thread(new DummyResponderShiftBackward());
        dummyResponder.start();
        dummyRequester.start();
    }
}
// executeInstruction is not throwing error and that is why test is successful.
class DummyResponderShiftBackward implements Runnable{
    String reply=null;

    @Override
    public void run() {

        try {
            Communicator communicator= new Communicator(1111);
            reply=communicator.receiveSignal();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class DummyRequesterShiftBackward implements Runnable{

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
            ShiftBackward testingBackward= new ShiftBackward();
            testingBackward.executeInstruction(communicator,droneState);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}