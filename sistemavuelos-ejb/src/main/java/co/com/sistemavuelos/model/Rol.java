package co.com.sistemavuelos.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author jhonlagos
 */
@Entity
@Table(name = "rol")
public class Rol implements Serializable {

    @Id
    @NotNull
    @Size(min = 4, max = 20)
    private String nombre;

    @ManyToMany(mappedBy = "roles")
    private List<Usuario> usuarios = new ArrayList<Usuario>();

    public Rol() {
    }

    public Rol(String nombre) {
        super();
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    @Override
    public String toString() {
        return "Rol[ nombre=" + nombre + " ]";
    }
}
