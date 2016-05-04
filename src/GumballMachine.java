
public class GumballMachine {
	
	MachineState state = new SoldOutState();
	private int count;

	public GumballMachine(int count) {
		this.count = count;
		if (count > 0)
			state  = new NoQuarterState();
	}

	public void insertQuarter() {
		if (state.getState() == 1) {
			state = new HasQuarterState();
			state.ShowMessage(count, "insert");
		}
		else if (state.getState() == 2) {
			state.ShowMessage(count+1, "insert");
		}
		else if (state.getState() == 0) {
			state.ShowMessage(count, "insert");
		}
		else if (state.getState() == 3) {
			state.ShowMessage(count, "insert");
		}
			
	}

	public void ejectQuarter() {
		if (state.getState() == 2) {
			state = new NoQuarterState();
			state.ShowMessage(count, "eject");
		}
		else if (state.getState() == 1)
			state.ShowMessage(count-1, "eject");
		else if (state.getState() == 0)
			state.ShowMessage(count, "eject");
		else if (state.getState() == 3)
			state.ShowMessage(count, "eject");
	}

	public void turnCrank() {
		if (state.getState() == 0)
			state.ShowMessage(count, "turnCrank");
		else if (state.getState() == 1)
			state.ShowMessage(count, "turnCrank");
		else if (state.getState() == 2) {
			state = new SoldState();
			state.ShowMessage(count, "turnCrank");
			dispense();
		}
		else if (state.getState() == 3)
			System.out.println(Messages.TURN_TWICE);
	}

	public void dispense() {
		if (state.getState() == 3) {
			state.ShowMessage(count, "dispense");
			count = count - 1;
			if (count == 0) {
				state = new SoldOutState();
				state.ShowMessage(count, "dispenseLast");
			}
		}
		else if (state.getState() == 0)
			state.ShowMessage(count, "dispense");
		else if (state.getState() == 1)
			state.ShowMessage(count, "dispense");
		else if (state.getState() == 2)
			state.ShowMessage(count+1, "dispense");
	}

}