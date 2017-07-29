package co.com.sistemavuelos.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author jhonlagos
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "VueloPlaneado.consultarVueloPlaneadoDeAerolinea", query = "select v from VueloPlaneado v where v.aerolinea.id = :idAerolinea"),
    @NamedQuery(name = "VueloPlaneado.consultarEspecifico", query = "select e from VueloEspecifico e where e.vueloplaneado.id = :idVueloplaneado")
})
public class VueloPlaneado implements Serializable {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @NotNull
    private Aerolinea aerolinea;

    @NotNull
    @Size(min = 3, max = 3)
    private String codigoVuelo;

    @NotNull
    @Temporal(TemporalType.TIME)
    private java.util.Date horaSalida;

    @NotNull
    @Temporal(TemporalType.TIME)
    private java.util.Date horaLlegada;

    @Enumerated(EnumType.STRING)
    private Ciudad origen;

    @Enumerated(EnumType.STRING)
    private Ciudad destino;

    @Enumerated(EnumType.STRING)
    private DiaSemana diaSemana;

    @OneToMany(mappedBy = "vueloplaneado", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<VueloEspecifico> vuelosEspecificos = new ArrayList<VueloEspecifico>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Aerolinea getAerolinea() {
        return aerolinea;
    }

    public void setAerolinea(Aerolinea aerolinea) {
        this.aerolinea = aerolinea;
    }

    public String getcodigoVuelo() {
        return codigoVuelo;
    }

    public void setcodigoVuelo(String codigoVuelo) {
        this.codigoVuelo = codigoVuelo;
    }

    public Ciudad getorigen() {
        return origen;
    }

    public void setOrigen(Ciudad origen) {
        this.origen = origen;
    }

    public Ciudad getDestino() {
        return destino;
    }

    public void setDestino(Ciudad destino) {
        this.destino = destino;
    }

    public DiaSemana getdiaSemana() {
        return diaSemana;
    }

    public void setdiaSemana(DiaSemana diaSemana) {
        this.diaSemana = diaSemana;
    }

    public java.util.Date gethoraSalida() {
        return horaSalida;
    }

    public void sethoraSalida(java.util.Date horaSalida) {
        this.horaSalida = horaSalida;
    }

    public java.util.Date gethoraLlegada() {
        return horaLlegada;
    }

    public void sethoraLlegada(java.util.Date horaLlegada) {
        this.horaLlegada = horaLlegada;
    }

    public List<VueloEspecifico> getvuelosEspecificos() {
        return vuelosEspecificos;
    }

    public void setvuelosEspecificos(List<VueloEspecifico> vueloEspecifico) {
        this.vuelosEspecificos = vueloEspecifico;
    }

    @Override
    public String toString() {
        return String.format("%s[id=%d]", getClass().getSimpleName(), getId());
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
        VueloPlaneado other = (VueloPlaneado) obj;
        if (id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((codigoVuelo == null) ? 0 : codigoVuelo.hashCode());
        result = prime * result
                + ((horaLlegada == null) ? 0 : horaLlegada.hashCode());
        result = prime * result
                + ((horaSalida == null) ? 0 : horaSalida.hashCode());
        result = prime * result + (int) (id ^ (id >>> 32));
        return result;
    }
}
