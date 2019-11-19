package main;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
public class Evento {

    @Id
    @GeneratedValue
    @Column(name = "evento_id")
    private Integer eventID;

    @Column(name = "nombre_evento",nullable = false)
    private String eventName;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario user;

    @OneToMany(mappedBy = "evento", cascade = CascadeType.ALL)
    private List<Recurso> recursos = new ArrayList<>();
    

    private String ubication;
    

    public Evento() {}

    public Evento(String eventName,String ubication) {
        this.eventName = eventName;
        this.ubication = ubication;
    }

    public void addResource(Recurso recurso) {
        recursos.add(recurso);
    }

    public Integer getEventId() {
        return eventID;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        user.addEvent(this);
        this.user = user;
    }
    
    public String getUbication() {
        return ubication;
    }

    public void setUbication(String ubication) {
        this.ubication = ubication;
    }

    public List<Recurso> getRecources() {
        return Collections.unmodifiableList(recursos);
    }
}
