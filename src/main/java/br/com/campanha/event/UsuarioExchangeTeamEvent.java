package br.com.campanha.event;

import org.springframework.context.ApplicationEvent;

import br.com.campanha.domain.Usuario;

public class UsuarioExchangeTeamEvent extends ApplicationEvent {

	private static final long serialVersionUID = -8665651308628908844L;
	private Usuario usuario;

	public UsuarioExchangeTeamEvent(Object myInstance, Usuario usuario) {

		super(myInstance);
		this.usuario = usuario;
	}

	public Usuario getUsuario() {
		return usuario;
	}

}
