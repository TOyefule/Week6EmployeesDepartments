package com.example.demo;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private static long id;

    @NotNull
    @Size(min=2)
    private String name;

    @NotNull
    @Size(min=10)
    private String jobtitle;

    @NotNull
    @Size(min=6)
    private String department;
  //  public Set<Department> department;

    @NotNull
    private String photo;

    public static long getId() {
        return id;
    }

    public static void setId(long id) {
        Employee.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJobtitle() {
        return jobtitle;
    }

    public void setJobtitle(String jobtitle) {
        this.jobtitle = jobtitle;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    /*@ManyToOne(mappedBy = "employee", cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)*/

    /*public Set<Department> departments;*/


}
