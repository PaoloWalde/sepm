package unitTesting;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import user.Assistant;

class AdminTest
{
	Assistant assistant1;
	
	@Before
	public void setUp()
	{
		assistant1 = new Assistant("Alice", "002", "alice@gmail.com", "0411 009 008");
	}

	@Test
	public void testName()
	{
		assertEquals("Alice", assistant1.getName());
	}
	
	@Test
	public void testId()
	{
		assertEquals("002", assistant1.getId());
	}

	@Test
	public void testEmail()
	{
		assertEquals("alice@gmail.com", assistant1.getEmail());
	}
	
	@Test
	public void testPhoneNumber()
	{
		assertEquals("0411 009 008", assistant1.getPhoneNumber());
	}
}
