package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Leilao {
	private String descricao;
	private List<Lance> lances;

	public Leilao() {
	}

	public Leilao(String descricao) {
		super();
		this.descricao = descricao;
		this.lances = new ArrayList<Lance>();
	}

	public void propoe(Lance lance) {
		int total = 0;
		for (Lance l : lances) {
			if (l.getUsuario().equals(lance.getUsuario())) total ++;
		}
		if(lances.isEmpty() || 
				(!ultimoLanceDado()
						.getUsuario().equals(lance.getUsuario())
						&& total < 5)) {
			lances.add(lance);
		}
	}
	
			

	private Lance ultimoLanceDado() {
		return lances.get(lances.size() - 1);
	}

	public String getDescricao() {
		return descricao;
	}

	public List<Lance> getLances() {
		return Collections.unmodifiableList(lances);
	}
}
