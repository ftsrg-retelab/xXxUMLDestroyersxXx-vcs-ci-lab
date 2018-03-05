package hu.bme.mit.train.interfaces;

public interface TrainController {

	void followSpeed();
	
	void startTrain();

	int getReferenceSpeed();

	void setSpeedLimit(int speedLimit);

	void setJoystickPosition(int joystickPosition);

	void emergencyBrake();

}
