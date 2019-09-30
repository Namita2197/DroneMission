package Controller;

import java.net.*;
import java.nio.charset.StandardCharsets;

public class Communicator {

    private int portNumber;
    private InetAddress address;
    private String iPAddress;

    DatagramSocket udpClient;
    byte[] bytesToSent;
    byte[] bytesReceived;

    private String reply = null;

    public Communicator(String iPAddress,int portNumber) throws Exception {
        this.iPAddress=iPAddress;
        this.portNumber=portNumber;
        address = InetAddress.getByName(iPAddress);
        udpClient=new DatagramSocket();
        udpClient.setSoTimeout(1000);
    }

    public Communicator(int portNumber)throws Exception{
        udpClient=new DatagramSocket(portNumber);
    }

//    public int getLocalPort()
//    {
//        return udpClient.getLocalPort();
//    }

    public void initiation()throws Exception{




        //System.out.println("Put drone in command mode...");
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
//    public String getIPAddress(){
//        return iPAddress;
//    }
//    public int getDronePort()
//    {
//        return dronePort;
//    }
//
//    public InetAddress getDroneAddress(){
//        return droneAddress;
//    }


    public void sendSignal(String request) throws Exception{
        bytesToSent = request.getBytes(StandardCharsets.UTF_8);
        DatagramPacket datagramPacket = new DatagramPacket(bytesToSent, bytesToSent.length, address, portNumber);
        udpClient.send(datagramPacket);
//        System.out.println("Sent " + request + " bytes to " + address.toString() + ":" + portNumber);
    }



    public String receiveSignal() throws Exception{
        bytesReceived = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(bytesReceived, 1024);
        try {
            udpClient.receive(datagramPacket);
            this.address=datagramPacket.getAddress();
            this.portNumber=datagramPacket.getPort();

        }
        catch (SocketTimeoutException ex) {
            datagramPacket = null;
        }
        if (datagramPacket != null) {
//            System.out.println(String.format("Received %d bytes", datagramPacket.getLength()));
            reply = new String(bytesReceived, 0, datagramPacket.getLength(), StandardCharsets.UTF_8);
        }
        return reply;
    }
    public InetAddress getAddress(){
        return address;
    }
    public int getPortNumber(){
        return portNumber;
    }
    public void setAddress(InetAddress address, int portNumber){
        this.portNumber=portNumber;
        this.address=address;
    }

}
