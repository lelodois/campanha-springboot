package br.com.campanha.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;

import br.com.campanha.business.CampanhaBusiness;
import br.com.campanha.business.CampanhaUsuarioBusiness;
import br.com.campanha.domain.Campanha;
import br.com.campanha.message.Result;
import br.com.campanha.message.CampanhaMessage;
import br.com.campanha.message.UsuarioMessage;

@Service
public class CampanhaSearchServiceImpl {

	@Autowired
	private CampanhaBusiness campanhaBusiness;

	@Autowired
	private CampanhaUsuarioBusiness campanhaUsuarioBusiness;

	public Result<List<CampanhaMessage>> listCampanhasProgramadas(Long timeId) {
		try {
			List<Campanha> campanha = campanhaBusiness.listCampanhasProgramadas(timeId);
			return new Result<List<CampanhaMessage>>(true, this.convetToMessage(campanha));
		} catch (Exception e) {
			return new Result<List<CampanhaMessage>>(e);
		}
	}

	public Result<List<CampanhaMessage>> listAlteradas() {
		try {
			List<Campanha> campanhas = campanhaBusiness.listCampanhasAlteradas();
			return new Result<List<CampanhaMessage>>(true, this.convetToMessage(campanhas));
		} catch (Exception e) {
			return new Result<List<CampanhaMessage>>(e);
		}
	}

	public void attachCampanhasAssociadas(UsuarioMessage message) {
		Long usuario = message.getId();
		List<Campanha> naoParticipante = campanhaUsuarioBusiness.listCampanhasUsuarioParticipante(usuario);
		message.setCampanhasParticipantes(convetToMessage(naoParticipante));
	}

	private List<CampanhaMessage> convetToMessage(List<Campanha> campanhas) {
		List<CampanhaMessage> messages = Lists.newArrayList();
		for (Campanha campanha : campanhas) {
			messages.add(campanha.buildMessage());
		}
		return messages;
	}

}
