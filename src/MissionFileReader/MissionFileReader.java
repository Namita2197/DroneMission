package MissionFileReader;

import Common.Communicator;
import Common.DroneState;
import Instruction.Instruction;
import Instruction.*;

abstract public class MissionFileReader {

    public abstract void parseFile(Communicator communicator, DroneState droneState) throws Exception;

    public Instruction[] executeTask(String[] messageArray, DroneState droneState){
        Instruction taskArray[] = new Instruction[messageArray.length];
        for (int i = 0; i < messageArray.length; i++) {
            if (messageArray[i].equals("takeoff")) {   //intstruction.createMeassageList
                droneState.setHasTakenOff(true);
                taskArray[i] = new TakeOff();
            } else if (messageArray[i].equals("land")) {
                taskArray[i] = new Land();
            } else if (messageArray[i].equals("back")) {
                taskArray[i] = new ShiftBackward();
            } else if (messageArray[i].equals("forward")) {
                taskArray[i] = new ShiftForward();
            } else if (messageArray[i].equals("battery?")) {
                taskArray[i] = new Battery();
            } else if (messageArray[i].equals("flip")) {
                taskArray[i] = new FlipForward();
            }
        }
        return taskArray;
    }
}

