package com.example.demo;


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
    private String name;


    @Size(min=1)
    private String departmenthead;


    @Size(min=1)
    private String description;

    public long getId() {
        return id;
    }

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL,
               fetch = FetchType.EAGER)
            public Set<Employee> employees;

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartmenthead() {
        return departmenthead;
    }

    public void setDepartmenthead(String departmenthead) {
        this.departmenthead = departmenthead;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}
