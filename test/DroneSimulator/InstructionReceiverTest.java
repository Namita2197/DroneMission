package DroneSimulator;

import Common.DroneState;
import Message.Status;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InstructionReceiverTest {
    @Test
    public void testInstructionReceiver(){
        Status status = new Status(20,12,67,18,16,14,12,10,39,66,9,56.89,65,7.9,5.0,8.0);
        DroneState droneState=new DroneState();
        droneState.setInCommandMode(true);
        droneState.updateFlyingInfo(status);
        InstructionReceiver instructionReceiver=new InstructionReceiver();
        assertNotNull(instructionReceiver);
    }

}