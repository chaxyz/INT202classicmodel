package sit.int202.classicmodeltue;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import sit.int202.classicmodeltue.entities.Employee;
import sit.int202.classicmodeltue.entities.Office;

import java.util.Scanner;
import java.util.List;


public class testEntityRelationship {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
        Scanner sc = new Scanner(System.in);
        Query query = em.createNamedQuery("OFFICE.FIND_ALL");
        List<Office> officeList = query.getResultList();
        for (Office office : officeList
        ) {
            displayEmployee(office);
        }
        do {
            System.out.println("Enter office code");
            String officeCode = sc.next();
            if (officeCode.equalsIgnoreCase("0")) {
                break;
            }
            Office office = em.find(Office.class, officeCode);
            if (office == null) {
                System.out.println("Office code " + officeCode + " does not exist !!");
                break;
            } else {
                displayEmployee(office);
            }

        } while (true);


    }

    private static void displayEmployee(Office office) {
        System.out.println(office.getOfficeCode() + " " + office.getCity() + " , " + office.getCountry());
        System.out.println("--------------------------");
        for (Employee employee : office.getEmployeeList()) {
            System.out.printf("%-4s %-13s %-15s\n", employee.getEmployeeNumber(), employee.getFirstName(), employee.getLastName());
        }
        System.out.println();
    }
}
