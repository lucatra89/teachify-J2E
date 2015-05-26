package it.univaq.disim.mwt.teachify.business.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import it.univaq.disim.mwt.teachify.business.BusinessException;
import it.univaq.disim.mwt.teachify.business.TutorService;
import it.univaq.disim.mwt.teachify.business.model.Availability;
import it.univaq.disim.mwt.teachify.business.model.Contact;
import it.univaq.disim.mwt.teachify.business.model.Day;
import it.univaq.disim.mwt.teachify.business.model.Feedback;
import it.univaq.disim.mwt.teachify.business.model.Group;
import it.univaq.disim.mwt.teachify.business.model.Hour;
import it.univaq.disim.mwt.teachify.business.model.Lesson;
import it.univaq.disim.mwt.teachify.business.model.Location;
import it.univaq.disim.mwt.teachify.business.model.Price;
import it.univaq.disim.mwt.teachify.business.model.Request;
import it.univaq.disim.mwt.teachify.business.model.RequestTutors;
import it.univaq.disim.mwt.teachify.business.model.StatusRequest;
import it.univaq.disim.mwt.teachify.business.model.Subject;
import it.univaq.disim.mwt.teachify.business.model.Tutor;
import it.univaq.disim.mwt.teachify.business.model.TypeOfEducation;
import it.univaq.disim.mwt.teachify.business.model.User;
@Service
public class JDBCTutorService implements TutorService {
	@Value("#{cfgproperties.imagesPath}")
	private String imagesPath;
	@Value("#{cfgproperties.imagesFormat}")
	private String imagesFormat;
	
	@Autowired
	private DataSource dataSource;
	private static Logger logger = Logger.getLogger(JDBCTutorService.class);
	
	@Override
	public void createTutor(Tutor tutor) throws BusinessException {
		logger.info(tutor.getLocation().getLatitude() + " " + tutor.getLocation().getLongitude() +" "+ tutor.getLocation().getName() );

	}

	@Override
	public void upgradeToTutor(Tutor tutor) throws BusinessException {
		PreparedStatement pst = null;
		Statement st = null;
		ResultSet rs = null;
		Connection con = null;
		Long groupId = null;
		

		try {
			con = dataSource.getConnection();
			String sql = "INSERT INTO tutors (tutor_id , user_id, location_name,tutor_geo_location) VALUES (TUTORS_SEQ.NEXTVAL,?,?,SDO_GEOMETRY(2001, 8307, SDO_POINT_TYPE (?,?,NULL), NULL, NULL))";
			pst = con.prepareStatement(sql);
			pst.setLong(1, tutor.getId());
			pst.setString(2,tutor.getLocation().getName());
			pst.setFloat(3,tutor.getLocation().getLatitude());
			pst.setFloat(4, tutor.getLocation().getLongitude()) ;
			pst.executeUpdate();
			pst.close();
									
			sql = "SELECT group_id FROM groups WHERE name = 'tutor'";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			if(rs.next()){
				groupId = rs.getLong("group_id");
			}
			
			
			if(groupId != null){
				sql = "INSERT INTO users_groups (user_id, group_id) VALUES ( ?, ? )";
				pst = con.prepareStatement(sql);
				pst.setLong(1, tutor.getId());
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
	public List<Tutor> searchTutors(RequestTutors request) {
		PreparedStatement st = null;
		Connection con = null;
		ResultSet rs = null;
		List<Tutor> result = new ArrayList<Tutor>();
		
		
		try{
			
			String sql = "SELECT u.user_id, u.name , u.surname, sdo_nn_distance (1) distance, p.x as latitude, p.y as longitude "
						+ "FROM tutors t , users u, table(sdo_util.getvertices(t.tutor_geo_location)) p "
						+ "WHERE t.user_id = u.user_id "
						+ "AND sdo_nn (t.tutor_geo_location, SDO_GEOMETRY(2001, 8307, SDO_POINT_TYPE (? , ? ,NULL), NULL, NULL),'sdo_num_res=3', 1)= 'TRUE' "
						+ "ORDER BY distance ";
			con = dataSource.getConnection();
			st = con.prepareStatement(sql);
			st.setFloat(1, request.getLatitude());
			st.setFloat(2, request.getLongitude());
			
			rs = st.executeQuery();
			
			while(rs.next()){
				long id = rs.getLong("user_id");
				String surname = rs.getString("name");
				String name = rs.getString("surname");
				long distance = rs.getLong("distance");
				float latitude = rs.getFloat("latitude");
				float longitude = rs.getFloat("longitude");
				byte[] img = {};
				
				Tutor tutor = new Tutor();
				Location location = new Location();
				location.setLatitude(latitude);
				location.setLongitude(longitude);
				
				Path path = Paths.get(imagesPath + id + '.' + imagesFormat);
				try {
					img = Files.readAllBytes(path);
				} catch (IOException e) {}
				
				tutor.setId(id);
				tutor.setName(name);
				tutor.setSurname(surname);
				tutor.setDistance(distance);
				tutor.setLocation(location);
				
				tutor.setPhoto(img);

				result.add(tutor);
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
	public Tutor findTutorByPk(long id) {

		Connection con = null;
		PreparedStatement st = null;
		Tutor result = null;
		try {
			con = dataSource.getConnection();
			st = con.prepareStatement("SELECT u.* , t.*, p.x as latitude, p.y as longitude FROM users u , tutors t , table(sdo_util.getvertices(t.tutor_geo_location)) p  WHERE u.user_id = ? AND u.user_id = t.user_id" );
			st.setLong(1, id);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				String name = rs.getString("name");
				String surname = rs.getString("surname");
				String description = rs.getString("description");
				String locationName = rs.getString("location_name");
				float latitude = rs.getFloat("latitude");
				float longitude = rs.getFloat("longitude");
				
				Contact contact = new Contact();
				contact.setEmail("baaahh@mbu.com");
				contact.setSkype("gino.bello");
				
				Location location = new Location();
				location.setName(locationName);
				location.setLatitude(latitude);
				location.setLongitude(longitude);
				
				Set<Feedback> feedback = new HashSet<Feedback>();
				Date now = new Date();
				Date before = new Date();
				before.setHours(9);;
				
				feedback.add(new Feedback("bravissimo", 4,now, new User(null, null , "Lobiola", "Puzzi", null), null));
				feedback.add(new Feedback("Fai veramente pena!", 1 , before, new User(null, null , "Ciico", "Bastardo", null), null));
				
				
				Set<Lesson> lessons = new HashSet<Lesson>();
				lessons.add(new Lesson(1, new Subject(1, "Matematica"), new TypeOfEducation(2, "Medie"),null));
				lessons.add(new Lesson(2 ,new Subject(1, "Matematica"), new TypeOfEducation(3, "Superiori"), null));
				lessons.add(new Lesson(3 , new Subject(2, "Fisica"), new TypeOfEducation(3, "Superiori"),  null));
				lessons.add(new Lesson(4 ,new Subject(2, "Fisica"), new TypeOfEducation(21, "Università"),  null));
				
				Set<Availability> availabilities = new HashSet<Availability>();
				availabilities.add(new Availability(Day.Monday, new Hour(8), new Hour(12)));
				availabilities.add(new Availability(Day.Monday, new Hour(14), new Hour(20)));
				availabilities.add(new Availability(Day.Friday, new Hour(9), new Hour(14)));
				availabilities.add(new Availability(Day.Wednesday, new Hour(12), new Hour(15)));
				availabilities.add(new Availability(Day.Wednesday, new Hour(18), new Hour(21)));
				
				
				
				Set<Request> requests = new HashSet<Request>();
				Request request = new Request();
				request.setStatus(StatusRequest.Accepted);
				requests.add(request);
				
				
				byte[] img = {};
				Path path = Paths.get(imagesPath + id + '.' + imagesFormat);
				try {
					img = Files.readAllBytes(path);
				} catch (IOException e) {}

				
				
				result = new Tutor();
				result.setId(id);
				result.setLocation(location);
				result.setName(name);
				result.setSurname(surname);
				result.setDescription(description);
				result.setFeedbacks(feedback);
				result.setRating(4.2f);
				result.setLessons(lessons);
				result.setPrice(new Price(3,55));
				result.setAvailabilities(availabilities);
				result.setRequests(requests);
				result.setPhoto(img);
				result.setContact(contact);
				
				
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
	public void createFeedback(Feedback feedback) {
		
		logger.info(feedback.getRating() + " " + feedback.getDescription());
		
	}

	@Override
	public void createRequest(Request request) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Feedback> findAllFeedback(Tutor tutor) {
		List<Feedback> list = new ArrayList<Feedback>();
		Feedback a = new Feedback(1, null, 4, null, null, null);
		Feedback b = new Feedback(2, null, 4, null, null, null);
		Feedback c = new Feedback(3, null, 4, null, null, null);
		Feedback d = new Feedback(4, null, 4, null, null, null);
		Feedback e = new Feedback(5, null, 4, null, null, null);
		Feedback f = new Feedback(6, null, 4, null, null, null);
		Feedback g = new Feedback(7, null, 4, null, null, null);
		Feedback h = new Feedback(8, null, 4, null, null, null);
		list.add(a);
		list.add(b);
		list.add(c);
		list.add(d);
		list.add(e);
		list.add(f);
		list.add(g);
		list.add(h);
		
		return list;
	}

	@Override
	public void updateStatusRequest(Request request) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Request> findWaitingRequestsByTutor(Tutor tutor) throws BusinessException {
		List<Request> list = new ArrayList<Request>();
		
		
		Request a = new Request();
		Request b = new Request();
		Request c = new Request();
		
		a.setId(1);
		b.setId(2);
		c.setId(3);
		
		a.setTutor(tutor);
		b.setTutor(tutor);
		c.setTutor(tutor);
		
		a.setUser(findTutorByPk(1));
		b.setUser(findTutorByPk(2));
		c.setUser(findTutorByPk(3));
		
		a.setDescription("nde bell");
		b.setDescription("voccapè");
		c.setDescription("ndund");
		
		a.setStatus(StatusRequest.Waiting);
		b.setStatus(StatusRequest.Waiting);
		c.setStatus(StatusRequest.Waiting);
		
		a.setCreatedAt(new Date());
		b.setCreatedAt(new Date());
		c.setCreatedAt(new Date());

		list.add(a);
		list.add(b);
		list.add(c);
		return list;
	}

	@Override
	public List<Request> findRequestsByUser(User user) throws BusinessException {
		List<Request> list = new ArrayList<Request>();
		
		
		Request a = new Request();
		Request b = new Request();
		Request c = new Request();
		Request d = new Request();
				
		a.setId(1);
		b.setId(2);
		c.setId(3);
		d.setId(3);
		
		a.setUser(user);
		b.setUser(user);
		c.setUser(user);
		d.setUser(user);
		
		a.setTutor(findTutorByPk(1));
		b.setTutor(findTutorByPk(2));
		c.setTutor(findTutorByPk(3));
		d.setTutor(findTutorByPk(3));
		
		a.setDescription("nde bell");
		b.setDescription("voccapè");
		c.setDescription("ndund");
		d.setDescription("ndund");
		
		a.setStatus(StatusRequest.Accepted);
		b.setStatus(StatusRequest.Waiting);
		c.setStatus(StatusRequest.Waiting);
		d.setStatus(StatusRequest.Accepted);
		
		list.add(a);
		list.add(b);
		list.add(c);
		list.add(d);
		
		return list;
	}

	@Override
	public StatusRequest statusOfRequest(User user, Tutor tutor) throws BusinessException {
		StatusRequest statusRequest = StatusRequest.Accepted; 
		return statusRequest;
	}

	@Override
	public void updateTutorDescription(Tutor tutor) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateTutorLocation(Tutor tutor) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateTutorPrice(Tutor tutor) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addLesson(Lesson lesson) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteLesson(Lesson lesson) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addAvailability(Availability availability) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAvailability(Availability availability) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateTutorContact(Tutor tutor) throws BusinessException {
		Contact contact = tutor.getContact();
		logger.info(contact.getEmail());
		logger.info(contact.getSkype());
		logger.info(contact.getTelephone());
		
	}

	@Override
	public Feedback findFeedbackById(long id) throws BusinessException {
		Feedback feedback = new Feedback();
		feedback.setCreatedAt(new Date());
		feedback.setUser(findTutorByPk(2)); 
		feedback.setRating(4);
		feedback.setDescription("ccaf cafgcdgafd fgacdfcagdcaf dcfgacd affcdgfac fdca gfc df afdcfga gcacdag fcdafc");
		return feedback;
	}


}
