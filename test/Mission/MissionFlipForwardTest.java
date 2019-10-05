package Mission;

import Common.Communicator;
import Common.DroneState;
import Controller.InstructionSender;
import org.junit.jupiter.api.Test;

class MissionFlipForwardTest {

    @Test
    public void MissonFlipTest() throws Exception {

        DummyServerFlip dummyServer=new DummyServerFlip();
        DummyClientFlip dummyClient=new DummyClientFlip();
        Thread testingThread=new Thread(dummyServer);
        Thread testingThread2=new Thread(dummyClient);
        testingThread.start();
        testingThread2.start();
    }
}

class DummyServerFlip implements Runnable{

    @Override
    public void run() {

        try {
            Communicator testCommunicator=new Communicator(6666);
            testCommunicator.receiveSignal();
            testCommunicator.setAddress(testCommunicator.getAddress(),testCommunicator.getPortNumber());
            testCommunicator.sendSignal("ok");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
class DummyClientFlip implements Runnable{

    @Override
    public void run() {

        try {
            DroneState testDroneState=new DroneState();
            InstructionSender testingInstructionSender=new InstructionSender(testDroneState);
            testingInstructionSender.initiation("127.0.0.1",6666);
            testingInstructionSender.performExistingMission(1);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

