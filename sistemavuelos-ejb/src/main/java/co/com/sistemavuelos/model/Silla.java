package co.com.sistemavuelos.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author jhonlagos
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "SillaconsultarSillasOcupadas.", query = "select count(s) from Silla s where s.vueloEspecifico.id = :idVueloEspecifico"),
    @NamedQuery(name = "Silla.consultarSillasAsignadas", query = "select s from Silla s join s.vueloEspecifico.trayectos t where t.id =:idTrayecto"),
    @NamedQuery(name = "Silla.consultarSillasAsignadasVuelo", query = "select s from Silla s where s.vueloEspecifico.id = :idVueloEspecifico order by s.codigo")
})
public class Silla implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @NotNull
    private VueloEspecifico vueloEspecifico;

    @OneToOne
    private Pasajero pasajero;

    @NotNull
    @Size(min = 1, max = 3)
    private String codigo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Pasajero getPasajero() {
        return pasajero;
    }

    public void setPasajero(Pasajero pasajero) {
        this.pasajero = pasajero;
    }

    public VueloEspecifico getVueloEspecifico() {
        return vueloEspecifico;
    }

    public void setVueloEspecifico(VueloEspecifico vueloEspecifico) {
        this.vueloEspecifico = vueloEspecifico;
    }

    @Override
    public String toString() {
        return String.format("%s[id=%d]", getClass().getSimpleName(), getId());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
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
        Silla other = (Silla) obj;
        if (id != other.id) {
            return false;
        }
        return true;
    }
}
