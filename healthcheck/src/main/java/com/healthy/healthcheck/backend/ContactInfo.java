package com.healthy.healthcheck.backend;



import javax.persistence.*;

@Entity
@Table(name="contactinfo")
public class ContactInfo {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name="contactid")
     private Long contactid;
     private String firstname;
     private String lastname;
     private String address;
     private String state;
     private String country;
     private String phone;

     protected ContactInfo(){}


    public ContactInfo(Long contactid, String firstname, String lastname, String address, String state, String country, String phone) {
        this.contactid = contactid;
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.state = state;
        this.country = country;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "ContactInfo{" +
                "contactid=" + contactid +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", address='" + address + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    public Long getcontactid() {
        return contactid;
    }

    public void setcontactid(Long contactid) {
        this.contactid = contactid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
