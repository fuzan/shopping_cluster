package dao;

import java.util.HashMap;
import java.util.Map;

import model.Component;

public class ComponentDAO implements IComponentDAO{

	private Map<Integer,Component> map = new HashMap<Integer,Component>();
	
	@Override
	public Component getComponentByID(int id) {
		// TODO Auto-generated method stub
		if( map.containsKey(id) ){
			return map.get(id);
		}
		return null;
	}

	@Override
	public void saveComponent(Component com) {
		// TODO Auto-generated method stub
		if(map.containsKey(com.getId())){
			map.remove(com.getId());
			map.put(com.getId(), com);
		}
		
	}

	@Override
	public void deleteComponent(Component com) {
		// TODO Auto-generated method stub
		if( map.containsKey(com.getId())){
			map.remove(com.getId());
		}
	}

	@Override
	public void updateComponent(Component com) {
		// TODO Auto-generated method stub
		saveComponent(com);
	}

}
