package br.com.campanha.event;

import org.springframework.context.ApplicationEvent;

import br.com.campanha.domain.Usuario;

public class UsuarioNewEvent extends ApplicationEvent {

	private static final long serialVersionUID = 509289011862260562L;
	private Usuario usuario;

	public UsuarioNewEvent(Object myInstance, Usuario usuario) {

		super(myInstance);
		this.usuario = usuario;
	}

	public Usuario getUsuario() {
		return usuario;
	}

}
