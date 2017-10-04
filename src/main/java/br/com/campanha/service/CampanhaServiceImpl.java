package br.com.campanha.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.campanha.business.CampanhaBusiness;
import br.com.campanha.domain.CampanhaMessage;
import br.com.campanha.domain.Result;

@Service
public class CampanhaServiceImpl {

	@Autowired
	private CampanhaBusiness business;

	public Result<CampanhaMessage> putUpdateCampanha(CampanhaMessage message) {
		try {
			return new Result<CampanhaMessage>(true, business.putUpdateCampanha(message));
		} catch (Exception e) {
			return new Result<CampanhaMessage>(e);
		}
	}

	public Result<CampanhaMessage> putNewCampanha(CampanhaMessage message) {
		try {
			return new Result<CampanhaMessage>(true, business.putNewCampanha(message));
		} catch (Exception e) {
			return new Result<CampanhaMessage>(e);
		}
	}

	public Result<CampanhaMessage> inativarCampanha(Long entityId) {
		try {
			business.inativar(entityId);
			return new Result<CampanhaMessage>(true);
		} catch (Exception e) {
			return new Result<CampanhaMessage>(e);
		}
	}

}
