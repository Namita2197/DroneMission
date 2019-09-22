package Controller;

import Mission.DroneFlyBehaviour;
import Mission.MissionFlipForward;
import Mission.MissionFlyBackward;
import Mission.MissionFlyForward;


public class Flier {

//    private DroneFlyBehaviour droneFlyBehaviour;
    Communicator communicator;


    public void initiation(String iPAddress,int dronePort) throws Exception {
        communicator= new Communicator(iPAddress,dronePort);
        communicator.initiation();
//        this.droneFlyBehaviour=droneFlyBehaviour;
    }
    public void performMission(DroneFlyBehaviour droneFlyBehaviour) throws Exception {
        droneFlyBehaviour.performMission(communicator);
    }

}
