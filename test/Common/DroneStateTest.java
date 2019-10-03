package Common;

import Message.Status;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DroneStateTest {
    DroneState testDroneState=new DroneState();

    @Test
    void setAndGetInCommandMode() {
        testDroneState.setInCommandMode(true);
        boolean commandMode =true;
        assertEquals(commandMode,testDroneState.isInCommandMode());
    }

    @Test
    void setAndGetHasTakenOff() {
        testDroneState.setInCommandMode(true);
        testDroneState.setHasTakenOff(true);
        boolean takenOff =true;
        assertEquals(takenOff,testDroneState.hasTakenOff());
    }

    @Test
    void updateFlyingInfo() {
        Status statusTest = new Status(20,12,67,18,16,14,12,10,39,66,9,56.89,65,7.9,5.0,8.0);
        testDroneState.setInCommandMode(true);
        testDroneState.setHasTakenOff(true);
        testDroneState.updateFlyingInfo(statusTest);
        assertEquals(statusTest.getHighTemperature(),testDroneState.getHighTemperature());
        assertEquals(statusTest.getPitch(),testDroneState.getPitch());
        assertEquals(statusTest.getRoll(),testDroneState.getRoll());
        assertEquals(statusTest.getYaw(),testDroneState.getYaw());
        assertEquals(statusTest.getSpeedX(),testDroneState.getSpeedX());
        assertEquals(statusTest.getSpeedY(),testDroneState.getSpeedY());
        assertEquals(statusTest.getSpeedZ(),testDroneState.getSpeedZ());
        assertEquals(statusTest.getAccelerationX(),testDroneState.getAccelerationX());
        assertEquals(statusTest.getAccelerationY(),testDroneState.getAccelerationY());
        assertEquals(statusTest.getAccelerationZ(),testDroneState.getAccelerationZ());
        assertEquals(statusTest.getLowTemperature(),testDroneState.getLowTemperature());
        assertEquals(statusTest.getHighTemperature(),testDroneState.getHighTemperature());
        assertEquals(statusTest.getFlightDistance(),testDroneState.getFlightDistance());
        assertEquals(statusTest.getHeight(),testDroneState.getHeight());
        assertEquals(statusTest.getBatteryPercentage(),testDroneState.getBatteryPercentage());
        assertEquals(statusTest.getBarometerMeasurement(),testDroneState.getBarometerMeasurement());
        assertEquals(statusTest.getMotorTime(),testDroneState.getMotorTime());
    }

    @Test
    void move() {
        testDroneState.setInCommandMode(true);
        testDroneState.setHasTakenOff(true);
        testDroneState.move(1.0,2.0,3.0);
        assertEquals(1.0,testDroneState.getPositionX());
        assertEquals(2.0,testDroneState.getPositionY());
        assertEquals(3.0,testDroneState.getPositionZ());
    }
}