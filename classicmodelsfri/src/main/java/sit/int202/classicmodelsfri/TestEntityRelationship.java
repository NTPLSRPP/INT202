package sit.int202.classicmodelsfri;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import sit.int202.classicmodelsfri.entities.Employee;
import sit.int202.classicmodelsfri.entities.Office;

import java.util.Scanner;

public class TestEntityRelationship {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Enter office code, enter 0 to exit: ");
            String officeCode = sc.next();
            if (officeCode.equalsIgnoreCase("0")) {
                break;
            }
            Office office = em.find(Office.class, officeCode);
            if (office == null) {
                System.out.println("Office number " + officeCode + " does not exist !!");
            } else {
                displayOfficeEmployee(office);
            }
        }
        em.close();
    }

    private static void displayOfficeEmployee(Office office) {
        System.out.printf("%s %s %s %s\n",
                office.getOfficeCode(), office.getAddressLine1(),
                office.getCity(), office.getCountry());
        System.out.println("---------------------------------");
        for (Employee employee : office.getEmployeeList()) {
            System.out.printf("%4d %-12s %-12s %s\n",
                    employee.getEmployeeNumber(), employee.getFirstName(),
                    employee.getLastName(), employee.getJobTitle());
        }
        System.out.println();
    }
}
