package sit.int202.classicmodeltue;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import sit.int202.classicmodeltue.entities.Employee;
import sit.int202.classicmodeltue.entities.Office;

import java.util.Scanner;

public class TestJpa {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
        Office office = em.find(Office.class,"8");

        if (office != null){
            System.out.println(office);

        }else {
            System.out.println("No specify office");
            Office newOffice = new Office();
            newOffice.setOfficeCode("8");
            newOffice.setCountry("Thailand");
            newOffice.setCity("Bangkok");
            newOffice.setAddressLine1("10130");
            newOffice.setPhone("34284294");
            newOffice.setPostalCode("11111");
            newOffice.setTerritory("xx");
            em.getTransaction().begin();
            em.persist(newOffice);
            em.getTransaction().commit();
            System.out.println(newOffice);

        }
        System.out.println("Enter office code you want to delete");
        String x = new Scanner(System.in).next();
        Office delOffice = em.find(Office.class, x);
        if(delOffice != null){
            em.getTransaction().begin();
            em.remove(delOffice);
            em.getTransaction().commit();
        }
        String y = new Scanner(System.in).next();
        Employee employee = em.find(Employee.class,1002);
        System.out.println(employee);
        em.close();
        emf.close();
    }
}
