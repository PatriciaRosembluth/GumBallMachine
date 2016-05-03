public class HasQuarterState implements MachineState{

	public void ShowMessage(int coins, String operation) {
		if(coins == 1 && operation == "insert"){
			System.out.println(Messages.INSERT_SUCCESSFULLY);
		}else if(coins == 2 && operation == "insert"){
			System.out.println(Messages.INSERT_TWICE);
		}else if(coins == 2 && operation == "dispense"){
			System.out.println(Messages.DISPENSE_WHEN_HAS_QUARTER);
		}
		
	}

	public int getState() {
		return 2;
	}

}
