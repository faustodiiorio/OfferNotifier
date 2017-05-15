package it.offerNotifier.model;

import java.util.Map;

public class ItemFilter {
	private Map<String, String> filtro1;
	private Map<String, String> filtro2;
	
	public Map<String, String> getFiltro1() {
		return filtro1;
	}
	public void setFiltro1(Map<String, String> filtro1) {
		this.filtro1 = filtro1;
	}
	public Map<String, String> getFiltro2() {
		return filtro2;
	}
	public void setFiltro2(Map<String, String> filtro2) {
		this.filtro2 = filtro2;
	}
}