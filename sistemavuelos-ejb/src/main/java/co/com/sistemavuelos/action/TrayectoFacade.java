package co.com.sistemavuelos.action;

import co.com.sistemavuelos.model.Trayecto;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jhonlagos
 */
@Stateless
public class TrayectoFacade extends AbstractFacade<Trayecto> {

    @PersistenceContext(unitName = "sistemavuelos_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TrayectoFacade() {
        super(Trayecto.class);
    }
    
}
