package sit.int202.classicmodelsfri;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import sit.int202.classicmodelsfri.entities.Employee;

import java.util.Scanner;
import java.util.List;

public class TestQueryPagination {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("E.FIND_ALL");
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter number of item per page: ");
        int pageSize = sc.nextInt();
        int startAt = 0;
        query.setMaxResults(pageSize);
        while (true) {
            query.setFirstResult(startAt);
            List<Employee> employeeList = query.getResultList();
            if (employeeList.isEmpty()) {
                break;
            }
            displayEmployee(employeeList);
            System.out.print("Enter any key then enter to view next page ... ");
            sc.next();
            startAt = startAt + pageSize;
        }
    }

    private static void displayEmployee(List<Employee> employeeList) {
        for (Employee employee : employeeList) {
            System.out.printf("%4d %-12s %-12s %s\n", employee.getEmployeeNumber(), employee.getFirstName(), employee.getLastName(), employee.getJobTitle());
        }
        System.out.println("---------------------------------");
    }
}
