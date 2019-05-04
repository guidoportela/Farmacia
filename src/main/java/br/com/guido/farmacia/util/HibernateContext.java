package br.com.guido.farmacia.util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class HibernateContext implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		HibernateUltil.getFabricaDeSessoes().close();

	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		HibernateUltil.getFabricaDeSessoes();

	}
}
