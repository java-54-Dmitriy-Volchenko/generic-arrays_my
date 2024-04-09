package telran.employees.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.employees.*;

class CompanyTest {
private static final long ID1 = 123;
private static final int SALARY1 = 1000;
private static final String DEPARTMENT1 = "Development";
private static final long ID2 = 120;
private static final int SALARY2 = 2000;
private static final long ID3 = 125;
private static final int SALARY3 = 3000;
private static final String DEPARTMENT2 = "QA";
Employee empl1 = new Employee(ID1, SALARY1, DEPARTMENT1);
Employee empl2 = new Employee(ID2, SALARY2, DEPARTMENT1);
Employee empl3 = new Employee(ID3, SALARY3, DEPARTMENT2);
Company company;
@BeforeEach
void setCompany() {
	//before each test there will be created new object company 
	// with array of the given employee objects
	company = new Company(new Employee[] {empl1, empl2, empl3});
}
	@Test
	void testAddEmployee() {
		//TODO
		assertThrowsExactly(IllegalStateException.class,
				() -> company.addEmployee(empl1));
	}

	@Test
	void testGetEmployee() {
		//TODO
	}

	@Test
	void testRemoveEmployee() {
		//TODO
	}

	@Test
	void testGetDepartmentBudget() {
		//TODO
	}

	@Test
	void testIterator() {
		//TODO
	}

}
