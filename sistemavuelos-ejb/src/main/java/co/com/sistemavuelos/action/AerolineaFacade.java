package co.com.sistemavuelos.action;

import co.com.sistemavuelos.model.Aerolinea;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jhonlagos
 */
@Stateless
public class AerolineaFacade extends AbstractFacade<Aerolinea> {

    @PersistenceContext(unitName = "sistemavuelos_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AerolineaFacade() {
        super(Aerolinea.class);
    }
    
}
