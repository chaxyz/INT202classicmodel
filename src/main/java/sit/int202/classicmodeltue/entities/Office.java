package sit.int202.classicmodeltue.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "Offices")
@Getter
@Setter
@ToString(exclude = {"addressLine1","addressLine2","territory"})
@NamedQueries(
        {
                @NamedQuery(name="OFFICE.FIND_ALL" ,query = "select o from Office o"),
                @NamedQuery(name="OFFICE.FIND_BY_COUNTRY", query = "select o from Office  o where o.country like :countryParam"),

        }
)
public class Office {
    @Id
    private String officeCode;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String country;
    private String postalCode;
    private String phone;
    private String territory;
    @OneToMany(mappedBy = "officeCode")
    private List<Employee> employeeList;
}
