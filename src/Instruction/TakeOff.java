package Instruction;

import Common.Communicator;
import Common.DroneState;

public class TakeOff extends Instruction {

    @Override
    public void executeInstruction(Communicator communicator, DroneState droneState) throws Exception {

        if(droneState.getBatteryPercentage()<=7||droneState.getHighTemperature()>=70){
            System.out.println("Battery Low! or Temperature too high for a flight!\nMission Aborted.");

        }else {
                droneState.setHasTakenOff(true);
            communicator.sendSignal("takeoff");
            System.out.println("takeoff");
            double zCoordinate = 70.00;
            droneState.move(0.00, 0.00, zCoordinate);
            System.out.println(communicator.receiveSignal());
            Thread.sleep(2000);
        }
    }

    @Override
    public String getMessageType() {
        return null;
    }
}
