package controllers;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.Component;
import model.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import play.cache.Cache;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import services.IComponentService;
import util.AppInjector;
import util.ObjectSerilizer;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.protobuf.InvalidProtocolBufferException;


/**
 * This is a component configuration center
 * @author zafu
 *
 */
public class Application extends Controller {
	
	private static Logger log = LoggerFactory.getLogger(Application.class);
	
	private static IComponentService service;

    public IComponentService getService() {
		return service;
	}
    
    @Inject
	public void setService(IComponentService service) {
    	Application.service = service;
	}

    public static void init(){
    	Injector injector = Guice.createInjector(new AppInjector());
    	Application app = injector.getInstance(Application.class);
    	if( service == null )
    		service = app.getService();
    }

	public static Result index() {
		init();
		List<Component> cs = fakeCompService();
		for (Component component : cs) {
			service.addNewComponent(component, component.getId());
		}

        return ok("Your new application is ready.");
    }
    
    
    public static Result getSystemTable(){
    	if( Cache.get("systemInfo") != null ){
    		ObjectNode result = Json.newObject();
    		result.put("users", (JsonNode)Cache.get("SystemInfo"));
        	return ok(result);
    	}else{
    		ObjectNode result = Json.newObject();
        	JsonNode jn = Json.toJson(fakeService());    
        	Cache.set("systemInfo", jn ,60*5*1000);
        	result.put("users", jn);
        	return ok(result);
    	}  	
    }
    
    public static Result bookingHold(){
    	byte[] bookingMessages = request().body().asRaw().asBytes();
    	ObjectSerilizer os = new ObjectSerilizer();
    	Exception excep = null;
    	try {
			os.byteToObject(bookingMessages);
		} catch (InvalidProtocolBufferException e) {
			log.error(e.getMessage(), e);
			excep = e;
		}
    	if(excep == null){
    		return ok("ok");
    	}
    	return ok(excep.getMessage());
    }
    
    public static Result bookingCommit(byte[] commitMessages){
    	return null;
    }
    
    
    
    public static Result getUsers(){
    	return null;
    }
    
    public static Result getMainGrid(){
    	return null;
    }
    
    public static Result getGrid(int level){
    	return null;
    }
    
    private static List<Component> fakeCompService(){
    	User u1 = new User();
    	u1.setId(1);
    	u1.setUserName("user 1");
    	u1.setEmail("u1@test.com");
    	Component c = new Component();
    	c.setCreateDate(new Date());
    	c.setCreateUser(u1);
    	c.setId(1);
    	
    	return null;
    }
    
    private static List<User> fakeService(){
    	
    	List<User> l = new ArrayList<User>();
    	User u1 = new User();
    	u1.setId(1);
    	u1.setUserName("user 1");
    	u1.setEmail("u1@test.com");
    	
    	User u2 = new User();
    	u2.setId(2);
    	u2.setUserName("user 2");
    	u2.setEmail("u2@test.com");
    	
    	User u3 = new User();
    	u3.setId(3);
    	u3.setUserName("user 3");
    	u3.setEmail("u3@test.com");
    	
    	l.add(u1);
    	l.add(u2);
    	l.add(u3);
    	
    	return l;
    }
}
