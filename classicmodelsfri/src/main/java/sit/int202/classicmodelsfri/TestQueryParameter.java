package sit.int202.classicmodelsfri;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import sit.int202.classicmodelsfri.entities.Office;

import java.util.List;
import java.util.Scanner;

public class TestQueryParameter {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("OFFICE.FIND_BY_COUNTRY");
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Search office by country, enter 0 to exit: ");
            String country = sc.next();
            if (country.equalsIgnoreCase("0")) {
                break;
            }
            query.setParameter("countryParam", country + "%");
            List<Office> officeUSA = query.getResultList();
            for (Office office : officeUSA) {
                System.out.printf("%-2s %-25s %-15s %s\n", office.getOfficeCode(), office.getAddressLine1(), office.getCity(), office.getCountry());
            }
        }
        em.close();
    }
}
