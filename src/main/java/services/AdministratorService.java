package services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import domain.Administrator;
import repositories.AdministratorRepository;
import security.LoginService;
import security.UserAccount;;

@Service
@Transactional
public class AdministratorService {
	
	// Managed repository -------------------------
	
	@Autowired
	private AdministratorRepository administratorRepository;
	
	// Supporting services ------------------------
	
	// Constructor --------------------------------
	
	public AdministratorService() {
		super();
	}
	
	//Simple CRUD methods -------------------------
	
	public Administrator create() {
		Administrator result;
		
		result = new Administrator();
		
		return result;
	}
	
	public Administrator save(Administrator administrator) {
		Assert.notNull(administrator);
		
		Administrator result;
		
		result = administratorRepository.save(administrator);
		
		return result;
	}
	
	public void delete (Administrator administrator) {
		Assert.notNull(administrator);
		
		Assert.isTrue(administrator.getId() != 0);
		
		administratorRepository.delete(administrator);
	}
	public Administrator findByPrincipal() {
		Administrator result;
		UserAccount userAccount;
		
		userAccount= LoginService.getPrincipal();
		Assert.notNull(userAccount);
		result = findByUserAccount(userAccount);
		Assert.notNull(result);
		
		return result;
	}
	public Administrator findByUserAccount(UserAccount userAccount) {
		Assert.notNull(userAccount);
		
		Administrator result;
		
		result = administratorRepository.findByUserAccountId(userAccount.getId());
		
		return result;
		
	}
}
