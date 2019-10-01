package Mission;
import Controller.Communicator;
import Instruction.FlipForward;
import Instruction.Instruction;
import Instruction.Land;
import Instruction.TakeOff;

public class MissionFlipForward extends DroneFlyBehaviour {

    @Override
    public void performMission() throws Exception {
//        Instruction instruction;
//        instruction = new TakeOff();
//        instruction.executeInstruction(communicator);
        instruction = new FlipForward();
        instruction.executeInstruction(communicator,droneState);
//        instruction = new Land();
//        instruction.executeInstruction(communicator);
    }
}
