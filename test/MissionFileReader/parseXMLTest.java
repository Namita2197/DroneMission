package MissionFileReader;

import Common.Communicator;
import Common.DroneState;
import Controller.InstructionSender;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class parseXMLTest {
    @Test
    public void  XMLTest(){
        DummyServerXML dummyServer=new DummyServerXML();
        DummyClientXML dummyClient=new DummyClientXML();
        Thread testingThread=new Thread(dummyServer);
        Thread testingThread2=new Thread(dummyClient);
        testingThread.start();
        testingThread2.start();
    }

}
class DummyServerXML implements Runnable{

    @Override
    public void run() {

        try {
            Communicator testCommunicator=new Communicator(8133);
            testCommunicator.receiveSignal();
            testCommunicator.setAddress(testCommunicator.getAddress(),testCommunicator.getPortNumber());
            testCommunicator.sendSignal("ok");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
class DummyClientXML implements Runnable{
    @Test
    @Override
    public void run() {

        try {
            DroneState droneStateTest=new DroneState();
            InstructionSender instructionSender=new InstructionSender(droneStateTest);
            instructionSender.initiation("127.0.0.1",8133);
            MissionFileReader missionFileReader;
            missionFileReader =new parseXML();
            instructionSender.parseFile(missionFileReader);

            assertNotNull(missionFileReader);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}