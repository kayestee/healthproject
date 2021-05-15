package com.healthy.healthcheck.backend;



import javax.persistence.*;
import java.sql.Date;


@Entity
@Table(name="patient")
public class Patient {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name="id")
     private Long id;
     private String name;
     private String status;
     private String sex;
    private Date birthdate;
    private long contactid;

     protected Patient(){}

    public Patient(String name, String status, String sex, Date birthdate, long contactid) {
        this.name = name;
        this.status = status;
        this.sex = sex;
        this.birthdate = birthdate;
        this.contactid = contactid;
    }



    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", sex='" + sex + '\'' +
                ", birthdate='" + birthdate + '\'' +
                ", contactid=" + contactid +
                '}';
    }

    public Long getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public long getContactid() {
        return contactid;
    }

    public void setContactid(long contactid) {
        this.contactid = contactid;
    }
}
