package com.dps.controller;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.util.Locale;

import org.apache.logging.log4j.Logger;
import org.apache.commons.io.FilenameUtils;
import org.apache.logging.log4j.LogManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import com.dps.exception.InvalidOldPasswordException;
import com.dps.exception.ResourceNotFoundException;
import com.dps.repository.EventDetailsRepo;
import com.dps.repository.UserDetailsRepo;
import com.dps.repository.VideoDetailsRepo;
import com.dps.service.UserService;
import com.dps.utils.GenericResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.dps.repository.*;
import com.dps.service.*;
import com.dps.model.*;
import freemarker.template.Template;
//import freemarker.template.Configuration;

@RestController
@CrossOrigin
@RequestMapping("/dhyanpraveshika")
public class DPSController {
	
	
private static final Logger logger = LogManager.getLogger(DPSController.class);
	
	private static final String STATUS = "status";
	private static final String SUCCESS = "success";
	private static final String FAIL = "failed";
	private static final String MESSAGE = "msg";
	private static final String RESULT = "result";
	
	@Autowired
	private UserDetailsRepo userdetailsrepo;
	
	@Autowired
	private UserService userservice;
	
	@Autowired
	private VideoDetailsRepo videodetailsrepo;
	
	@Autowired
	private EventDetailsRepo eventdetailsrepo;
	
	@Autowired
	private BlogDetailsRepo blogdetailsrepo;
	
	@Autowired
    private MessageSource messages;
	
	@Autowired
	private EmailSenderService emailSenderService;
	
	@Autowired
	private UserServiceImpl userserviceimpl;
	
	@Autowired
    JdbcTemplate sql;
	
	@Autowired
	private ConfirmationTokenRepository confirmationTokenRepository;
	
	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
	
	private static final String folder = "D:\\Anirudh_Humbad\\DhyanPraveshika\\blogs";
	
	
			@PostMapping("/register")
			public ResponseEntity<Boolean> createUser(@RequestBody UserDetails userdetails, UriComponentsBuilder ucBuilder){
				logger.info("Add new user.....");
				
				UserDetails existingUser=null;
				try
				{
				existingUser = userservice.findByEmailIdIgnoreCase(userdetails.getEmail());
				if(existingUser != null) {
					logger.info("This email already exists!");
				}
				else
				{
					userdetails.setPassword(encoder.encode(userdetails.getPassword()));
					userservice.createUser(userdetails);
					logger.info("User added");

					HttpHeaders headers = new HttpHeaders();
					headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(userdetails.getId()).toUri());
					}
				}
				catch(Exception ex)
				{
					
				}
					return ResponseEntity.ok().cacheControl(CacheControl.maxAge(1, TimeUnit.SECONDS)).body(true);
				}
				@PostMapping("/forgot-password")
				public ResponseEntity<Boolean> forgotUserPassword(@RequestBody UserDetails userdetails)throws ResourceNotFoundException 
				{
				UserDetails forgotUser = userservice.findByEmailIdIgnoreCase(userdetails.getEmail());
				System.out.println("userdetails.getEmail()"+userdetails.getEmail());
				System.out.println("forgotUser.getEmail()"+forgotUser);
				if(forgotUser != null) {
					// create token
					ConfirmationToken confirmationToken = new ConfirmationToken(forgotUser);
					// save it
					confirmationTokenRepository.save(confirmationToken);
					// random password generation
					int length = 10;
					char[] password=userservice.geek_Password(length);
					String resetpwd=String.valueOf(password);
					logger.info("update profile with id"+forgotUser.getId());
			        UserDetails updateduser = userdetailsrepo.findById(forgotUser.getId())
			        .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + userdetails.getId()));
					if(updateduser!=null){
					updateduser.setPassword(resetpwd);
					userdetailsrepo.save(updateduser);
					}
					// Recipient's email ID needs to be mentioned.
				    String to = updateduser.getEmail();
				    // Sender's email ID needs to be mentioned
				    String from = "Info@shrikalyanika.org";
				    final String username = "Info@shrikalyanika.org";//change accordingly
				    final String passwordemail = "info@123";//change accordingly
				    // sending email through gmail
				    String host = "smtp.gmail.com";
				    Properties props = new Properties();
				      props.put("mail.smtp.auth", "true");
				      props.put("mail.smtp.starttls.enable", "true");
				      props.put("mail.smtp.host", host);
				      props.put("mail.smtp.port", "587");
				      // Get the Session object.
				      Session session = Session.getInstance(props,
				         new javax.mail.Authenticator() {
				            protected PasswordAuthentication getPasswordAuthentication() {
				               return new PasswordAuthentication(username, passwordemail);
				            }
					});
				    try {
				       Message message = new MimeMessage(session);
				       message.setFrom(new InternetAddress(from));
					   message.setRecipients(Message.RecipientType.TO,
				              InternetAddress.parse(to));
					   message.setSubject("Password Reset Successfully !");
					   message.setContent(
							  "<head>\r\n" + 
				              "  <title></title>\r\n" + 
				              "  <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n" + 
				              "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n" + 
				              "</head>\r\n" + 
				              "<body style=\"background: #ebebeb;\">\r\n" + 
				              "  <div style=\"max-width:550px;margin:35px auto 0; padding:15px;\">\r\n" + 
				              "    <div style=\"width:100%;box-shadow:0px 1px 5px rgba(44,80,102,0.5);border-radius:4px;overflow:hidden\">\r\n" + 
				              "		<div style=\"margin:0px auto 0;max-width:640px;\">\r\n" + 
				              "			<table role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" style=\"font-size:0px;width:100%; background: rgba(81,124,148,1);background: -moz-linear-gradient(top, rgba(81,124,148,1) 0%, rgba(60,98,120,1) 59%, rgba(44,80,102,1) 100%);background: -webkit-gradient(left top, left bottom, color-stop(0%, rgba(81,124,148,1)), color-stop(59%, rgba(60,98,120,1)), color-stop(100%, rgba(44,80,102,1)));background: -webkit-linear-gradient(top, rgba(81,124,148,1) 0%, rgba(60,98,120,1) 59%, rgba(44,80,102,1) 100%);background: -o-linear-gradient(top, rgba(81,124,148,1) 0%, rgba(60,98,120,1) 59%, rgba(44,80,102,1) 100%);background: -ms-linear-gradient(top, rgba(81,124,148,1) 0%, rgba(60,98,120,1) 59%, rgba(44,80,102,1) 100%);background: linear-gradient(to bottom, rgba(81,124,148,1) 0%, rgba(60,98,120,1) 59%, rgba(44,80,102,1) 100%);filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#517c94', endColorstr='#2c5066', GradientType=0 );\">\r\n" + 
				              "				<tbody>\r\n" + 
				              "					<tr>\r\n" + 
				              "						<td style=\"text-align:center;vertical-align:top;direction:ltr;font-size:0px;padding:35px 15px\">\r\n" + 
				              "							<div style=\"cursor:auto;color:white;font-family:sans-serif;font-size:32px;font-weight:600;line-height:30px;text-align:center;\">Dhyan Praveshika</div>\r\n" + 
				              "						</td>\r\n" + 
				              "					</tr>\r\n" + 
				              "				</tbody>\r\n" + 
				              "			</table>\r\n" + 
				              "		</div>\r\n" + 
				              "		<div style=\"margin:0px auto;max-width:640px;background:#ffffff;\">\r\n" + 
				              "			<table role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" style=\"font-size:0px;width:100%;background:#ffffff;\" align=\"center\" border=\"0\">\r\n" + 
				              "				<tbody>\r\n" + 
				              "					<tr>\r\n" + 
				              "						<td style=\"text-align:center;vertical-align:top;direction:ltr;font-size:0px;padding:40px 25px;\">\r\n" + 
				              "							<div aria-labelledby=\"mj-column-per-100\" class=\"mj-column-per-100 outlook-group-fix\" style=\"vertical-align:top;display:inline-block;direction:ltr;font-size:13px;text-align:left;width:100%;max-width: 450px;\">\r\n" + 
				              "								<table role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\r\n" + 
				              "									<tbody>\r\n" + 
				              "										<tr>\r\n" + 
				              "											<td style=\"word-break:break-word;font-size:0px;padding:0px 0px 20px;\" align=\"left\">\r\n" + 
				              "												<div style=\"cursor:auto;color:#737F8D;font-family:sans-serif;font-size:16px;line-height:24px;text-align:left;\">													\r\n" + 
				              "													<h2 style=\"font-family: sans-serif;font-weight: 500;font-size: 20px;color: #4F545C;letter-spacing: 0.27px;\">"+ forgotUser.getFull_name()+",</h2>\r\n" + 
				              "													<p>Your password has been reset.</p>\r\n" + 
				              "													<p>Kindly login to the application using the below password</p>\r\n" + 
				              "													<p>Password:- <b>"+resetpwd+"</b></p>	\r\n"+ 
				              "													<p>You can change the password from the Profile later.</p>\r\n" + 
				              "												</div>\r\n" + 
				              "											</td>\r\n" + 
				              "										</tr>\r\n" + 
				              "									</tbody>\r\n" + 
				              "								</table>\r\n" + 
				              "							</div>\r\n" + 
				              "						</td>\r\n" + 
				              "					</tr>\r\n" + 
				              "				</tbody>\r\n" + 
				              "			</table>\r\n" + 
				              "		</div>\r\n" + 
				              "	</div>\r\n" + 
				              "  </div>\r\n" + 
				              "</body>",
				             "text/html");

					   // Send message
					   Transport.send(message);
					   logger.info("Sent message successfully....");
					   System.out.println("Sent message successfully....");
					   } catch (MessagingException e) {
				    	  logger.info("Error in sending mail");
					   throw new RuntimeException(e);
				      }
					logger.info("Request to reset password received. Check your inbox for the reset link.");
					logger.info("successForgotPassword");
					}
			      	else {	
					logger.info("This email does not exist!");
					logger.info("error");
				}
				return ResponseEntity.ok().cacheControl(CacheControl.maxAge(1, TimeUnit.SECONDS)).body(true);
			}
			
			@GetMapping("/getVideos")
		    public List <VideoDetails> getAllVideo() {
				logger.info("Get all videos");
				try
				{
					
				}
				catch(Exception ex)
				{
					
				}
		        return (List<VideoDetails>) videodetailsrepo.findAll();
		    }
			@GetMapping("/getEvents")
		    public List <EventDetails> getAllEvent() {
				logger.info("Get all event");
				try
				{
					
				}
				catch(Exception ex)
				{
					
				}
		        return (List<EventDetails>) eventdetailsrepo.findAll();
		    }
			
			@GetMapping("/getProfiles")
		    public List <UserDetails> getAllUser() {
				try
				{
					
				}
				catch(Exception ex)
				{
					
				}
		        return (List<UserDetails>) userdetailsrepo.findAll();
		    }
			
			@GetMapping("/getBlogs")
			public List<BlogDetails> getAllBlogs() {
				
				List<BlogDetails> availableBlogs = new ArrayList<BlogDetails>();
				SqlRowSet rowSet=null;
				try
				{
				rowSet = sql.queryForRowSet("SELECT * from dps_blog");
				logger.info("In get blog");
				while(rowSet.next()){
					
					BlogDetails blogDetails=new BlogDetails();
					Long id=rowSet.getLong("id");
					String title=rowSet.getString("title");
					String description=rowSet.getString("description");
					String author=rowSet.getString("author");
					String category=rowSet.getString("category");
					String created_Date=rowSet.getString("created_Date");
					
					File file = new File(folder);
					File[] files = file.listFiles((dir, name) -> name.startsWith(id + "_"));
					File articleImage = null;
					String ext = "";
					if (files.length > 0) {
					for (File f : files) {
					articleImage = new File(f.getAbsolutePath());
					logger.info("eventImage:{}", articleImage.getAbsolutePath());
					ext = FilenameUtils.getExtension(articleImage.getName());
					logger.info("ext:{}", ext);
					}
					}
					blogDetails.setId(id);
					blogDetails.setTitle(title);
					blogDetails.setDescription(description);
					blogDetails.setAuthor(author);
					blogDetails.setCategory(category);
					blogDetails.setCreated_Date(created_Date);
					blogDetails.setPathURI(articleImage);
					
					availableBlogs.add(blogDetails);
				}
				}
				catch(Exception ex)
				{
					
				}
				logger.info("successfully get the blog details");
				return availableBlogs;
			}
			
			@GetMapping("/search/{searchPara}")
			public ResponseEntity<BlogDetails> getRecordByParameter(@PathVariable(value = "searchPara") String searchPara)
			        throws ResourceNotFoundException {
				BlogDetails blogdetails=null;
				logger.info("Geting record according search parameter");
				try
				{
				blogdetails=blogdetailsrepo.searchByParam(searchPara);
				Long id=blogdetails.getId();
				
				File file = new File(folder);
				File[] files = file.listFiles((dir, name) -> name.startsWith(id+ "_"));
				File articleImage = null;
				String ext = "";
				if (files.length > 0) {
				for (File f : files) {
				articleImage = new File(f.getAbsolutePath());
				logger.info("eventImage:{}", articleImage.getAbsolutePath());
				ext = FilenameUtils.getExtension(articleImage.getName());
				logger.info("ext:{}", ext);
				}
				}
				blogdetails.setPathURI(articleImage);
				logger.info("Get the record successfully according to the search parameter");
				}
				catch(Exception ex)
				{
					
				}
			return ResponseEntity.ok().body(blogdetails);
			}
			
			@GetMapping("/getProfile/{id}")
			public ResponseEntity<UserDetails> getEmployeeById(@PathVariable(value = "id") Long userId)
			        throws ResourceNotFoundException {
					UserDetails employee=null;
					logger.info("Geting particular information");
					try
					{
			         employee = userdetailsrepo.findById(userId)
			          .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + userId));
			         
			         
			         logger.info("Get the profile successfully");
					}
					catch(Exception ex)
					{
						logger.info("Error in getting profile");
						
					}
			        return ResponseEntity.ok().body(employee);
			}
			
			@GetMapping("/getBlog/{id}")
			public ResponseEntity<BlogDetails> getBlogById(@PathVariable(value = "id") Long blogId)
			        throws ResourceNotFoundException {
					BlogDetails blog=null;
					try
					{
			        blog = blogdetailsrepo.findById(blogId)
			          .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + blogId));
					}
					catch (Exception ex) {
						
					}
			        return ResponseEntity.ok().body(blog);
			}
			@PutMapping("/updateProfile/{id}")
		    public ResponseEntity<UserDetails> updateEmployee(@PathVariable(value = "id") Long userId,
		         @RequestBody UserDetails userDetails) throws ResourceNotFoundException {
				logger.info("update profile with id"+userId);
				UserDetails user=null;
				UserDetails updatedUser=null;
				try
				{
		        user = userdetailsrepo.findById(userId)
		        .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + userId));
		        user.setFull_name(userDetails.getFull_name());
		        user.setEmail(userDetails.getEmail());
		        user.setPhone_no(userDetails.getPhone_no());
		        user.setAge(userDetails.getAge());
		        user.setPassword(userDetails.getPassword());
		        user.setCountry(userDetails.getCountry());
		        user.setState(userDetails.getState());
		        user.setCity(userDetails.getCity());
		        user.setFcm_token(userDetails.getFcm_token());
		        
		        updatedUser = userdetailsrepo.save(user);
		        logger.info("update profile success with id"+userId);
				}
				catch(Exception ex)
				{
					
				}
		        return ResponseEntity.ok(updatedUser);
		    }
			@DeleteMapping("/deleteProfile/{id}")
		    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long userId)
		         throws ResourceNotFoundException {
				logger.info("in delete profile");
				UserDetails user=null;
				Map<String, Boolean> response = new HashMap<>();
				try
				{
		        user = userdetailsrepo.findById(userId)
		       .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + userId));
		        userdetailsrepo.delete(user);
		        response.put("deleted", Boolean.TRUE);
		        logger.info("profile deleted successfully");
				}
				catch (Exception ex) {
					
				}
		        return response;
		    }
			@GetMapping("/login/{email}/{password}/{fcm_token}")
			public ResponseEntity<Map<String, Object>> getEmployeeById(@PathVariable(value = "email") String email,
					@PathVariable(value = "password") String password,
					@PathVariable(value = "fcm_token") String fcm_token)
				throws ResourceNotFoundException {
				logger.info("inside login");
				UserDetails userdetails=null;
				Map<String, Object> map = new HashMap<String, Object>();
				try
				{
				userdetails=userdetailsrepo.findByEmail(email);
			    userdetails.setFcm_token(fcm_token);
			    final UserDetails updatefcm = userdetailsrepo.save(userdetails);
			    if(userdetails.getPassword().equals(password))
				{
			     logger.info("Login success..");
			     map.put(RESULT, userdetails);
			     map.put(STATUS, SUCCESS);}
				else{
					logger.info("User or Password incorrect");
					map.put(STATUS, FAIL);
					map.put(MESSAGE, "User or Password incorrect");}
				}
				catch(Exception ex)
				{
					
				}
			     	return ResponseEntity.ok(map);
			}
			
			@GetMapping("/updatePassword/{email}/{password}/{oldpassword}")
			public void changeUserPassword(
			  @PathVariable(value = "email") String email,
			  @PathVariable(value = "password") String password,
			  @PathVariable(value = "oldpassword") String oldPassword) {
				logger.info("In update password");
				UserDetails user=null;
				try
				{
				user = userservice.findUserByEmail(email);
				if (!userservice.checkIfValidOldPassword(user, oldPassword)) {
					logger.info("Invalid old password");
			        throw new InvalidOldPasswordException();
			    }
			    userservice.changeUserPassword(user, password);
			    logger.info("password changed successfuly");
				}
				catch(Exception ex)
				{
					
				}
			}
		}
	
	


