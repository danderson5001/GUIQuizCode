import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculationsTest {
	
	Calculations calc = new Calculations();
	String[] namesTest = {"brittney", "thomas", "chad", "becca"};
	@BeforeEach
	void setUp() throws Exception { 
	}

	@Test
	void testGetName() {
		Assert.assertTrue(calc.getName() instanceof String);
	}

	@Test
	void testGetCount() {
		Assert.assertTrue(calc.getCount()>=0);
	}

	@Test
	void testGetFileArray() {
		Assert.assertTrue(calc.getFileArray() >= 0);
	}
	@Test
	void testNumPeopleMethod()  {
		try{
			calc.numPeopleMethod(1, 0);
		}catch(FileNotFoundException e) {
			System.out.println("File dont exist");
			e.getStackTrace();
		}
	}

	@Test
	void testSetChoicePerson1() {
		fail("Not yet implemented");
	}

	@Test
	void testSetChoicePerson2() {
		fail("Not yet implemented");
	}

	@Test
	void testFillArray() {
		fail("Not yet implemented");
	}

	@Test
	void testDeleteBoring() {
		fail("Not yet implemented");
	}

	@Test
	void testCrossReference() {
		fail("Not yet implemented");
	}

}
