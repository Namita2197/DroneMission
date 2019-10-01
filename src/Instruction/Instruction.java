package Instruction;
import Controller.Communicator;
import Controller.DroneState;
import DroneSimulator.DroneSimulator;

import java.nio.charset.StandardCharsets;

abstract public class Instruction {
    //Communicator communicator;
    //public Instruction(){

      //  this.communicator=communicator;
   // }
    public abstract void executeInstruction(Communicator communicator, DroneState droneState) throws Exception;
    private boolean valid = true;

    public static Instruction decode(byte[] bytes, int offset, int length) {
        Instruction instruction = null;
        if (bytes!=null) {
            length = Math.min(bytes.length, offset + length);

            String data = new String(bytes, offset, length, StandardCharsets.UTF_8);
            data = data.trim();

            if (data.startsWith(Status.getKeyWord()))
                instruction = new Status(data);

            // TODO: decode all of the other kinds of messages based on what the message starts with.  If it doesn't
            //       start with a recognized key work, assume it is an info message (i.e., a reply to a query)
        }
        return instruction;
    }

    public byte[] encode() { return getMessageText().getBytes(StandardCharsets.UTF_8); }

    public abstract String getMessageType();

    protected String getMessageText() { return getMessageType(); }

    public boolean isValid() { return valid; }

    protected void setIsValid(boolean valid) { this.valid = valid; }

    @Override
    public String toString() {
        return String.format("%s %s", this.getClass().getSimpleName(), getMessageText());
    }

}
