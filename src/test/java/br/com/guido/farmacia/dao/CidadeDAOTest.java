package br.com.guido.farmacia.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.guido.farmacia.domain.Cidade;
import br.com.guido.farmacia.domain.Estado;

public class CidadeDAOTest {
	@Test
	@Ignore
	public void salvar() {
		Long codigoEstado = 1L;
		EstadoDAO estadoDao = new EstadoDAO();
		Estado estado = estadoDao.buscar(codigoEstado); // pesquisando as chaves estrageiras

		Cidade cidade = new Cidade();
		cidade.setNome("Taubaté");
		cidade.setEstado(estado);

		CidadeDAO cidadeDAO = new CidadeDAO();
		cidadeDAO.salvar(cidade);
	}

	@Test
	@Ignore
	public void listar() {
		CidadeDAO cidadeDAO = new CidadeDAO();
		List<Cidade> resultado = cidadeDAO.listar();

		System.out.println("Total de Registros Encontrados: " + resultado.size());

		for (Cidade cidade : resultado) {
			System.out.println(cidade.getCodigo() + " - " + cidade.getNome() + " - " + cidade.getEstado().getSigla()
					+ "(" + cidade.getEstado().getNome() + ")");
		}
	}

	@Test
	@Ignore
	public void buscar() {
		Long codigo = 1L;

		CidadeDAO cidadeDAO = new CidadeDAO();
		Cidade cidade = cidadeDAO.buscar(codigo);

		if (cidade == null) {
			System.out.println("Nenhum registro encontrado");
		} else {
			System.out.println("Registro encontrado:");
			System.out.println(cidade.getCodigo() + " - " + cidade.getNome() + " - " + cidade.getEstado().getSigla()
					+ "(" + cidade.getEstado().getNome() + ")");
		}
	}

	@Test
	public void buscarPorEstado() {
		Long estadoCodigo = 1L;

		CidadeDAO cidadeDAO = new CidadeDAO();
		List<Cidade> resultado = cidadeDAO.buscarPorEstado(estadoCodigo);

		for (Cidade cidade : resultado) {
			System.out.println(cidade.getCodigo() + " - " + cidade.getNome() + " - " + cidade.getEstado().getSigla()
					+ "(" + cidade.getEstado().getNome() + ")");
		}
	}

	@Test
	@Ignore
	public void excluir() {
		Long codigo = 2L;

		CidadeDAO cidadeDao = new CidadeDAO();
		Cidade cidade = cidadeDao.buscar(codigo);
		if (cidade == null) {
			System.out.println("Nenhum registro encontrado.");
		} else {
			cidadeDao.excluir(cidade);
			System.out.println("Cidade Removida:");
			System.out.println(cidade.getCodigo() + " - " + cidade.getNome() + " - " + cidade.getEstado().getSigla()
					+ "(" + cidade.getEstado().getNome() + ")");
		}
	}

	@Test
	@Ignore
	public void editar() {
		Long codigoCidade = 1L;
		Long codigoEstado = 1L;

		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.buscar(codigoEstado);

		CidadeDAO cidadeDao = new CidadeDAO();
		Cidade cidade = cidadeDao.buscar(codigoCidade);

		if (cidade == null) {
			System.out.println("Nenhum registro encontrado.");
		} else {
			cidade.setNome("Taubaté");
			cidadeDao.editar(cidade);
			cidade.setEstado(estado);

			System.out.println("Cidade editada:");
			System.out.println(cidade.getCodigo() + " - " + cidade.getNome() + " - " + cidade.getEstado().getSigla()
					+ "(" + cidade.getEstado().getNome() + ")");
		}
	}
}
