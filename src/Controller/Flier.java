package Controller;

import Mission.DroneFlyBehaviour;
import Mission.MissionFlipForward;
import Mission.MissionFlyBackward;
import Mission.MissionFlyForward;
import MissionFileReader.MissionFileReader;


public class Flier implements Runnable{

//    private DroneFlyBehaviour droneFlyBehaviour;
    Communicator communicator;

    //thread.start();


    public void initiation(String iPAddress,int dronePort) throws Exception {
        communicator= new Communicator(iPAddress,dronePort);
        communicator.initiation();
//        this.droneFlyBehaviour=droneFlyBehaviour;
    }
//    public void performMission(DroneFlyBehaviour droneFlyBehaviour) throws Exception {
//        droneFlyBehaviour.performMission(communicator);
//    }

    public void parseFile(MissionFileReader missionFileReader) throws Exception {
        missionFileReader.parseFile(communicator);
    }

    @Override
    public void run() {
        

    }
}
