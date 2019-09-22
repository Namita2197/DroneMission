package Controller;

import Mission.DroneFlyBehaviour;
import Mission.MissionFlipForward;
import Mission.MissionFlyBackward;
import Mission.MissionFlyForward;

import java.util.Scanner;

public class Main {

    public static void main(String[] args)throws Exception{
        DroneFlyBehaviour droneFlyBehaviour = null;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter IP Address");
        String iPAddress = scanner.next();

        System.out.println("Enter Port Number");
        int dronePort = scanner.nextInt();

        System.out.println("Enter a number to perform that mission" +
                "\n1.Move Ahead\n2.Move Back\n3.Flip Forward");
        int missionChoice = scanner.nextInt();

        if(missionChoice==1) {
            droneFlyBehaviour =new MissionFlyForward();
        }
        else if(missionChoice==2){
            droneFlyBehaviour = new MissionFlyBackward();
        }
        else if(missionChoice==3){
            droneFlyBehaviour = new MissionFlipForward();
        }
        else{
            System.out.println("INVALID INPUT");
        }

        Flier flier = new Flier();
        flier.initiation(iPAddress,dronePort);
        flier.performMission(droneFlyBehaviour);
    }

}
