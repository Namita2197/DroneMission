package Mission;

import Common.Communicator;
import Common.DroneState;
import Controller.InstructionSender;
import org.junit.jupiter.api.Test;

class MissionFlyForwardTest {
    @Test
    public void FlyForwardTest() throws Exception {

        DummyServerForward dummyServer=new DummyServerForward();
        DummyClientForward dummyClient=new DummyClientForward();
        Thread testingThread=new Thread(dummyServer);
        Thread testingThread2=new Thread(dummyClient);
        testingThread2.start();
        testingThread.start();

    }
}
class DummyServerForward implements Runnable{

    @Override
    public void run() {

        try {
            Communicator testCommunicator=new Communicator(5555);
            testCommunicator.receiveSignal();
            testCommunicator.setAddress(testCommunicator.getAddress(),testCommunicator.getPortNumber());
            testCommunicator.sendSignal("ok");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
class DummyClientForward implements Runnable{

    @Override
    public void run() {

        try {
            DroneState testDroneState=new DroneState();
            InstructionSender testingInstructionSender=new InstructionSender(testDroneState);
            testingInstructionSender.initiation("127.0.0.1",5555);
            testingInstructionSender.performExistingMission(3);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}