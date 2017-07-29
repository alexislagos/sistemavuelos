package co.com.sistemavuelos.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;

/**
 *
 * @author jhonlagos
 */
@Entity
@NamedQueries({
    @NamedQuery(name="Trayecto.consultarTrayectosItinerario", query="SELECT t FROM Trayecto t WHERE t.itinerario.id = :idItinerario ORDER BY t.orden"),
    @NamedQuery(name="Trayecto.consultarTrayectoVueloEspecifico", query="SELECT t FROM Trayecto t WHERE t.itinerario.id = :idItinerario AND t.vueloEspecifico.id = :idVueloEspecifico"),
    @NamedQuery(name="Trayecto.consultarOrdenTrayecto", query="SELECT max(t.orden) FROM Trayecto t WHERE t.itinerario.id = :idItinerario"),
    @NamedQuery(name="Trayecto.consultarTrayectosOrden", query="SELECT t FROM Trayecto t WHERE t.itinerario.id = :idItinerario AND t.orden > :orden ORDER BY t.orden"),
    @NamedQuery(name="Trayecto.consultarTrayectosNoComprados", query="SELECT t FROM Trayecto t WHERE t.itinerario.id = :idItinerario AND t.comprado = false ORDER BY t.orden"),
})
public class Trayecto implements Serializable {
    
    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private long orden;

    @NotNull
    private boolean comprado;

    @ManyToOne
    @NotNull
    private VueloEspecifico vueloEspecifico;

    @ManyToOne
    @NotNull
    private Itinerario itinerario;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getOrden() {
        return orden;
    }

    public void setOrden(long orden) {
        this.orden = orden;
    }

    public boolean getComprado() {
        return comprado;
    }

    public void setComprado(boolean comprado) {
        this.comprado = comprado;
    }

    public VueloEspecifico getVueloEspecifico() {
        return vueloEspecifico;
    }

    public void setVueloEspecifico(VueloEspecifico vueloespecifico) {
        this.vueloEspecifico = vueloespecifico;
    }

    public Itinerario getItinerario() {
        return itinerario;
    }

    public void setItinerario(Itinerario itinerario) {
        this.itinerario = itinerario;
    }

    @Override
    public String toString() {
        return "Trayecto{" + "id=" + id + ", Orden=" + orden + ", Comprado=" + comprado + ", VueloEspecifico=" + vueloEspecifico + ", Itinerario=" + itinerario + '}';
    }
}
