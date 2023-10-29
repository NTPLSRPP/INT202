package sit.int202.classicmodelsfri.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "Employees")
@NamedQueries({
        @NamedQuery(name = "E.FIND_ALL", query = "select e from Employee e"),
        @NamedQuery(name = "E.FIND_BY_NAME", query = "select e from Employee e where e.firstName like :first_name or e.lastName like :last_name")
})
public class Employee {
    @Id
    private int employeeNumber;
    private String lastName;
    private String firstName;
    private String extension;
    private String email;
    private String officeCode;
    private Integer reportsTo;
    private String jobTitle;
}
