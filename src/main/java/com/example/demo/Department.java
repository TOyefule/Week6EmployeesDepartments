package com.example.demo.Entitiy;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @Size(min=4)
    private String departmentName;

    @OneToMany(mappedBy = "department")
    private Set<Employee> employees;



    public long getId() {
        return id;
    }

//    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL,
//               fetch = FetchType.EAGER)
//            public Set<Employee> employees;


    public void setId(long id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}
