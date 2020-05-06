package unitTesting;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import user.Administrator;

class AdminTest
{
	Administrator admin1;
	
	@Before
	public void setUp()
	{
		admin1 = new Administrator("Bob", "001", "bob@gmail.com", "0410 112 223");
	}

	@Test
	public void testName()
	{
		assertEquals("Bob", admin1.getName());
	}
	
	@Test
	public void testId()
	{
		assertEquals("001", admin1.getId());
	}

	@Test
	public void testEmail()
	{
		assertEquals("bob@gmail.com", admin1.getEmail());
	}
	
	@Test
	public void testPhoneNumber()
	{
		assertEquals("0410 112 223", admin1.getPhoneNumber());
	}
}
