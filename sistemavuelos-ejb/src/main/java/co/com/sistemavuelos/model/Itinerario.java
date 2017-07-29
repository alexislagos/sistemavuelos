package co.com.sistemavuelos.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author jhonlagos
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Itinerario.consultarItinerariosAgente", query = "select i from Itinerario i where i.agente.id = :idAgente"),
    @NamedQuery(name = "Itinerario.consultarItinerariosComprados", query = "select i from Itinerario i where i.agente.id = :idAgente and i.comprado=true")
})
public class Itinerario implements Serializable {

    @Id
    @GeneratedValue
    private long id;

    @Size(min = 3, max = 12)
    @NotNull
    private String nombre;

    @NotNull
    private boolean comprado;

    @OneToMany(mappedBy = "itinerario", cascade = CascadeType.ALL)
    private List<Trayecto> trayectos;

    @ManyToOne
    @NotNull
    private Agente agente;

    @OneToMany(mappedBy = "itinerario", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Pasajero> pasajeros;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean getComprado() {
        return comprado;
    }

    public void setComprado(boolean comprado) {
        this.comprado = comprado;
    }

    public Agente getAgente() {
        return agente;
    }

    public void setAgente(Agente agente) {
        this.agente = agente;
    }

    public List<Trayecto> getTrayectos() {
        return trayectos;
    }

    public void setTrayectos(List<Trayecto> trayectos) {
        this.trayectos = trayectos;
    }

    public List<Pasajero> getPasajeros() {
        return pasajeros;
    }

    public void setPasajeros(List<Pasajero> pasajeros) {
        this.pasajeros = pasajeros;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return String.format("%s[id=%d]", getClass().getSimpleName(), getId());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((agente == null) ? 0 : agente.hashCode());
        result = prime * result + (comprado ? 1231 : 1237);
        result = prime * result + (int) (id ^ (id >>> 32));
        result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
        result = prime * result
                + ((pasajeros == null) ? 0 : pasajeros.hashCode());
        result = prime * result
                + ((trayectos == null) ? 0 : trayectos.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Itinerario other = (Itinerario) obj;
        if (id != other.id) {
            return false;
        }
        return true;
    }
}
