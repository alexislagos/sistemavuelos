package co.com.sistemavuelos.action;

import co.com.sistemavuelos.model.VueloPlaneado;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jhonlagos
 */
@Stateless
public class VueloPlaneadoFacade extends AbstractFacade<VueloPlaneado> {

    @PersistenceContext(unitName = "sistemavuelos_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VueloPlaneadoFacade() {
        super(VueloPlaneado.class);
    }
    
}
