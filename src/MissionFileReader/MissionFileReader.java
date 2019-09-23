package MissionFileReader;

import Controller.Communicator;
import Instruction.Instruction;
import Instruction.*;
import java.io.FileNotFoundException;
import java.io.IOException;

abstract public class MissionFileReader {

    public abstract void parseFile(Communicator communicator) throws Exception;
    public void executeTask(Communicator communicator, String[] messageArray) throws Exception {
        Instruction instruction;
        for(int i=0; i<messageArray.length; i++){
            if(messageArray[i].equals("takeoff")){
                instruction= new TakeOff();
                instruction.executeInstruction(communicator);
            } else if(messageArray[i].equals("land")){
                instruction= new Land();
                instruction.executeInstruction(communicator);
            }else if(messageArray[i].equals("back 25")){
                instruction= new ShiftBackward();
                instruction.executeInstruction(communicator);
            } else if(messageArray[i].equals("forward 25")){
                instruction= new ShiftForward();
                instruction.executeInstruction(communicator);
            }
        }
    }

}
