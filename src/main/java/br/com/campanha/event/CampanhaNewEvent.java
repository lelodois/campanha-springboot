package br.com.campanha.event;

import org.springframework.context.ApplicationEvent;

import br.com.campanha.domain.Campanha;

public class CampanhaNewEvent extends ApplicationEvent {

	private static final long serialVersionUID = 3272173486450125006L;

	private Campanha campanha;

	public CampanhaNewEvent(Object myInstance, Campanha campanha) {
		super(myInstance);
		this.campanha = campanha;
	}

	public Campanha getCampanha() {
		return campanha;
	}

}
