package services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import domain.Actor;
import repositories.ActorRepository;

@Service
@Transactional
public class ActorService {

	// Managed repository -------------------------
	
	@Autowired
	private ActorRepository actorRepository;
	
	// Supporting services ------------------------
	
	// Constructor --------------------------------
	
	public ActorService() {
		super();
	}
	
	//Simple CRUD methods -------------------------
	
	public Actor save(Actor actor) {
		Assert.notNull(actor);
		
		Actor result;
		
		result = actorRepository.save(actor);
		
		return result;
	}
}
