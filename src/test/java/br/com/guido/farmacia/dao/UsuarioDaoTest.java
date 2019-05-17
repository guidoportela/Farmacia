package br.com.guido.farmacia.dao;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.junit.Ignore;
import org.junit.Test;

import br.com.guido.farmacia.domain.Pessoa;
import br.com.guido.farmacia.domain.Usuario;

public class UsuarioDaoTest {
	@Test
	@Ignore
	public void salvar() {

		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(2L);

		if (pessoa == null) {
			System.out.println("Nenhuma pessoa encontrada.");
		} else {
			System.out.println("Pessoa encontra:");
			System.out.println("Nome: " + pessoa.getNome());
			System.out.println("CPF: " + pessoa.getCpf());

			Usuario usuario = new Usuario();
			usuario.setAtivo(true);
			usuario.setPessoa(pessoa);
			usuario.setSenhaSemCriptografia("1111");

			SimpleHash hash = new SimpleHash("md5", usuario.getSenhaSemCriptografia());
			usuario.setSenha(hash.toHex());
			usuario.setTipo('G');

			UsuarioDAO usuarioDAO = new UsuarioDAO();
			usuarioDAO.salvar(usuario);
			System.out.println("Usuário salvo com sucesso.");
		}
	}
}
