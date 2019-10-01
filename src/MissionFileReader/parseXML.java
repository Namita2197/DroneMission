package MissionFileReader;
import Controller.DroneState;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

import Controller.Communicator;
import org.xml.sax.SAXException;

public class parseXML extends MissionFileReader {
    @Override
    public void parseFile(Communicator communicator, DroneState droneState) throws Exception {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File("src/Mission2.xml"));
        document.getDocumentElement().normalize();

        NodeList messageList = document.getElementsByTagName("instruction");
        // visitChildNodes(messageList);
        String[] messageArray;
        messageArray = new String[messageList.getLength()];

        for (int temp = 0; temp < messageList.getLength(); temp++) {
            Node node = messageList.item(temp);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                messageArray[temp]=node.getTextContent();
            }
            //String[] messageArray;
            //messageArray = node.getNodeName();
            //Check all attributes
        }
        executeTask(communicator, messageArray, droneState);
    }
}

//