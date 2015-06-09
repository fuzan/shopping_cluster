package util;

import com.google.inject.AbstractModule;

import dao.ComponentDAO;
import dao.IComponentDAO;

public class AppInjector extends AbstractModule{

	@Override
	protected void configure() {
		// TODO Auto-generated method stub
		bind(IComponentDAO.class).to(ComponentDAO.class);
	}

}
