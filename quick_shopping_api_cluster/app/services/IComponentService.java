package services;

import java.util.List;

import model.Component;

public interface IComponentService {

	public void addNewComponent(Component com, int parentId);
	public void deleteComponent(Component com);
	public void moveWholeComponent(Component src,Component dest );
	public List<Component> getAllComponent(int parentId);
	public Component getComponentById(int componentId);
	public void updateComponent(Component com);
	public List<Component> getComponentByLevel(int level);
	
}
