package Instruction;
import Controller.Communicator;

abstract public class Instruction {
    //Communicator communicator;
    //public Instruction(){

      //  this.communicator=communicator;
   // }
    public abstract void executeInstruction(Communicator communicator) throws Exception;
 }
