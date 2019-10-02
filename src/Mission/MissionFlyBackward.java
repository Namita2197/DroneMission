package Mission;

import Instruction.ShiftBackward;

public class MissionFlyBackward extends DroneFlyBehaviour {

    @Override
    public void performMission() throws Exception {
        instruction = new ShiftBackward();
        instruction.executeInstruction(communicator,droneState);
    }
}
