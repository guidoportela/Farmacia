package br.com.guido.farmacia.dao;

import org.junit.Test;

import br.com.guido.farmacia.domain.Estado;

public class EstadoDAOTeste {

	@Test
	public void salvar() {
		Estado estado = new Estado();
		estado.setNome("São Paulo");
		estado.setSigla("SP");

		EstadoDAO estadoDao = new EstadoDAO();
		estadoDao.salvar(estado);
	}
}
