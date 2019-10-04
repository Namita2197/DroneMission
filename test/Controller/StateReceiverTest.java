package Controller;

import Common.Communicator;
import Common.DroneState;
import DroneSimulator.StatePublisher;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StateReceiverTest {
    @Test
    public void testStateReceiver(){
        DroneState testDroneState=new DroneState();
        StatePublisher statePublisher=new StatePublisher(testDroneState);
        StateReceiver stateReceiver =new StateReceiver(testDroneState);
        Thread threadPublisher=new Thread(statePublisher);
        Thread threadReceiver=new Thread(stateReceiver);
        threadPublisher.start();
        threadReceiver.start();
        assertEquals(statePublisher.getDroneState(),stateReceiver.getDroneState());
    }
}