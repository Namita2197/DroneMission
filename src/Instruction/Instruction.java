package Instruction;
import Common.Communicator;
import Common.DroneState;
abstract public class Instruction {

    public abstract void executeInstruction(Communicator communicator, DroneState droneState) throws Exception;



}
