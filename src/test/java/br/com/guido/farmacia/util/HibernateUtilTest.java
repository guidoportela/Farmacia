package br.com.guido.farmacia.util;

import org.hibernate.Session;
import org.junit.Test;

public class HibernateUtilTest {

	@Test
	public void conectar() {
		Session sessao = HibernateUltil.getFabricaDeSessoes().openSession();
		sessao.close();
		HibernateUltil.getFabricaDeSessoes().close();
	}
}
