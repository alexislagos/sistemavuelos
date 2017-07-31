package co.com.sistemavuelos.action;

import co.com.sistemavuelos.model.Agente;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jhonlagos
 */
@Stateless
public class AgenteFacade extends AbstractFacade<Agente> {

    @PersistenceContext(unitName = "sistemavuelos_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AgenteFacade() {
        super(Agente.class);
    }
    
}
