package main;

import javax.persistence.*;

@Entity
public class Recurso {

    @Id
    @GeneratedValue
    @Column(name = "resource_id")
    private Integer resourceID;

    @Column(nullable = false)
    private String nameResource;

    @Column(name = "cantidad",nullable = false)
    private Integer quantity;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "evento_id", nullable = false)
    private Evento evento;

    public Recurso() {}

    public Recurso(String nameResource,int quantity) {
        this.nameResource = nameResource;
        this.quantity = quantity;
    }

    public void setEvent(Evento evento) {
        evento.addResource(this);
        this.evento = evento;
    }

    public Evento getEvent() {
        return evento;
    }
    
    public Integer getID() {
        return resourceID;
    }

    public String getResourceName() {
        return nameResource;
    }

    public void setResourceName(String name) {
        this.nameResource = name;
    }
    
    public Integer getQuantity() {
        return quantity;
    }
    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
}
