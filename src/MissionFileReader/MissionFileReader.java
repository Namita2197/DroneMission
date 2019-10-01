package MissionFileReader;

import Controller.Communicator;
import Controller.DroneState;
import Instruction.Instruction;
import Instruction.*;

abstract public class MissionFileReader {

    public abstract void parseFile(Communicator communicator, DroneState droneState) throws Exception;
    public void executeTask(Communicator communicator, String[] messageArray, DroneState droneState) throws Exception {
        Instruction instruction;

        for(int i=0; i<messageArray.length; i++) {
            if(droneState.getBatteryPercentage()<=7||droneState.getHighTemperature()>=70){
                if(droneState.hasTakenOff()==true){
                        System.out.println("Low Battery!\nDrone is landing now...");
                        instruction = new Land();
                        instruction.executeInstruction(communicator,droneState);
                }else{
                        System.out.println("Battery Low! or Temperature too high for a flight!\nMission Aborted.");
                }
                break;
            }else{
                    System.out.println(messageArray[i]);
                    if (messageArray[i].equals("takeoff")) {//intstruction.createMeassageList
                        droneState.setHasTakenOff(true);
                        instruction = new TakeOff();
                        instruction.executeInstruction(communicator,droneState);
                    } else if (messageArray[i].equals("land")) {
                        instruction = new Land();
                        instruction.executeInstruction(communicator,droneState);
                    } else if (messageArray[i].equals("back")) {
                        instruction = new ShiftBackward();
                        instruction.executeInstruction(communicator,droneState);
                    } else if (messageArray[i].equals("forward")) {
                        instruction = new ShiftForward();
                        instruction.executeInstruction(communicator,droneState);
                    } else if (messageArray[i].equals("battery?")) {
                        instruction = new Battery();
                        instruction.executeInstruction(communicator,droneState);

                    } else if (messageArray[i].equals("flip")) {
                        if(droneState.getBatteryPercentage()<=10) {
                            System.out.println("Battery too low to make a flip!");
                            instruction = new ShiftForward();
                            instruction.executeInstruction(communicator,droneState);
                        }else{
                            instruction = new FlipForward();
                            instruction.executeInstruction(communicator,droneState);
                        }
                    }
            }
        }

    }

}

