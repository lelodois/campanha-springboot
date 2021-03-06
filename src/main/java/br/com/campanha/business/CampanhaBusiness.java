package br.com.campanha.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.campanha.comum.BaseValidator;
import br.com.campanha.domain.Campanha;
import br.com.campanha.domain.CampanhaMessage;
import br.com.campanha.repository.CampanhaBaseRepository;
import br.com.campanha.repository.CampanhaSearchRepository;

@Service
public class CampanhaBusiness {

	@Autowired
	private CampanhaSearchRepository searchDao;

	@Autowired
	private CampanhaBaseRepository baseDao;

	@Transactional(readOnly = false, rollbackFor = Exception.class)
	public CampanhaMessage putUpdateCampanha(CampanhaMessage message) throws Exception {
		Campanha workCampanha = message.getId() == null ? null : baseDao.findOne(message.getId());
		BaseValidator.notNull("Usuario nao localizado", workCampanha);
		return workCampanha.updateValues(message).buildMessage();
	}

	@Transactional(readOnly = false, rollbackFor = Exception.class)
	public CampanhaMessage putNewCampanha(CampanhaMessage message) throws Exception {
		message.setId(null);
		Campanha workCampanha = baseDao.save(new Campanha(message));
		return workCampanha.buildMessage();
	}

	@Transactional(readOnly = false, rollbackFor = Exception.class)
	public void inativar(Long entityId) throws Exception {
		baseDao.findOne(entityId).getBaseModel().inativar();
	}

	@Transactional(readOnly = true, rollbackFor = Exception.class)
	public List<Campanha> listCampanhasProgramadas(Long timeId) {
		return searchDao.findCampanhasProgramadas(timeId);
	}

	@Transactional(readOnly = true, rollbackFor = Exception.class)
	public List<Campanha> listCampanhasAlteradas() {
		return searchDao.findCampanhasAlteradas();
	}

}
