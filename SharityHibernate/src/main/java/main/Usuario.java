package main;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
public class Usuario {

    @Id
    @GeneratedValue
    @Column(name = "usuario_id")
    private Integer usuarioID;

    @Column(name = "nombre_usuario", nullable = false)
    private String username;
    @Column(name = "password", nullable = false)
    private String password;


    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Evento> eventos = new ArrayList<>();

    public Usuario() {}

    public Usuario(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void addEvent(Evento evento) {
        eventos.add(evento);
    }

    public Integer getUsuarioID() {
        return usuarioID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Evento> getEventos() {
        return Collections.unmodifiableList(eventos);
    }
}
