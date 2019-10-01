package Mission;

import Instruction.ShiftBackward;

public class MissionFlyBackward extends DroneFlyBehaviour {

    @Override
    public void performMission() throws Exception {
//        Instruction instruction;
//        instruction = new TakeOff();
//        instruction.executeInstruction(communicator);
        instruction = new ShiftBackward();
        instruction.executeInstruction(communicator,droneState);
//        instruction = new Land();
//        instruction.executeInstruction(communicator);
    }
}
