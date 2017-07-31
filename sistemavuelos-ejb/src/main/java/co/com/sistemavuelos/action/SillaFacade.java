package co.com.sistemavuelos.action;

import co.com.sistemavuelos.model.Silla;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jhonlagos
 */
@Stateless
public class SillaFacade extends AbstractFacade<Silla> {

    @PersistenceContext(unitName = "sistemavuelos_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SillaFacade() {
        super(Silla.class);
    }
    
}
