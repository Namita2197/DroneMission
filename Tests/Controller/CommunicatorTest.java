package Controller;

import org.junit.jupiter.api.Test;

import java.net.InetAddress;

import static org.junit.jupiter.api.Assertions.*;

class CommunicatorTest {
Communicator communicator;
    @Test
    public void constructorTest() throws Exception {

        communicator=new Communicator("127.0.0.1",8889);
        assertEquals(8889,communicator.getDronePort());
        assertEquals("127.0.0.1",communicator.getIPAddress());
        //assertEquals("ok",communicator.receiveSignal());
    }
    @Test
    public void initiationTest()throws Exception{
        communicator=new Communicator("127.0.0.1",8889);
        communicator.initiation();
        assertEquals(InetAddress.getByName("127.0.0.1"),communicator.getDroneAddress());
    }


}