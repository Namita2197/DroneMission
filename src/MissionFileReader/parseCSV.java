package MissionFileReader ;

import Controller.Communicator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class parseCSV extends MissionFileReader{

    @Override
    public void parseFile(Communicator communicator) throws Exception {

        BufferedReader br =new BufferedReader(new FileReader("src/Mission1.csv"));
        String fileData;
        fileData=br.readLine();
        String[] messageArray =fileData.split(",");
        executeTask(communicator,messageArray);
    }
}
