package DroneSimulator;

import Common.Communicator;

public class ResponseHandler {

    Communicator communicator;
    String reply;

    public ResponseHandler(String reply, Communicator communicator){
        this.communicator=communicator;
        this.reply=reply;
    }

    public void selectMessage() throws Exception {
       String[] replyArray= reply.split(" ");
       DroneSimulator droneSimulator= new DroneSimulator();
       if(replyArray[0].equals("takeoff")){
           System.out.println("Drone has taken off");
           communicator.sendSignal("ok");
       }else if(replyArray[0].equals("land")){
           System.out.println("Drone has landed");
           communicator.sendSignal("ok");
       }else if(replyArray[0].equals("forward")){
           System.out.println("Drone has moved forward");
           communicator.sendSignal("ok");
       }else if(replyArray[0].equals("back")){
           System.out.println("Drone has moved backward");
           communicator.sendSignal("ok");
       }else if(replyArray[0].equals("flip")){
           System.out.println("Drone has flipped");
           communicator.sendSignal("ok");
       }else if(replyArray[0].equals("command")){
           System.out.println("Drone in command mode");
           communicator.sendSignal("ok");
       }else if(replyArray[0].equals("battery?")){
            System.out.println("battery query");
            communicator.sendSignal("ok");
       }else{
           System.out.println("Unrecognised command");
           communicator.sendSignal("error");
       }
    }
}
