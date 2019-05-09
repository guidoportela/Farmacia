package br.com.guido.farmacia.dao;

import java.util.Date;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.guido.farmacia.domain.Caixa;
import br.com.guido.farmacia.util.HibernateUltil;

public class CaixaDAO extends GenericDAO<Caixa> {
	public Caixa buscar(Date dataAbertura) {
		Session sessao = HibernateUltil.getFabricaDeSessoes().openSession();
		try {
			Criteria consulta = sessao.createCriteria(Caixa.class);
			consulta.add(Restrictions.eq("dataAbertura", dataAbertura));
			Caixa resultado = (Caixa) consulta.uniqueResult();
			return resultado;
		} catch (RuntimeException erro) {
			throw erro;
		} finally {
			sessao.close();
		}
	}
}
