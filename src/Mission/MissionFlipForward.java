package Mission;
import Instruction.FlipForward;

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
