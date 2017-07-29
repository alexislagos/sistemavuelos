package co.com.sistemavuelos.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 *
 * @author jhonlagos
 */
@Entity
@NamedQueries({
    @NamedQuery(name="VueloEspecifico.consultarVuelosEspecificos", query="select ve from VueloEspecifico ve" ),
    @NamedQuery(name="VueloEspecifico.consultarVuelosDisponibles", query="select ve from VueloEspecifico ve where ve.vueloplaneado.origen = :ciudadOrigen and ve.vueloplaneado.destino = :ciudadDestino and ve.fechaSalida =:fechaSalida" )
})
public class VueloEspecifico implements Serializable {
    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @NotNull
    private VueloPlaneado vueloplaneado;

    @NotNull
    @Temporal(TemporalType.DATE)
    private java.util.Date fechaSalida;

    @NotNull
    @Temporal(TemporalType.DATE)
    private java.util.Date fechaLlegada;

    @Min(0)
    @Max(8000000)
    private long tarifa;

    @OneToMany(mappedBy = "vueloEspecifico", cascade = CascadeType.ALL)
    private List<Trayecto> trayectos = new ArrayList<Trayecto>();

    @OneToMany(mappedBy = "vueloEspecifico", cascade = CascadeType.ALL)
    private List<Silla> sillas = new ArrayList<Silla>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public VueloPlaneado getvueloPlaneado() {
        return vueloplaneado;
    }

    public void setvueloPlaneado(VueloPlaneado vueloPlaneado) {
        this.vueloplaneado = vueloPlaneado;
    }

    public java.util.Date getfechaSalida() {
        return fechaSalida;
    }

    public void setfechaSalida(java.util.Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public java.util.Date getfechaLlegada() {
        return fechaLlegada;
    }

    public void setfechaLlegada(java.util.Date fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    public long getTarifa() {
        return tarifa;
    }

    public void setTarifa(long tarifa) {
        this.tarifa = tarifa;
    }

    public List<Trayecto> getTrayectos() {
        return trayectos;
    }

    public void setTrayectos(List<Trayecto> trayectos) {
        this.trayectos = trayectos;
    }

    public List<Silla> getSillas() {
        return sillas;
    }

    public void setSillas(List<Silla> sillas) {
        this.sillas = sillas;
    }

    @Override
    public String toString() {
        return "VueloEspecifico{" + "id=" + id + ", fechaSalida=" + fechaSalida + ", fechaLlegada=" + fechaLlegada + ", tarifa=" + tarifa + '}';
    }
}
