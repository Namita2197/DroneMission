package Controller;

import Common.Communicator;
import Common.DroneState;
import Mission.DroneFlyBehaviour;
import Mission.MissionFlipForward;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InstructionSenderTest {

@Test
    public void InstructionSenderTest() throws Exception {

        DroneState testDroneState=new DroneState();
        DummyServer dummyServer=new DummyServer();
        Thread testingThread=new Thread(dummyServer);
        testingThread.start();

        InstructionSender testingInstructionSender=new InstructionSender(testDroneState);
        testingInstructionSender.initiation("127.0.0.1",8890);
        testingInstructionSender.performExistingMission(1);
    }
}
class DummyServer implements Runnable{

    @Override
    public void run() {

        try {
            Communicator testCommunicator=new Communicator(8890);
            testCommunicator.receiveSignal();
            testCommunicator.setAddress(testCommunicator.getAddress(),testCommunicator.getPortNumber());
            testCommunicator.sendSignal("ok");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}