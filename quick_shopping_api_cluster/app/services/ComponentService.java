package services;

import java.util.List;

import model.Component;

public class ComponentService implements IComponentService {

	@Override
	public void addNewComponent(Component com, int parentId) {
		// TODO Auto-generated method stub
		com.setParentId(parentId);
        com.save();
	}

	@Override
	public void deleteComponent(Component com) {
		// TODO Auto-generated method stub		
        com.delete();
	}

	@Override
	public void moveWholeComponent(Component src, Component dest) {
		// TODO Auto-generated method stub
        src.setParentId(dest.getId());
        src.update();
	}

	@Override
	public List<Component> getAllComponent(int parentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Component getComponentById(int componentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateComponent(Component com) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Component> getComponentByLevel(int level) {
		// TODO Auto-generated method stub
		return null;
	}

}
