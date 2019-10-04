package Instruction;

import Common.Communicator;
import Common.DroneState;
import Message.Status;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FlipForwardTest {

    @Test
    void executeInstruction() throws Exception {

        Communicator communicator=new Communicator("127.0.0.1",8889);
        Status testingStatus=new Status(20,12,67,18,16,14,12,10,39,66,9,56.89,65,7.9,5.0,8.0);
        DroneState droneState=new DroneState();
        droneState.setInCommandMode(true);
        droneState.setHasTakenOff(true);
        droneState.updateFlyingInfo(testingStatus);
        FlipForward testingFlip= new FlipForward();
        testingFlip.executeInstruction(communicator,droneState);

    }
}