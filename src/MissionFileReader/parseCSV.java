package MissionFileReader ;

import Common.Communicator;
import Common.DroneState;

import java.io.BufferedReader;
import java.io.FileReader;

public class parseCSV extends MissionFileReader{

    @Override
    public void parseFile(Communicator communicator, DroneState droneState) throws Exception {

        BufferedReader br =new BufferedReader(new FileReader("src/Mission1.csv"));
        String fileData;
        fileData=br.readLine();
        String[] messageArray =fileData.split(",");
        executeTask(communicator,messageArray, droneState);
    }
}
