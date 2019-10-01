package Controller;

import Instruction.Status;
//import Mission.DroneFlyBehaviour;
//import Mission.MissionFlipForward;
//import Mission.MissionFlyBackward;
//import Mission.MissionFlyForward;
import Mission.DroneFlyBehaviour;
import Mission.MissionFlipForward;
import Mission.MissionFlyBackward;
import Mission.MissionFlyForward;
import MissionFileReader.MissionFileReader;


public class Flier implements Runnable{

//    private DroneFlyBehaviour droneFlyBehaviour;
    Communicator communicator;
    Status status;
    DroneState droneState;
    DroneFlyBehaviour droneFlyBehaviour;
    public Flier(DroneState droneState){
        this.droneState=droneState;
    }
    //thread.start();


    public void initiation(String iPAddress,int dronePort) throws Exception {
        communicator= new Communicator(iPAddress,dronePort);
        communicator.initiation();
        droneState.setInCommandMode(true);
//        this.droneFlyBehaviour=droneFlyBehaviour;
    }

    public void performExistingMission(int missionNumber){

        if(missionNumber==1) {
            droneFlyBehaviour =new MissionFlipForward();
        }
        else if(missionNumber==2){
            droneFlyBehaviour = new MissionFlyBackward();
        }
        else if(missionNumber==3){
            droneFlyBehaviour = new MissionFlyForward();
        }
        droneFlyBehaviour.setCommunicator(communicator);
        droneFlyBehaviour.setDroneState(droneState);
        droneFlyBehaviour.missionTemplate();



    }

//    public void performMission(DroneFlyBehaviour droneFlyBehaviour) throws Exception {
//        droneFlyBehaviour.performMission(communicator);
//    }

    public void parseFile(MissionFileReader missionFileReader) throws Exception {
        missionFileReader.parseFile(communicator,droneState);
    }

    @Override
    public void run() {
        Communicator communicator= null;
        //Status status;
        try {
            communicator = new Communicator(8890);
            while(true) {
                String updatedStatus = communicator.receiveSignal();
                //status.parseData(updatedStatus);
                this.status = new Status(updatedStatus);
                droneState.updateFlyingInfo(status);
//                System.out.println(status.getBatteryPercentage());
                Thread.sleep(100);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
