package br.com.campanha.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.campanha.business.UsuarioBusiness;
import br.com.campanha.domain.Result;
import br.com.campanha.domain.Usuario;
import br.com.campanha.domain.UsuarioMessage;

@Service
public class UsuarioServiceImpl {

	@Autowired
	private UsuarioBusiness business;

	@Autowired
	private CampanhaSearchServiceImpl campanhaSearchService;

	public Result<UsuarioMessage> inativarUsuario(Long entityId) {
		try {
			business.inativar(entityId);
			return new Result<UsuarioMessage>(true);
		} catch (Exception e) {
			return new Result<UsuarioMessage>(e);
		}
	}

	public Result<UsuarioMessage> putNewUsuario(UsuarioMessage message) {
		try {
			Usuario usuario = business.findOneUsuarioByEmail(message.getEmail());
			if (usuario == null) {
				message = business.putNew(message);
			} else {
				business.putUpdate(message);
				message.setId(usuario.getId());
			}
			return this.attachCampanhasAssociadas(message);
		} catch (Exception e) {
			return new Result<UsuarioMessage>(e);
		}
	}

	public Result<UsuarioMessage> putUpdateUsuario(UsuarioMessage message) {
		try {
			UsuarioMessage usuarioMessage = business.putUpdate(message);
			return this.attachCampanhasAssociadas(usuarioMessage);
		} catch (Exception e) {
			return new Result<UsuarioMessage>(e);
		}
	}

	private Result<UsuarioMessage> attachCampanhasAssociadas(UsuarioMessage message) throws Exception {
		try {
			campanhaSearchService.attachCampanhasAssociadas(message);
			return new Result<UsuarioMessage>(true, message);
		} catch (Exception e) {
			return new Result<UsuarioMessage>("Usuario atualizado, mas servi�o de campanha indispon�vel");
		}
	}
}
