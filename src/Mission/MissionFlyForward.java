package Mission;

import Controller.Communicator;
import Instruction.Instruction;
import Instruction.Land;
import Instruction.ShiftForward;
import Instruction.TakeOff;

public class MissionFlyForward implements DroneFlyBehaviour {

    @Override
    public void performMission(Communicator communicator) throws Exception {
        Instruction instruction;
        instruction= new TakeOff();
        instruction.executeInstruction(communicator);
        instruction= new ShiftForward();
        instruction.executeInstruction(communicator);
        instruction=new Land();
        instruction.executeInstruction(communicator);
    }
}
