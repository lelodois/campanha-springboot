package br.com.campanha.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.campanha.business.CampanhaBusiness;
import br.com.campanha.domain.Campanha;
import br.com.campanha.domain.CampanhaUsuario;
import br.com.campanha.domain.Usuario;
import br.com.campanha.repository.CampanhaUsuarioBaseRepository;

@Component
public class UsuarioAssociacaoCampanhaListener implements ApplicationListener<UsuarioNewEvent> {

	@Autowired
	private CampanhaBusiness campanhaBusiness;

	@Autowired
	private CampanhaUsuarioBaseRepository dao;

	@Override
	@Transactional(readOnly = false, rollbackFor = Exception.class)
	public void onApplicationEvent(UsuarioNewEvent event) {
		Usuario usuario = event.getUsuario();
		for (Campanha campanha : campanhaBusiness.listCampanhasProgramadas(usuario.getTimeId())) {
			dao.save(new CampanhaUsuario(campanha, usuario));
		}
	}
}
