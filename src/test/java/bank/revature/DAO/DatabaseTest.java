package bank.revature.DAO;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.revature.models.Customer;
import com.revature.repositories.UserDAO;
import com.revature.repositories.UserDAOImpl;

class DatabaseTest {
	
	public static UserDAO user = new UserDAOImpl();

	@Test
	public void findAllCustomer() {
		
		List<Customer> accounts = user.findAllCustomer();
		
		assertNotNull(accounts);
	}

	@Test
	public void getCustomerAccount() {
		
		String id = "523";
		
		Customer c = user.findCustomerById(id);
		
		assertEquals("Jaswinder", c.getCustomerUsername());

		
	}
}
