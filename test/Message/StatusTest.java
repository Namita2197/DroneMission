package Message;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StatusTest {
    Status statusTest = new Status(20,12,67,18,16,14,12,10,39,66,9,56.89,65,7.9,5.0,8.0);

    @Test
    public void testAllGetter(){

        assertEquals(statusTest.getPitch(),20);
        assertEquals(statusTest.getRoll(),12);
        assertEquals(statusTest.getYaw(),67);
        assertEquals(statusTest.getSpeedX(),18);
        assertEquals(statusTest.getSpeedY(),16);
        assertEquals(statusTest.getSpeedZ(),14);
        assertEquals(statusTest.getAccelerationX(),7.9);
        assertEquals(statusTest.getAccelerationY(),5.0);
        assertEquals(statusTest.getAccelerationZ(),8.0);
        assertEquals(statusTest.getLowTemperature(),12);
        assertEquals(statusTest.getHighTemperature(),10);
        assertEquals(statusTest.getFlightDistance(),39);
        assertEquals(statusTest.getHeight(),66);
        assertEquals(statusTest.getBatteryPercentage(),9);
        assertEquals(statusTest.getBarometerMeasurement(),56.89);
        assertEquals(statusTest.getMotorTime(),65);
    }
}