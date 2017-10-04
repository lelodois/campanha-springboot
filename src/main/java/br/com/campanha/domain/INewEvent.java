package br.com.campanha.domain;

import org.springframework.context.ApplicationEvent;

public interface INewEvent {

	public ApplicationEvent getEventNewItem(Object source);

}
