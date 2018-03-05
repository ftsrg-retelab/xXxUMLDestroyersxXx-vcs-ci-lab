package hu.bme.mit.train.controller;

import com.google.common.graph.Graph;
import hu.bme.mit.train.interfaces.TrainController;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import com.google.*;


public class TrainControllerImpl implements TrainController {

	private int step = 0;
	private int referenceSpeed = 0;
	private int speedLimit = 0;
	private Tachograph tac;
	Timer t;
	
	
	TrainControllerImpl() {
		t = new Timer();
		ExecutorService service = Executors.newSingleThreadExecutor();

		try {
		    Runnable r = new Runnable() {
		        @Override
		        public void run() {
		            followSpeed();
		        }
		    };

		    Future<?> f = service.submit(r);

		    f.get(500, TimeUnit.MILLISECONDS);     // attempt the task for two minutes
		}
		catch (final InterruptedException e) {
		    // The thread was interrupted during sleep, wait or join
		}
		catch (final TimeoutException e) {
		    // Took too long!
		}
		catch (final ExecutionException e) {
		    // An exception from within the Runnable task
		}
		finally {
		    service.shutdown();
		}
	}
	
	
	@Override
	public void followSpeed() {
		if (referenceSpeed < 0) {
			referenceSpeed = 0;
		} else {
		    if(referenceSpeed+step > 0) {
                referenceSpeed += step;
            } else {
		        referenceSpeed = 0;
            }
		}

		enforceSpeedLimit();
	}

	@Override
	public int getReferenceSpeed() {
		return referenceSpeed;
	}

	@Override
	public void setSpeedLimit(int speedLimit) {
		this.speedLimit = speedLimit;
		enforceSpeedLimit();
		
	}

	private void enforceSpeedLimit() {
		if (referenceSpeed > speedLimit) {
			referenceSpeed = speedLimit;
		}
	}

	public void emergencyBrake() {
		this.referenceSpeed = 0;
		this.step = 0;
		}

	@Override
	public void setJoystickPosition(int joystickPosition) {
		this.step = joystickPosition;
	}



}
