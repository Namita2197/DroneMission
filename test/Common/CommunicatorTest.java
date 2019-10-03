package Common;

import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;
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
    public void testCommunicatorAndDummyServer() throws InterruptedException {

        Thread droneThread = new Thread(new CommandThread());
        Thread serverThread = new Thread(new ServerThread());
        droneThread.start();
        Thread.sleep(3000);
        serverThread.start();
    }

    @Test
    public void testSetAddressandPortNumber() throws Exception {

        Communicator communicator=new Communicator("127.0.0.1",8889);
        InetAddress newAddress =InetAddress.getByName("127.0.0.2");
        int newPort =3000;
        communicator.setAddress(newAddress,newPort);
        assertEquals(newAddress,communicator.getAddress());
        assertEquals(newPort,communicator.getPortNumber());
    }

    @Test
    public void testSendAndReceiveSignal() throws Exception {

        Communicator sender =new Communicator("127.0.0.1",5000);
        Communicator receiver =new Communicator(5000);
        sender.sendSignal("checking");
        assertEquals("checking",receiver.receiveSignal());
        assertEquals(5000,sender.getPortNumber());
    }

}

class DummyServer{
    public void run() throws Exception {
        byte[] bytesReceived = new byte[64];
        byte[] bytesToSend;
        DatagramSocket server = new DatagramSocket(7000);
        DatagramPacket incomingPacket = new DatagramPacket(bytesReceived, bytesReceived.length);
        try {
            assert server != null;
            server.receive(incomingPacket);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String message = new String(incomingPacket.getData(), 0, incomingPacket.getLength());

        InetAddress ipAddress = incomingPacket.getAddress();
        if (message.equals("command")){
            System.out.println("Command instruction received.");
            bytesToSend = "ok".getBytes(StandardCharsets.UTF_8);
        }
        else {
            System.out.println("No command instruction received.");
            bytesToSend = "error".getBytes(StandardCharsets.UTF_8);
        }
        DatagramPacket sendPacket = new DatagramPacket(bytesToSend, bytesToSend.length, ipAddress, incomingPacket.getPort());
        try {
            server.send(sendPacket);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(" Ok/Error sent back");
    }
}

class ServerThread implements Runnable {
    @Override
    public void run() {
        DummyServer server = new DummyServer();
        try {
            server.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class CommandThread implements Runnable {
    @Override
    public void run() {
        String ipAddress = "127.0.0.1";
        int port = 6000;

        Communicator communicator = null;
        try {
            communicator = new Communicator(ipAddress, port);
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            communicator.sendSignal("command");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}