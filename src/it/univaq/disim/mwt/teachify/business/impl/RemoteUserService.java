package it.univaq.disim.mwt.teachify.business.impl;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import it.univaq.disim.mwt.teachify.business.BusinessException;
import it.univaq.disim.mwt.teachify.business.UserService;
import it.univaq.disim.mwt.teachify.business.model.User;
import it.univaq.disim.mwt.teachify.ejb.ManagerException;
import it.univaq.disim.mwt.teachify.ejb.UserManagerRemote;
@Service
public class RemoteUserService implements UserService {
	@Value("#{cfgproperties.imagesPath}")
	private String imagesPath;
	@Value("#{cfgproperties.imagesFormat}")
	private String imagesFormat;
	
	@Autowired
	private UserManagerRemote userManager;
	
	private byte[] findProfileImg(Long id){
		Path path = Paths.get(imagesPath + id + '.' + imagesFormat);
		try {
			System.out.println("----------------------OK");
			byte[]  bytes = Files.readAllBytes(path);
			System.out.println(bytes.length);
			return bytes;
		} catch (IOException e) {
			System.out.println("------------Errore");
		}
		
		return null;
	}
	
	private void saveUserPhoto(User user) throws BusinessException {
	    FileOutputStream fos;
		try {
			fos = new FileOutputStream(imagesPath + user.getId() + '.' + imagesFormat);
		    fos.write(user.getPhoto());
		    fos.close();
		}catch(IOException e){
			throw new BusinessException("Errore nel salvataggio dell'immagine", e);
		}
	}

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
			saveUserPhoto(user);
		} catch (ManagerException e) {
			throw new BusinessException(e);
		} 

	}

	@Override
	public User findUserById(Long id) throws BusinessException {
		User user = null;
		try {
			user = userManager.findUserById(id);
			user.setPhoto(findProfileImg(id));

		} catch (ManagerException e) {
			throw new BusinessException(e);
		} 
		
		return user;
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
