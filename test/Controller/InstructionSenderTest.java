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

        DummyServer dummyServer=new DummyServer();
        DummyClient dummyClient=new DummyClient();
        Thread testingThread=new Thread(dummyServer);
        Thread testingThread2=new Thread(dummyClient);
        testingThread.start();
        testingThread2.start();
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
class DummyClient implements Runnable{

    @Override
    public void run() {

        try {
            DroneState testDroneState=new DroneState();
            InstructionSender testingInstructionSender=new InstructionSender(testDroneState);
            testingInstructionSender.initiation("127.0.0.1",8890);
            testingInstructionSender.performExistingMission(1);
            testingInstructionSender.performExistingMission(2);
            testingInstructionSender.performExistingMission(3);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}