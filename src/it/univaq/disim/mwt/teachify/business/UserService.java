package it.univaq.disim.mwt.teachify.business;


import java.util.List;

import it.univaq.disim.mwt.teachify.business.model.User;


public interface UserService {
	
	User authenticate(String username) throws BusinessException;
	void createUser( User user) throws BusinessException;//
	void updateUser(User user);
	User findUserById(Long id) throws BusinessException;
	void createAdmin(User user) throws BusinessException;
	void deleteAdmin(User user) throws BusinessException;
	List<User> findAllAdmin() throws BusinessException;
}
