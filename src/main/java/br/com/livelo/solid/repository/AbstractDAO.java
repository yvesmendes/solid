package br.com.livelo.solid.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractDAO<ID,ENTIDADE> {

	protected Map<ID,ENTIDADE> dataset;
	
	public AbstractDAO() {
		dataset = new HashMap<ID, ENTIDADE>();
	}
	
	public final void add(ID id, ENTIDADE entidade) {
		dataset.put(id, entidade);
	}
	
	public final void remove(ID id) {
		dataset.remove(id);
	}
	
	public final Collection<ENTIDADE> getAll() {
		return this.dataset.values();
	}
	
	public final ENTIDADE getById(ID id) {
		return this.dataset.get(id);
	}
	
	public final void alter(ID id, ENTIDADE entidade) {
		this.add(id, entidade);
	}
}

