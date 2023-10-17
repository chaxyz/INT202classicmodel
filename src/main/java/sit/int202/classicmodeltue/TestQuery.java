package sit.int202.classicmodeltue;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import sit.int202.classicmodeltue.entities.Employee;
import sit.int202.classicmodeltue.entities.Office;

import java.util.List;

public class TestQuery {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("OFFICE.FIND_ALL");
        List<Office> officeList = query.getResultList();
        for (Office off : officeList
        ) {
            System.out.printf("%-2s %-25s %-13s %-12s\n", off.getOfficeCode(), off.getAddressLine1(), off.getCity(), off.getCountry());
        }
        Query queryEmployee = em.createNamedQuery("EMPLOYEE.FIND_ALL");
        List<Employee> employeeList = queryEmployee.getResultList();
        for (Employee employee : employeeList) {
            System.out.printf("%-4s %-13s %-15s\n", employee.getEmployeeNumber(), employee.getFirstName(), employee.getLastName());
        }
        em.close();

    }
}
