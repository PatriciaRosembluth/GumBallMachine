
public class GumballMachine {
	
	private static final int SOLD_OUT = 0;
	private static final int NO_QUARTER = 1;
	private static final int HAS_QUARTER = 2;
	private static final int SOLD = 3;
	
	
	private int state = SOLD_OUT;
	private int count;

	public GumballMachine(int count) {
		this.count = count;
		if (count > 0)
			state = NO_QUARTER;
	}

	public void insertQuarter() {
		if (state == NO_QUARTER) {
			state = HAS_QUARTER;
			System.out.println(Messages.INSERT_SUCCESSFULLY);
		}
		else if (state == HAS_QUARTER) {
				System.out.println(Messages.INSERT_TWICE);
		}
		else if (state == SOLD_OUT) {
			System.out.println(Messages.INSERT_WHEN_SOLDOUT);
		}
		else if (state == SOLD) {
			System.out.println(Messages.INSERT_WHEN_SOLD);
		}
			
	}

	public void ejectQuarter() {
		if (state == HAS_QUARTER) {
			state = NO_QUARTER;
			System.out.println(Messages.EJECT_SUCCESSFULLY);
		}
		else if (state == NO_QUARTER)
			System.out.println(Messages.EJECT_WHEN_NO_QUARTER);
		else if (state == SOLD_OUT)
			System.out.println(Messages.EJECT_WHEN_SOLD_OUT);
		else if (state == SOLD)
			System.out.println(Messages.EJECT_WHEN_SOLD);
	}

	public void turnCrank() {
		if (state == SOLD_OUT)
			System.out.println(Messages.TURN_WHEN_SOLD_OUT);
		else if (state == NO_QUARTER)
			System.out.println(Messages.TURN_WHEN_NO_QUARTER);
		else if (state == HAS_QUARTER) {
			state = SOLD;
			System.out.println(Messages.TURN_SUCCESSFULLY);
			dispense();
		}
		else if (state == SOLD)
			System.out.println(Messages.TURN_TWICE);
	}

	public void dispense() {
		if (state == SOLD) {
			System.out.println(Messages.DISPENSE_SUCCESSFULLY);
			count = count - 1;
			if (count == 0) {
				state = SOLD_OUT;
				System.out.println(Messages.DISPENSE_LAST_GUMBALL);
			}
		}
		else if (state == SOLD_OUT)
			System.out.println(Messages.DISPENSE_WHEN_SOLD_OUT);
		else if (state == NO_QUARTER)
			System.out.println(Messages.DISPENSE_WHEN_NO_QUARTER);
		else if (state == HAS_QUARTER)
			System.out.println(Messages.DISPENSE_WHEN_HAS_QUARTER);
	}

}