package Instruction;
import Common.Communicator;
import Common.DroneState;
abstract public class Instruction {

    public abstract void executeInstruction(Communicator communicator, DroneState droneState) throws Exception;

    public abstract String getMessageType();

    protected String getMessageText() { return getMessageType(); }

    @Override
    public String toString() {
        return String.format("%s %s", this.getClass().getSimpleName(), getMessageText());
    }

}
