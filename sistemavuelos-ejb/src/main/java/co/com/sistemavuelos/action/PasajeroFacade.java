package co.com.sistemavuelos.action;

import co.com.sistemavuelos.model.Pasajero;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jhonlagos
 */
@Stateless
public class PasajeroFacade extends AbstractFacade<Pasajero> {

    @PersistenceContext(unitName = "sistemavuelos_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PasajeroFacade() {
        super(Pasajero.class);
    }
    
}
