package it.univaq.disim.mwt.teachify.business.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.imageio.ImageIO;
import javax.sql.DataSource;

import it.univaq.disim.mwt.teachify.business.BusinessException;
import it.univaq.disim.mwt.teachify.business.UserService;
import it.univaq.disim.mwt.teachify.business.model.Group;
import it.univaq.disim.mwt.teachify.business.model.User;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.stereotype.Service;

@Service
public class JDBCUserService implements UserService {
	
	@Value("#{cfgproperties.imagesPath}")
	private String imagesPath;
	@Value("#{cfgproperties.imagesFormat}")
	private String imagesFormat;
	
	
	@Autowired
	private DataSource dataSource;
	
	private static final Logger logger = Logger.getLogger(JDBCUserService.class);
	

	@Override
	public User authenticate(String u) throws BusinessException {

		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		User result = null;
		try {
			con = dataSource.getConnection();
			st = con.prepareStatement("SELECT * FROM users u WHERE u.email = ?");
			st.setString(1, u);
			rs = st.executeQuery();
			if (rs.next()) {
				long id = rs.getLong("user_id");
				String email = rs.getString("email");
				String password = rs.getString("password");
				String name = rs.getString("name");
				String surname = rs.getString("surname");
				Set<Group> groups = findGroups(u, con);
								
				result = new User(id ,email, password, name, surname, groups);

			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BusinessException(e);
		} 
		finally {
			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
				}
			}

		}
		return result;
	}



	private Set<Group> findGroups(String username, Connection con) throws BusinessException {
		PreparedStatement st = null;
		ResultSet rs = null;
		Set<Group> result = new HashSet<Group>();
		try {
			st = con.prepareStatement("SELECT g.* from  groups g , users u, users_groups ug where u.email = ? and u.user_id = ug.user_id and g.group_id = ug.group_id");
			st.setString(1, username);
			rs = st.executeQuery();
			while (rs.next()) {
				String groupName = rs.getString("name");
				result.add(new Group(groupName));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BusinessException(e);
		} finally {
			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
				}
			}
		}
		return result;
	}



	@Override
	public void createUser(User user) throws BusinessException {
		
		PreparedStatement pst = null;
		Statement st = null;
		ResultSet rs = null;
		Connection con = null;
		Long userId = null;
		Long groupId = null;
		try {
			con = dataSource.getConnection();
			String sql = "INSERT INTO users (user_id, email , password , name, surname) VALUES (USERS_SEQ.NEXTVAL,?,?,?,?)";
			pst = con.prepareStatement(sql);
			pst.setString(1, user.getEmail());
			pst.setString(2, user.getPassword());
			pst.setString(3, user.getName());
			pst.setString(4, user.getSurname());
			pst.executeUpdate();
			pst.close();
			
			sql = "SELECT user_id FROM users WHERE email = ?";
			pst = con.prepareStatement(sql);
			pst.setString(1, user.getEmail());
			rs = pst.executeQuery();
			if(rs.next()){
				userId = rs.getLong("user_id");
			}
			pst.close();
			
			sql = "SELECT group_id FROM groups WHERE name = 'student'";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			if(rs.next()){
				groupId = rs.getLong("group_id");
			}
			
			logger.info(userId + "   " + groupId);
			if( groupId != null  && userId != null){
				sql = "INSERT INTO users_groups (user_id, group_id) VALUES ( ?, ? )";
				pst = con.prepareStatement(sql);
				pst.setLong(1, userId);
				pst.setLong(2, groupId);
				pst.executeUpdate();
				
			}
			
			

		} catch (SQLException e) {
			e.printStackTrace();
			throw new BusinessException("Errore durante la creazione", e);

		} finally {

			try {
				con.close();
			} catch (SQLException e) {
			} catch (NullPointerException e) {
			}

			try {
				pst.close();
			} catch (SQLException e) {
			} catch (NullPointerException e) {
			}
			
			try {
				st.close();
			} catch (SQLException e) {
			} catch (NullPointerException e) {
			}
			try {
				rs.close();
			} catch (SQLException e) {
			} catch (NullPointerException e) {
			}
		}
	}



	
	@Override
	public void updateUser(User user) {
	    FileOutputStream fos;
		try {
			logger.info(imagesPath + user.getId() + '.' + imagesFormat);
			fos = new FileOutputStream(imagesPath + user.getId() + '.' + imagesFormat);
		    fos.write(user.getPhoto());
		    fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}



	@Override
	public User findUserById(long id) throws BusinessException {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		User result = null;
		try {
			con = dataSource.getConnection();
			st = con.prepareStatement("SELECT * FROM users u WHERE u.user_id = ?");
			st.setLong(1, id);
			rs = st.executeQuery();
			if (rs.next()) {

				String name = rs.getString("name");
				String surname = rs.getString("surname");
								
				result = new User();
				result.setId(id);
				result.setName(name);
				result.setSurname(surname);
				
				Path path = Paths.get(imagesPath + id + '.' + imagesFormat);
				byte[] img = Files.readAllBytes(path);
				result.setPhoto(img);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BusinessException(e);
		} catch (NoSuchFileException e){
			
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		finally {
			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
				}
			}

		}
		return result;
	}
	
	@Override
	public List<User> findAll() throws BusinessException {
		List<User> users = new ArrayList<User>();
		User cici = new User(1,"cici@gino.com", null, null, null, null);
		User coco = new User(2,"coco@gino.com", null, null, null, null);
		User cece = new User(3,"cece@gino.com", null, null, null, null);
		users.add(cece);
		users.add(coco);
		users.add(cici);
		return users;
	}

	@Override
	public void createAdmin(User user) throws BusinessException {
		user.setId(new Random().nextLong());

	}

	@Override
	public void deleteAdmin(User user) throws BusinessException {
		// TODO Auto-generated method stub

	}


	
	
	

}
