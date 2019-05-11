package br.com.guido.farmacia.bean;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;

import br.com.guido.farmacia.dao.UsuarioDAO;
import br.com.guido.farmacia.domain.Pessoa;
import br.com.guido.farmacia.domain.Usuario;

@ManagedBean
@SessionScoped
public class LoginBean {
	private Usuario usuario;
	private Usuario usuarioLogado;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}

	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}

	@PostConstruct
	public void iniciar() {
		usuario = new Usuario();
		usuario.setPessoa(new Pessoa());
	}

	public void autentificar() {
		try {
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			usuarioLogado = usuarioDAO.autenticar(usuario.getPessoa().getCpf(), usuario.getSenha());

			if (usuarioLogado == null) {
				Messages.addGlobalError("CPF e/ou senha incorretas");
				return;
			}
			Faces.redirect("./pages/principal.xhtml");
		} catch (IOException erro) {
			Messages.addGlobalError(erro.getMessage());
		}
	}

	public boolean temPermissoes(List<String> permissoes) {
		for (String permissao : permissoes) {
			if (usuarioLogado.getTipo() == permissao.charAt(0)) {
				return true;
			}
		}

		return false;
	}

	public String sair() {
		usuarioLogado = null;
		return "/pages/login.xhtml?faces-redirect=true";
	}
}
