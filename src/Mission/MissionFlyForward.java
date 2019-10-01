package Mission;

import Instruction.ShiftForward;

public class MissionFlyForward extends DroneFlyBehaviour {

    @Override
    public void performMission() throws Exception {
//        Instruction instruction;
//        instruction= new TakeOff();
//        instruction.executeInstruction(communicator);
        instruction= new ShiftForward();
        instruction.executeInstruction(communicator,droneState);
//        instruction=new Land();
//        instruction.executeInstruction(communicator);
    }
}
