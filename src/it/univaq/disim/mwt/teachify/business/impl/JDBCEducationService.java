package it.univaq.disim.mwt.teachify.business.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import it.univaq.disim.mwt.teachify.business.BusinessException;
import it.univaq.disim.mwt.teachify.business.EducationService;
import it.univaq.disim.mwt.teachify.business.model.Hour;
import it.univaq.disim.mwt.teachify.business.model.Price;
import it.univaq.disim.mwt.teachify.business.model.Subject;
import it.univaq.disim.mwt.teachify.business.model.TypeOfEducation;

@Service
public class JDBCEducationService implements EducationService {
	@Autowired
	private DataSource dataSource;
	

	@Override
	public List<Subject> findAllSubjects() throws BusinessException {
		
		Statement st = null;
		Connection con = null;
		ResultSet rs = null;
		List<Subject> result = new ArrayList<Subject>();
		
		
		try{
			
			String sql = "SELECT * FROM subjects ";
			con = dataSource.getConnection();
			st = con.createStatement();
			rs = st.executeQuery(sql);
			
			while(rs.next()){
				long id = rs.getLong("subject_id");
				String name = rs.getString("name");
				Subject subject = new Subject(id, name);
				result.add(subject);
			}

			
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BusinessException("Errore durante la ricerca dei subjects" , e);
		}finally{
			
			try{
				rs.close();
			}
			catch(SQLException e){}
			catch(NullPointerException e){}
			
			try {
				st.close();
			}
			catch (SQLException e) {}
			catch(NullPointerException e){}
			
			try {
				con.close();
			}
			catch (SQLException e) {}
			catch(NullPointerException e){}
			
		}
		return result;
	}

	@Override
	public List<TypeOfEducation> findAllTypesOfEducation() throws BusinessException {
		Statement st = null;
		Connection con = null;
		ResultSet rs = null;
		List<TypeOfEducation> result = new ArrayList<TypeOfEducation>();
		
		
		try{
			
			String sql = "SELECT * FROM types_of_education ";
			con = dataSource.getConnection();
			st = con.createStatement();
			rs = st.executeQuery(sql);
			
			while(rs.next()){
				long id = rs.getLong("type_of_education_id");
				String name = rs.getString("name");
				TypeOfEducation typeOfEducation = new TypeOfEducation(id, name);
				result.add(typeOfEducation);
			}

			
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BusinessException("Errore durante la ricerca dei types of education" , e);
		}finally{
			
			try{
				rs.close();
			}
			catch(SQLException e){}
			catch(NullPointerException e){}
			
			try {
				st.close();
			}
			catch (SQLException e) {}
			catch(NullPointerException e){}
			
			try {
				con.close();
			}
			catch (SQLException e) {}
			catch(NullPointerException e){}
			
		}
		return result;
	}

	@Override
	public List<Price> findAllPrices() throws BusinessException {
		
		Statement st = null;
		Connection con = null;
		ResultSet rs = null;
		List<Price> result = new ArrayList<Price>();
		
		
		try{
			
			String sql = "SELECT * FROM prices ";
			con = dataSource.getConnection();
			st = con.createStatement();
			rs = st.executeQuery(sql);
			
			while(rs.next()){
				long id = rs.getLong("price_id");
				int value = rs.getInt("value");
				Price price = new Price(id, value);
				result.add(price);
			}

			
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BusinessException("Errore durante la ricerca dei prices" , e);
		}finally{
			
			try{
				rs.close();
			}
			catch(SQLException e){}
			catch(NullPointerException e){}
			
			try {
				st.close();
			}
			catch (SQLException e) {}
			catch(NullPointerException e){}
			
			try {
				con.close();
			}
			catch (SQLException e) {}
			catch(NullPointerException e){}
			
		}
		return result;
	}


	@Override
	public List<Hour> findAllHours() throws BusinessException {
		Statement st = null;
		Connection con = null;
		ResultSet rs = null;
		List<Hour> result = new ArrayList<Hour>();
		
		
		try{
			
			String sql = "SELECT * FROM hours ";
			con = dataSource.getConnection();
			st = con.createStatement();
			rs = st.executeQuery(sql);
			
			while(rs.next()){
				long id = rs.getLong("hour_id");
				int value = rs.getInt("value");
				Hour hour = new Hour();
				hour.setId(id);
				hour.setValue(value);
				result.add(hour);
			}

			
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BusinessException("Errore durante la ricerca dei subjects" , e);
		}finally{
			
			try{
				rs.close();
			}
			catch(SQLException e){}
			catch(NullPointerException e){}
			
			try {
				st.close();
			}
			catch (SQLException e) {}
			catch(NullPointerException e){}
			
			try {
				con.close();
			}
			catch (SQLException e) {}
			catch(NullPointerException e){}
			
		}
		return result;
	}

	@Override
	public void createSubject(Subject subject) throws BusinessException {
		subject.setId(new Random().nextLong());

	}

	@Override
	public void updateSubject(Subject subject) {
		
	}

	@Override
	public void deleteSubject(Subject subject) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createTypeOfEducation(TypeOfEducation typeOfEducation) {
		typeOfEducation.setId(new Random().nextLong());
		
	}

	@Override
	public void updateTypeOfEducation(TypeOfEducation typeOfEducation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteTypeOfEducation(TypeOfEducation typeOfEducation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createPrice(Price price) throws BusinessException {
		price.setId(new Random().nextLong());
		
	}

	@Override
	public void deletePrice(Price price) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createHour(Hour hour) throws BusinessException {
		hour.setId(new Random().nextLong());
	}

	@Override
	public void deleteHour(Hour hour) throws BusinessException {

	}

}
