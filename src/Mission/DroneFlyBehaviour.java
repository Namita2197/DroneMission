package Mission;

import Controller.Communicator;
import Controller.DroneState;
import Instruction.*;

public abstract class DroneFlyBehaviour {

    Communicator communicator;
    DroneState droneState;
    Instruction instruction;

    public void setCommunicator(Communicator communicator){
        this.communicator=communicator;
    }
    public void setDroneState(DroneState droneState){
        this.droneState=droneState;
    }

    public final void missionTemplate() throws Exception {
        droneTakeoff();
        performMission();
        droneLanding();
    }
    public void droneTakeoff() throws Exception {

        if (droneState.getBatteryPercentage() <= 7 || droneState.getHighTemperature() >= 70) {
            System.out.println("Battery Low! or Temperature too high for a flight!\nMission Aborted.");
        } else {
            droneState.setHasTakenOff(true);
            instruction = new TakeOff();
            instruction.executeInstruction(communicator, droneState);
        }
    }
    public abstract void performMission() throws Exception;

    public void droneLanding() throws Exception {
        instruction = new Land();
        instruction.executeInstruction(communicator, droneState);
    }
}

