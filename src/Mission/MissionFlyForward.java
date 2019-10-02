package Mission;

import Instruction.ShiftForward;

public class MissionFlyForward extends DroneFlyBehaviour {

    @Override
    public void performMission() throws Exception {
        instruction= new ShiftForward();
        instruction.executeInstruction(communicator,droneState);
    }
}
