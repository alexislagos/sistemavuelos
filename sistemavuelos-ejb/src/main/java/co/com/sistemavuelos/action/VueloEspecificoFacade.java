package co.com.sistemavuelos.action;

import co.com.sistemavuelos.model.VueloEspecifico;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jhonlagos
 */
@Stateless
public class VueloEspecificoFacade extends AbstractFacade<VueloEspecifico> {

    @PersistenceContext(unitName = "sistemavuelos_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VueloEspecificoFacade() {
        super(VueloEspecifico.class);
    }
    
}
