package Mission;
import Instruction.FlipForward;

public class MissionFlipForward extends DroneFlyBehaviour {

    @Override
    public void performMission() throws Exception {
        instruction = new FlipForward();
        instruction.executeInstruction(communicator,droneState);
    }
}
