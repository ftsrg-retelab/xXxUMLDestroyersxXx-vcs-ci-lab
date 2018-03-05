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
<<<<<<< HEAD
    public void AlarmAtHighLimitTest() {   	 	
       sensor.overrideSpeedLimit(600);
       verify(user, times(1)).setAlarmState(true);
       //assertTrue(user.getAlarmState());
=======
    public void AlarmAtHighLimitTest() {
       sensor.overrideSpeedLimit(600);
       assertTrue(user.getAlarmState());
>>>>>>> 19496bbf7080e7fc4b5cb6fbd6075c7e0b074a93
    }
    
    @Test
    public void AlarmAtLowLimitTest() {
    	sensor.overrideSpeedLimit(-50);
<<<<<<< HEAD
        verify(user, times(1)).setAlarmState(true);
=======
    	assertTrue(user.getAlarmState());
>>>>>>> 19496bbf7080e7fc4b5cb6fbd6075c7e0b074a93
    }
    
    @Test
    public void AlarmAtBigDifferenceTest(){
    	sensor.overrideSpeedLimit(300);
<<<<<<< HEAD
    	when(controller.getReferenceSpeed()).thenReturn(280);
    	sensor.overrideSpeedLimit(100);
        verify(user, times(1)).setAlarmState(true);
=======
    	controller.setJoystickPosition(280);
    	controller.followSpeed();
    	sensor.overrideSpeedLimit(100);
    	assertTrue(user.getAlarmState());
>>>>>>> 19496bbf7080e7fc4b5cb6fbd6075c7e0b074a93
    	
    }
    
    @Test
    public void NoAlarmNormalFunction() {
    	sensor.overrideSpeedLimit(20);
<<<<<<< HEAD
        verify(user, times(1)).setAlarmState(false);
=======
    	assertFalse(user.getAlarmState());
>>>>>>> 19496bbf7080e7fc4b5cb6fbd6075c7e0b074a93
    }
    
}
