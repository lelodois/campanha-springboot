package br.com.campanha.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.campanha.domain.CampanhaUsuario;
import br.com.campanha.repository.CampanhaUsuarioSearchRepository;

@Component
public class UsuarioDesassociacaoCampanhaListener implements ApplicationListener<UsuarioExchangeTeamEvent> {

	@Autowired
	private CampanhaUsuarioSearchRepository dao;

	@Transactional(readOnly = false, rollbackFor = Exception.class)
	public void onApplicationEvent(UsuarioExchangeTeamEvent event) {
		for (CampanhaUsuario campanhaUsuario : dao.findUsuarioCampanhasByUsuario(event.getUsuario().getId())) {
			campanhaUsuario.getBaseModel().inativar();
		}
	}

}
