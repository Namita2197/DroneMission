package Controller;

import Mission.DroneFlyBehaviour;
//import MissionFileReader;
import Mission.MissionFlipForward;
import Mission.MissionFlyBackward;
import Mission.MissionFlyForward;
import MissionFileReader.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args)throws Exception{
        //DroneFlyBehaviour droneFlyBehaviour = null;
        MissionFileReader missionFileReader=null;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter IP Address");
        String iPAddress = scanner.next();

        System.out.println("Enter Port Number");
        int dronePort = scanner.nextInt();
        System.out.println("Choose the file format you want to read the mission from"+"\n1.XML\n2.CSV");
        int fileType= scanner.nextInt();

        if(fileType==1){
            missionFileReader =new parseXML();
        }else if(fileType==2){
            missionFileReader =new parseCSV();
        }else{
            System.out.println("INVALID INPUT");
        }


//        System.out.println("Enter a number to perform that mission" +
//                "\n1.Move Ahead\n2.Move Back\n3.Flip Forward");
//        int missionChoice = scanner.nextInt();
//
//        if(missionChoice==1) {
//            droneFlyBehaviour =new MissionFlyForward();
//        }
//        else if(missionChoice==2){
//            droneFlyBehaviour = new MissionFlyBackward();
//        }
//        else if(missionChoice==3){
//            droneFlyBehaviour = new MissionFlipForward();
//        }
//        else{
//            System.out.println("INVALID INPUT");
//        }

        Flier flier = new Flier();
        Thread thread=new Thread(flier);
        flier.initiation(iPAddress,dronePort);
        thread.start();
       // flier.performMission(droneFlyBehaviour);
        flier.parseFile(missionFileReader);
    }

}
