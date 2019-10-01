package Mission;

import Controller.Communicator;
import Controller.DroneState;
import Instruction.Instruction;

public abstract class DroneFlyBehaviour {

    Instruction instruction;
    Communicator communicator;
    DroneState droneState;
    public DroneFlyBehaviour(){

    }
    public void setCommunicator(Communicator communicator){
        this.communicator=communicator;
    }
    public void setDroneState(DroneState droneState){
        this.droneState=droneState;
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
