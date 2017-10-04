package br.com.campanha.fixture;

import org.joda.time.DateTime;

import br.com.campanha.comum.DateUtils;
import br.com.campanha.message.CampanhaMessage;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class CampanhaFixture implements TemplateLoader {

	@Override
	public void load() {

		Fixture.of(CampanhaMessage.class).addTemplate("valid", new Rule() {
			{
				add("nome", random("Campees", "Amadores Bons", "Mestres", "Inacreditaveis"));
				add("timeId", random(100l, 200l, 600l, 400l));
				add("inicioVigencia", DateUtils.toStringDateTruncate(DateTime.now().toDate()));
				add("fimVigencia", DateUtils.toStringDateTruncate(DateTime.now().plusMonths(1).toDate()));
			}
		});
	}
}
