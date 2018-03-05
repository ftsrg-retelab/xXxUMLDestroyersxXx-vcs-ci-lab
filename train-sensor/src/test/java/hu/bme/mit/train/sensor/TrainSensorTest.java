package hu.bme.mit.train.sensor;

import org.junit.Before;
import org.junit.Test;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class TrainSensorTest {

	 TrainController controller;
	 TrainUser user;
	 TrainSensor sensor;
	
    @Before
    public void before() {
    	controller=mock(TrainController.class);
    	user=mock(TrainUser.class);
   	 	sensor = new TrainSensorImpl(controller, user);
    }

    @Test
    public void AlarmAtHighLimitTest() {   	 	
       sensor.overrideSpeedLimit(600);
       verify(user, times(1)).setAlarmState(true);
       //assertTrue(user.getAlarmState());
    }
    
    @Test
    public void AlarmAtLowLimitTest() {
    	sensor.overrideSpeedLimit(-50);
        verify(user, times(1)).setAlarmState(true);
    }
    
    @Test
    public void AlarmAtBigDifferenceTest(){
    	sensor.overrideSpeedLimit(300);
    	when(controller.getReferenceSpeed()).thenReturn(280);
    	sensor.overrideSpeedLimit(100);
        verify(user, times(1)).setAlarmState(true);
    	
    }
    
    @Test
    public void NoAlarmNormalFunction() {
    	sensor.overrideSpeedLimit(20);
        verify(user, times(1)).setAlarmState(false);
    }
    
}