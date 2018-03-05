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
       controller.setSpeedLimit(600);
       assertTrue(user.getAlarmState());
    }
    
    @Test
    public void AlarmAtLowLimitTest() {
    	controller.setSpeedLimit(-50);
    	assertTrue(user.getAlarmState());
    }
    
    @Test
    public void AlarmAtBigDifferenceTest(){
    	controller.setSpeedLimit(300);
    	controller.setJoystickPosition(280);
    	controller.followSpeed();
    	controller.setSpeedLimit(100);
    	assertTrue(user.getAlarmState());
    	
    }
    
    @Test
    public void NoAlarmNormalFunction() {
    	controller.setSpeedLimit(20);
    	assertFalse(user.getAlarmState());
    }
    
}
