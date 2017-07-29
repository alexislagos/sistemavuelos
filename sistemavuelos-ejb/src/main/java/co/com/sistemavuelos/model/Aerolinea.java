package co.com.sistemavuelos.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

/**
 *
 * @author jhonlagos
 */
@Entity
@NamedQueries({
    @NamedQuery(name="Aerolinea.consultarAerolinea", query="select a from Aerolinea a")
})
public class Aerolinea implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;

    @Size(min = 4, max = 20)
    private String nombre;

    @OneToMany(mappedBy = "aerolinea", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<VueloPlaneado> planeados = new ArrayList<VueloPlaneado>();

    public Aerolinea() {
        this.id = new Integer(0);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<VueloPlaneado> getPlaneados() {
        return planeados;
    }

    public void setPlaneados(List<VueloPlaneado> planeados) {
        this.planeados = planeados;
    }

    @Override
    public String toString() {
        return String.format("%s[id=%d]", getClass().getSimpleName(), getId());
    }

    @Override
    public boolean equals(Object other) {
        return (other instanceof Aerolinea) && (id != null)
                ? id.equals(((Aerolinea) other).id)
                : (other == this);
    }

    @Override
    public int hashCode() {
        return (id != null) ? (this.getClass().hashCode() + id.hashCode()) : super.hashCode();
    }
}
