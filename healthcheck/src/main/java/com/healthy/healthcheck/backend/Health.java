package com.healthy.healthcheck.backend;



import javax.persistence.*;


@Entity
@Table(name="health")
public class Health {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name="id")
     private Long id;
     private String status;

     protected Health(){}

     public Health(String name, String status){
              this.status = status;
     }

     @Override
     public String toString(){
            return String.format("Health[id=%d, name='%s', status='%s']",
                    id,status);
     }
    public Long getId() {
        return id;
    }



    public String getStatus() {
        return status;
    }


    public void setStatus(String status) {
        this.status = status;
    }
}
