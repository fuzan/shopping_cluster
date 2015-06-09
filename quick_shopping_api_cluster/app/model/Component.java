package model;

import java.util.Date;
import java.util.List;

import com.google.gson.annotations.Expose;

import play.db.ebean.Model;

public class Component extends Model{
	/**
	 * 
	 */
	private static final long serialVersionUID = 9207240915786839614L;

	@Expose
    private int id;
	
	@Expose
    private String name;
    private int parentId;
    
    @Expose
    private Date createDate;
    @Expose
    private Date updateDate;
    @Expose
    private List<ComponentPair> valuePairs;
    
    @Expose
    private User createUser;
    
    @Expose
    private User lastModifyUser;
    
	public User getLastModifyUser() {
		return lastModifyUser;
	}
	public void setLastModifyUser(User lastModifyUser) {
		this.lastModifyUser = lastModifyUser;
	}
	public List<ComponentPair> getValuePairs() {
		return valuePairs;
	}
	public void setValuePairs(List<ComponentPair> valuePairs) {
		this.valuePairs = valuePairs;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public User getCreateUser() {
		return createUser;
	}
	public void setCreateUser(User createUser) {
		this.createUser = createUser;
	}
    
	class ComponentPair{
	    @Expose
		private String key;
	    @Expose
	    private Object value;
	    
		public String getKey() {
			return key;
		}
		public void setKey(String key) {
			this.key = key;
		}
		public Object getValue() {
			return value;
		}
		public void setValue(Object value) {
			this.value = value;
		}
	}    
    
}