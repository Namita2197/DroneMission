package Controller;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketTimeoutException;
import java.nio.charset.StandardCharsets;

public class Communicator {

    private int dronePort;
    private InetAddress droneAddress;
    private String iPAddress;

    DatagramSocket udpClient;
    byte[] bytesToSent;
    byte[] bytesReceived;

    private String reply = null;

    public Communicator(String iPAddress,int dronePort){
        this.iPAddress=iPAddress;
        this.dronePort=dronePort;
    }

//    public int getLocalPort()
//    {
//        return udpClient.getLocalPort();
//    }

    public void initiation()throws Exception{
        droneAddress = InetAddress.getByName(iPAddress);
        udpClient=new DatagramSocket();
        udpClient.setSoTimeout(1000);

        System.out.println("Put drone in command mode...");
        int maxRetries = 3;
        while (maxRetries > 0) {
            sendSignal("command");
            reply = receiveSignal();
            if (reply.equals("ok")) {
                break;
            }
            System.out.println("Remaining retries: " + maxRetries);
            maxRetries--;
        }
        if (reply == null || !reply.equals("ok"))
            return;

    }
    public String getIPAddress(){
        return iPAddress;
    }
    public int getDronePort()
    {
        return dronePort;
    }

    public InetAddress getDroneAddress(){
        return droneAddress;
    }


    public void sendSignal(String request) throws Exception{
        bytesToSent = request.getBytes(StandardCharsets.UTF_8);
        DatagramPacket datagramPacket = new DatagramPacket(bytesToSent, bytesToSent.length, droneAddress, dronePort);
        udpClient.send(datagramPacket);
        System.out.println("Sent " + request + " bytes to " + droneAddress.toString() + ":" + dronePort);
    }



    public String receiveSignal() throws Exception{
        bytesReceived = new byte[64];
        DatagramPacket datagramPacket = new DatagramPacket(bytesReceived, 64);
        try {
            udpClient.receive(datagramPacket);
        }
        catch (SocketTimeoutException ex) {
            datagramPacket = null;
        }
        if (datagramPacket != null) {
            System.out.println(String.format("Received %d bytes", datagramPacket.getLength()));
            reply = new String(bytesReceived, 0, datagramPacket.getLength(), StandardCharsets.UTF_8);
        }
        return reply;
    }

}
