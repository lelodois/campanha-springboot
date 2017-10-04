package br.com.campanha.domain;

import org.springframework.context.ApplicationEvent;

public interface IUpdateEvent {

	public ApplicationEvent getEventUpdateItem(Object source);

}
