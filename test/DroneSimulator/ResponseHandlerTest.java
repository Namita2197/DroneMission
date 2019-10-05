package DroneSimulator;

import Common.Communicator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ResponseHandlerTest {

    @Test
    public void testResponseHandler() throws Exception {
        Communicator communicator=new Communicator("127.0.0.1",8787);
        ResponseHandler responseHandler=new ResponseHandler("takeoff",communicator);
        responseHandler.selectMessage();
        assertTrue(responseHandler.selectMessage());
    }

}