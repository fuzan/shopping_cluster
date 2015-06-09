package dao;

import model.Component;

public interface IComponentDAO {
    public Component getComponentByID(int id);
    public void saveComponent(Component com);
    public void deleteComponent(Component com);
    public void updateComponent(Component com);
    
}
