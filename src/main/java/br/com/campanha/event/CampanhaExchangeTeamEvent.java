package br.com.campanha.event;

import org.springframework.context.ApplicationEvent;

import br.com.campanha.domain.Campanha;

public class CampanhaExchangeTeamEvent extends ApplicationEvent {

	private static final long serialVersionUID = 7609577677916969468L;

	private Campanha campanha;

	public CampanhaExchangeTeamEvent(Object myInstance, Campanha campanha) {

		super(myInstance);
		this.campanha = campanha;
	}

	public Campanha getCampanha() {
		return campanha;
	}

}
