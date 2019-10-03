package Common;

import org.junit.jupiter.api.Test;

import java.net.BindException;
import java.net.DatagramSocket;
import java.net.InetAddress;

import static org.junit.jupiter.api.Assertions.*;

class CommunicatorTest {

    @Test
    public void constructor1Test() throws Exception {

        Communicator communicator=new Communicator("127.0.0.1",8000);
        assertEquals(8000,communicator.getPortNumber());
        assertEquals(InetAddress.getByName("127.0.0.1"),communicator.getAddress());
    }

    @Test
    public void constructor2Test() throws Exception {
        int portNumber=9000;
        Boolean thrown=false;
        new Communicator(portNumber);

        try {
           new DatagramSocket(portNumber);
        } catch (BindException e) {
            thrown = true;
        }
        assertTrue(thrown);
    }

    @Test
    void testInitiation() throws Exception {
//        Communicator communicator1=new Communicator("127.0.0.1",1234);
//        Communicator communicator2=new Communicator(1234);
//        communicator2.sendSignal("ok");
//        communicator1.initiation();
//        assertEquals("command", communicator2.receiveSignal());
        // communicator2.sendSignal(");
        //assertEquals("ok",communicator1.receiveSignal());
    }

    @Test
    void sendSignal() {
    }

    @Test
    void receiveSignal() {
    }

    @Test
    void getAddress() {
    }

    @Test
    void getPortNumber() {
    }

    @Test
    void setAddress() {
    }
}