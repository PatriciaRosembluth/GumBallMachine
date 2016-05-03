import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GumballMachineTest {
	
	private ByteArrayOutputStream out;

	@Before
	public void setup(){
		out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));		
	}
	
	@After
	public void tearDown(){
		out.reset();
		System.setOut(null);
	}
	
	public GumballMachine createGumballMachine(int gumballs) {
		return new GumballMachine(gumballs);
	}

	public void assertMachineMessage(String message) {
		assertTrue(out.toString().contains(message));
	}
	
	@Test
	public void insertQuarter(){
		GumballMachine gumball = createGumballMachine(1);
	
		gumball.insertQuarter();
		
		assertMachineMessage(Messages.INSERT_SUCCESSFULLY);
	}

	@Test
	public void insertTwoQuarters() throws Exception {
		GumballMachine gumball= createGumballMachine(1); 
		
		gumball.insertQuarter();
		gumball.insertQuarter();
		
		assertMachineMessage(Messages.INSERT_TWICE);
	}
	
	@Test
	public void insertWhenSoldOut(){
		GumballMachine gumball = createGumballMachine(0);
	
		gumball.insertQuarter();
		
		assertMachineMessage(Messages.INSERT_WHEN_SOLDOUT);	
	}
	
	
	@Test
	public void ejectQuarter(){
		GumballMachine gumball = createGumballMachine(1);
		
		gumball.insertQuarter();
		gumball.ejectQuarter();
		
		assertMachineMessage(Messages.EJECT_SUCCESSFULLY);
	}
	
	@Test
	public void ejectWhenNoQuarter() throws Exception {
		GumballMachine gumball = createGumballMachine(1);
		
		gumball.ejectQuarter();
		
		assertMachineMessage(Messages.EJECT_WHEN_NO_QUARTER);
	}
	
	@Test
	public void ejectWhenSoldOut() throws Exception {
		GumballMachine gumball = createGumballMachine(0);
		
		gumball.ejectQuarter();
		
		assertMachineMessage(Messages.EJECT_WHEN_SOLD_OUT);
	}
	
	@Test
	public void turnWhenSoldOut() throws Exception {
		GumballMachine gumball = createGumballMachine(0);
		
		gumball.turnCrank();
		
		assertMachineMessage(Messages.TURN_WHEN_SOLD_OUT);
	}
	
	@Test
	public void turnWhenNoQuarter() throws Exception {
		GumballMachine gumball = createGumballMachine(1);
		
		gumball.turnCrank();
		
		assertMachineMessage(Messages.TURN_WHEN_NO_QUARTER);
	}
	
	@Test
	public void dispense() throws Exception {
		GumballMachine gumball = createGumballMachine(1);
		
		gumball.insertQuarter();
		gumball.turnCrank();
		
		assertMachineMessage(Messages.TURN_SUCCESSFULLY);
		assertMachineMessage(Messages.DISPENSE_SUCCESSFULLY);
	}
	
	@Test
	public void dispenseLastGumball() throws Exception {
		GumballMachine gumball = createGumballMachine(1);
		
		gumball.insertQuarter();
		gumball.turnCrank();
		gumball.insertQuarter();
		gumball.turnCrank();
		
		assertMachineMessage(Messages.DISPENSE_LAST_GUMBALL);
	}
	
	@Test
	public void dispenseWhenNoQuarter() throws Exception {
		GumballMachine gumball = createGumballMachine(1);
		
		gumball.dispense();
		
		assertMachineMessage(Messages.DISPENSE_WHEN_NO_QUARTER);	
	}
	
	@Test
	public void dispenseWhenHasQuarter() throws Exception {
		GumballMachine gumball = createGumballMachine(1);
		
		gumball.insertQuarter();
		gumball.dispense();
		
		assertMachineMessage(Messages.DISPENSE_WHEN_HAS_QUARTER);
	}
	
	@Test
	public void dispenseWhenSoldOut() throws Exception {
		GumballMachine gumball = createGumballMachine(0);
		
		gumball.dispense();
		
		assertMachineMessage(Messages.DISPENSE_WHEN_SOLD_OUT);
	}
	
	
	
}