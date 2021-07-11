// https://www.javastructures.com/design/elevator
// https://www.javatpoint.com/Comparable-interface-in-collection-framework

class Elevator {
	private int currentFloor = 0;
	private Direction currentDirection = Direction.UP;
	private State currentState = State.IDLE;
}

enum State {

	MOVING, STOPPED, IDLE

}

enum Direction {

	UP, DOWN

}

class Request implements Comparable<Request> {
	private InternalRequest internalRequest;
	private ExternalRequest externalRequest;

	public Request(InternalRequest internalRequest, ExternalRequest externalRequest) {
		this.internalRequest = internalRequest;
		this.externalRequest = externalRequest;
	}

	public InternalRequest getInternalRequest() {
		return internalRequest;
	}

	public void setInternalRequest(InternalRequest internalRequest) {
		this.internalRequest = internalRequest;
	}

	public ExternalRequest getExternalRequest() {
		return externalRequest;
	}

	public void setExternalRequest(ExternalRequest externalRequest) {
		this.externalRequest = externalRequest;
	}

	@Override
	public int compareTo(Request req) {
		if (this.getInternalRequest().getDestinationFloor() == req.getInternalRequest().getDestinationFloor())
			return 0;
		else if (this.getInternalRequest().getDestinationFloor() > req.getInternalRequest().getDestinationFloor())
			return 1;
		else
			return -1;
	}

}

class ExternalRequest {

	private Direction directionToGo;
	private int sourceFloor;

	public ExternalRequest(Direction directionToGo, int sourceFloor) {
		this.directionToGo = directionToGo;
		this.sourceFloor = sourceFloor;
	}

	public Direction getDirectionToGo() {
		return directionToGo;
	}

	public void setDirectionToGo(Direction directionToGo) {
		this.directionToGo = directionToGo;
	}

	public int getSourceFloor() {
		return sourceFloor;
	}

	public void setSourceFloor(int sourceFloor) {
		this.sourceFloor = sourceFloor;
	}

}

class InternalRequest {
	private int destinationFloor;

	public InternalRequest(int destinationFloor) {
		this.destinationFloor = destinationFloor;
	}

	public int getDestinationFloor() {
		return destinationFloor;
	}

	public void setDestinationFloor(int destinationFloor) {
		this.destinationFloor = destinationFloor;
	}

}

public class TestElevator {

	public static void main(String args[]) {

		Elevator elevator = new Elevator();
		
		//person wants to go in up direction from source floor 0
		ExternalRequest er = new ExternalRequest(Direction.UP, 0);
		
		//the destination floor is 5
		InternalRequest ir = new InternalRequest(5);


		Request request1 = new Request(ir, er);

	}

}
