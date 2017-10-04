package br.com.campanha.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.campanha.business.CampanhaUsuarioBusiness;
import br.com.campanha.domain.Campanha;
import br.com.campanha.domain.CampanhaUsuario;
import br.com.campanha.domain.Usuario;

@Component
public class UsuarioAssociacaoCampanhaFaltanteListener implements ApplicationListener<UsuarioUpdateEvent> {

	@Autowired
	private CampanhaUsuarioBusiness business;

	@Override
	@Transactional(readOnly = false, rollbackFor = Exception.class)
	public void onApplicationEvent(UsuarioUpdateEvent event) {
		Usuario usuario = event.getUsuario();
		for (Campanha campanha : business.listCampanhasProgramadasNaoAssociadas(usuario.getTimeId(), usuario.getId())) {
			business.merge(new CampanhaUsuario(campanha, usuario));
		}
	}
}
