package Mission;

import Controller.Communicator;
import Instruction.Instruction;

public abstract class DroneFlyBehaviour {

    Instruction instruction;
    public DroneFlyBehaviour(){

    }

    public final void missionTemplate(){
        droneTakeoff();
        performMission();
        droneLanding();
    }

    //public void performMission();

    public void droneTakeoff(){

    }
    public abstract void performMission();

    public void droneLanding(){

    }


}
