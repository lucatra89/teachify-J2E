package it.univaq.disim.mwt.teachify.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.univaq.disim.mwt.teachify.business.BusinessException;
import it.univaq.disim.mwt.teachify.business.UserService;
import it.univaq.disim.mwt.teachify.business.model.User;
import it.univaq.disim.mwt.teachify.ejb.ManagerException;
import it.univaq.disim.mwt.teachify.ejb.UserManagerRemote;
@Service
public class RemoteUserService implements UserService {
	
	@Autowired
	private UserManagerRemote userManager;

	@Override
	public User authenticate(String username) throws BusinessException {
		try {
			return userManager.authenticate(username);
		} catch (ManagerException e) {
			throw new BusinessException(e);
		}
	}

	@Override
	public void createUser(User user) throws BusinessException {
		try {
			Long id = userManager.createUser(user);
			user.setId(id);
		} catch (ManagerException e) {
			throw new BusinessException(e);
		}

	}

	@Override
	public void updateUser(User user) {
		try {
			userManager.updateUser(user);
		} catch (ManagerException e) {
			throw new BusinessException(e);
		}

	}

	@Override
	public User findUserById(Long id) throws BusinessException {
		try {
			return userManager.findUserById(id);
		} catch (ManagerException e) {
			throw new BusinessException(e);
		}
	}

	@Override
	public void createAdmin(User user) throws BusinessException {
		try {
			Long id = userManager.createAdmin(user);
			user.setId(id);
		} catch (ManagerException e) {
			throw new BusinessException(e);
		}

	}

	@Override
	public void deleteAdmin(User user) throws BusinessException {
		try {
			userManager.deleteAdmin(user);
		} catch (Exception e) {
			throw new BusinessException(e);
		}

	}

	@Override
	public List<User> findAllAdmin() throws BusinessException {
		try {
			return userManager.findAllAdmin();
		} catch (Exception e) {
			throw new BusinessException(e);
		}
	}

}
