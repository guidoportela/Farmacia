package br.com.guido.farmacia.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.guido.farmacia.domain.Estado;

public class EstadoDAOTeste {

	@Test
	@Ignore
	public void salvar() {
		Estado estado = new Estado();
		estado.setNome("São Paulo");
		estado.setSigla("SP");

		EstadoDAO estadoDao = new EstadoDAO();
		estadoDao.salvar(estado);
	}

	@Test
	@Ignore
	public void listar() {
		EstadoDAO estadoDao = new EstadoDAO();
		List<Estado> resultado = estadoDao.listar();

		for (Estado estado : resultado) {
			System.out.println(estado.getSigla() + " - " + estado.getNome());
		}
	}

	@Test
	@Ignore
	public void buscar() {
		Long codigo = 1L;
		EstadoDAO estadoDao = new EstadoDAO();
		Estado estado = estadoDao.buscar(codigo);

		if (estado == null) {
			System.out.println("Nenhum registro encontrado.");
		} else {
			System.out.println("Registro :");
			System.out.println(estado.getSigla() + " - " + estado.getNome());
		}
	}

	@Test
	@Ignore
	public void excluir() {
		Long codigo = 2L;
		EstadoDAO estadoDao = new EstadoDAO();
		Estado estado = estadoDao.buscar(codigo);
		if (estado == null) {
			System.out.println("Nenhum registro encontrado.");
		} else {
			estadoDao.excluir(estado);
			System.out.println("Registro Removido:");
			System.out.println(estado.getSigla() + " - " + estado.getNome());
		}
	}

	@Test
	public void editar() {
		Long codigo = 1L;
		EstadoDAO estadoDao = new EstadoDAO();
		Estado estado = estadoDao.buscar(codigo);
		if (estado == null) {
			System.out.println("Nenhum registro encontrado.");
		} else {
			estado.setNome("Sao Paulo");
			estado.setSigla("RJ");
			estadoDao.editar(estado);
			System.out.println("Registro editado:");
			System.out.println(estado.getSigla() + " - " + estado.getNome());
		}
	}
}
