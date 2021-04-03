package com.healthy.backend;



import javax.persistence.*;


@Entity
public class Health {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name="id")
     private Long id;
     private String name;
     private String status;

     protected Health(){}

     public Health(String name, String status){
         this.name = name;
         this.status = status;
     }

     @Override
     public String toString(){
            return String.format("Health[id=%d, name='%s', status='%s']",
                    id,name,status);
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
}
