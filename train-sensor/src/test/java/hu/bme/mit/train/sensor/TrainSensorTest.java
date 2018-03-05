package hu.bme.mit.train.sensor;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import hu.bme.mit.train.controller.*;
import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;
import hu.bme.mit.train.user.TrainUserImpl;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class TrainSensorTest {

	 TrainController controller = new TrainControllerImpl();
	 TrainUser user = new TrainUserImpl(controller);
	 TrainSensor sensor = new TrainSensorImpl(controller, user);
	
    @Before
    public void before() {

        
    }

    @Test
    public void AlarmAtHighLimitTest() {
       sensor.overrideSpeedLimit(600);
       assertTrue(user.getAlarmState());
    }
    
    @Test
    public void AlarmAtLowLimitTest() {
    	sensor.overrideSpeedLimit(-50);
    	assertTrue(user.getAlarmState());
    }
    
    @Test
    public void AlarmAtBigDifferenceTest(){
    	sensor.overrideSpeedLimit(300);
    	controller.setJoystickPosition(280);
    	controller.followSpeed();
    	sensor.overrideSpeedLimit(100);
    	assertTrue(user.getAlarmState());
    	
    }
    
    @Test
    public void NoAlarmNormalFunction() {
    	sensor.overrideSpeedLimit(20);
    	assertFalse(user.getAlarmState());
    }
    
}
