package fr.adaming.dao;

import org.hibernate.NonUniqueResultException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Agent;

@Repository
public class AgentDaoImpl implements IAgentDao {

	@Autowired
	private SessionFactory sf;
	
	@Override
	public Agent getAgent(Agent agent) {
		String req = "FROM Agent a WHERE a.identifiant=:aID AND a.mdp=:mdpID";
		Query query = sf.getCurrentSession().createQuery("req");
		query.setParameter("aID", agent.getIdentifiant());
		query.setParameter("mdpID", agent.getMdp());
		
		Agent outAgent;
		
		try{
			outAgent = (Agent) query.uniqueResult();
		} catch (NonUniqueResultException ex){
			ex.printStackTrace();
			outAgent = null;
		}
		return outAgent;
	}

	@Override
	public Agent getAgentById(Agent agent) {
		return (Agent) sf.getCurrentSession().get(Agent.class, agent.getId());
	}

}
