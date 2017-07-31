package co.com.sistemavuelos.control;

import co.com.sistemavuelos.action.RolFacade;
import co.com.sistemavuelos.model.Rol;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author jhonlagos
 */
@Named(value = "rolController")
@SessionScoped
public class RolController implements Serializable {
    private Rol rol;
    private List<Rol> roles;
    
    @EJB
    private RolFacade rolFacade;
    
    public RolController() {
        
    }
    
    /**
     * @return the rol
     */
    public Rol getRol() {
        return rol;
    }

    /**
     * @param rol the rol to set
     */
    public void setRol(Rol rol) {
        this.rol = rol;
    }

    /**
     * @return the roles
     */
    public List<Rol> getRoles() {
        return rolFacade.findAll();
    }

    /**
     * @param roles the roles to set
     */
    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }
}
