package br.com.guido.farmacia.dao;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.guido.farmacia.domain.Fabricante;
import br.com.guido.farmacia.domain.Produto;

public class ProdutoDAOTest {
	@Test
	@Ignore
	public void salvar() {

		FabricanteDAO fabricanteDao = new FabricanteDAO();
		Fabricante fabricante = fabricanteDao.buscar(1L);

		Produto produto = new Produto();
		produto.setDescricao("Cataflan 50mg");
		produto.setFabricante(fabricante);
		produto.setPreco(new BigDecimal("13.70"));
		produto.setQuantidade(new Short("7"));
		System.out.println("Produto salvo com sucesso.");
	}

	@Test
	@Ignore
	public void listar() {
		ProdutoDAO produtoDAO = new ProdutoDAO();
		List<Produto> resultado = produtoDAO.listar();

		System.out.println("Total de Registros Encontrados: " + resultado.size());

		for (Produto produto : resultado) {
			System.out.println(produto.getCodigo() + " - " + produto.getDescricao() + " - " + produto.getPreco() + " - "
					+ produto.getQuantidade());
		}
	}
	
	@Test
	@Ignore
	public void buscar() {
		Long codigo = 3L;

		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produto = produtoDAO.buscar(codigo);

		if (produto == null) {
			System.out.println("Nenhum registro encontrado");
		} else {
			System.out.println("Registro encontrado:");
			System.out.println(produto.getCodigo() + " - " + produto.getDescricao() + " - " + produto.getPreco() + " - "
					+ produto.getQuantidade());
		}
	}
}
