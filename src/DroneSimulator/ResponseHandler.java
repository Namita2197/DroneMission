package DroneSimulator;

import Common.Communicator;

public class ResponseHandler {

    Communicator communicator;
    String reply;
    Boolean correctInstruction= false;
    public ResponseHandler(String reply, Communicator communicator){
        this.communicator=communicator;
        this.reply=reply;
    }

    public boolean selectMessage() throws Exception {
       String[] replyArray= reply.split(" ");
//     DroneSimulator droneSimulator= new DroneSimulator();
       if(replyArray[0].equals("takeoff")){
           System.out.println("Drone has taken off");
           correctInstruction= true;
//           communicator.sendSignal("ok");
       }else if(replyArray[0].equals("land")){
           System.out.println("Drone has landed");
           correctInstruction= true;
//           communicator.sendSignal("ok");
       }else if(replyArray[0].equals("forward")){
           System.out.println("Drone has moved forward");
           correctInstruction= true;
//           communicator.sendSignal("ok");
       }else if(replyArray[0].equals("back")){
           System.out.println("Drone has moved backward");
           correctInstruction= true;
//           communicator.sendSignal("ok");
       }else if(replyArray[0].equals("flip")){
           System.out.println("Drone has flipped");
           correctInstruction= true;
//           communicator.sendSignal("ok");
       }else if(replyArray[0].equals("command")){
           System.out.println("Drone in command mode");
           correctInstruction= true;
//           communicator.sendSignal("ok");
       }else if(replyArray[0].equals("battery?")){
            System.out.println("battery query");
           correctInstruction= true;
       }else{
           System.out.println("Unrecognised command");
       }
       if(correctInstruction==true){
           communicator.sendSignal("ok");
       }else{
           communicator.sendSignal("error");
       }
       return correctInstruction;
    }
}
