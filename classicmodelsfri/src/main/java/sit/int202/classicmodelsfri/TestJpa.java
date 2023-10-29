package sit.int202.classicmodelsfri;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import sit.int202.classicmodelsfri.entities.Employee;
import sit.int202.classicmodelsfri.entities.Office;

import java.util.Scanner;

public class TestJpa {
    public static void main(String[] args) {
        // Create Entity Manager Factory
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        // Create Entity Manager
        EntityManager em = emf.createEntityManager();

        // Offices
        System.out.print("Find office by office code : ");
        String oc = new Scanner(System.in).next();
        Office office = em.find(Office.class, oc);
        if (office == null) {
            System.out.println("Office number " + oc + " does not exist !!!");
            Office newOffice = new Office();
            newOffice.setOfficeCode(oc);
            newOffice.setCity("Bangkok");
            newOffice.setPhone("+66 2 123 4567");
            newOffice.setAddressLine1("126 Pracha-Utit");
            newOffice.setCountry("THA");
            newOffice.setPostalCode("10140");
            newOffice.setTerritory("XX");
            em.getTransaction().begin();
            em.persist(newOffice);
            em.getTransaction().commit();
        }
        else {
            System.out.println(office);
            System.out.println("Do you want to delete office no " + oc + "? (Y/N)");
            String ans = new Scanner(System.in).next();
            if (ans.equalsIgnoreCase("y")) {
                em.getTransaction().begin();
                em.remove(office);
                em.getTransaction().commit();
                System.out.println("Office no " + oc + " has been removed !!!");
            }
        }

        // Employees
        System.out.print("Find employee by employee ID : ");
        int eid = new Scanner(System.in).nextInt();
        Employee employee = em.find(Employee.class, eid);
        if (employee == null) {
            System.out.println("Employee id " + eid + " does not exist !!!");
        } else {
            System.out.println(employee);
        }

        // Close Entity Manager
        em.close();
        // Close Entity Manager Factory
        emf.close();
    }
}
