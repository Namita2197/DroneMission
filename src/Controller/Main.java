package Controller;

import MissionFileReader.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)throws Exception{

        MissionFileReader missionFileReader;
        DroneState droneState=new DroneState();
        Flier flier = new Flier(droneState);
        Thread thread=new Thread(flier);
        Scanner scanner = new Scanner(System.in);
      
        System.out.println("Enter IP Address");
        String iPAddress = scanner.next();

        System.out.println("Enter Port Number");
        int dronePort = scanner.nextInt();

        flier.initiation(iPAddress,dronePort);
        thread.start();

        Thread.sleep(4000);
        System.out.println("Choose the file you have set your mission in"+"\n1.XML\n2.CSV\nor\n3. Run pre-existing mission ");
        int fileType= scanner.nextInt();
        if(fileType==1){
            missionFileReader =new parseXML();
            flier.parseFile(missionFileReader);
        }else if(fileType==2){
            missionFileReader =new parseCSV();
            flier.parseFile(missionFileReader);
        }else if(fileType==3){
            System.out.println("Choose any mission:\n1.Make the drone flip forward\n2.Make the drone fly backwards\n3.Make the drone fly forward");
            int missionNumber=scanner.nextInt();
            flier.performExistingMission(missionNumber);
        }else{
            System.out.println("INVALID INPUT");
        }
    }
}
