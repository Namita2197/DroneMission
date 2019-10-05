package Mission;

import Common.Communicator;
import Common.DroneState;
import Controller.InstructionSender;
import org.junit.jupiter.api.Test;

class MissionFlyBackwardTest {
    @Test
    public void FlyBackwardTest() throws Exception {

        DummyServerBackward dummyServer=new DummyServerBackward();
        DummyClientBackward dummyClient=new DummyClientBackward();
        Thread testingThread=new Thread(dummyServer);
        Thread testingThread2=new Thread(dummyClient);
        testingThread.start();
        testingThread2.start();
    }
}
class DummyServerBackward implements Runnable{

    @Override
    public void run() {

        try {
            Communicator testCommunicator=new Communicator(4444);
            testCommunicator.receiveSignal();
            testCommunicator.setAddress(testCommunicator.getAddress(),testCommunicator.getPortNumber());
            testCommunicator.sendSignal("ok");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
class DummyClientBackward implements Runnable{

    @Override
    public void run() {

        try {
            DroneState testDroneState=new DroneState();
            InstructionSender testingInstructionSender=new InstructionSender(testDroneState);
            testingInstructionSender.initiation("127.0.0.1",4444);
            testingInstructionSender.performExistingMission(2);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}


