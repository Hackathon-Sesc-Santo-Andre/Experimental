package br.com.ws;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;



@XmlRootElement(name="MeuRanking")
public class MeuRanking {
	private String imei;
	private int totalToques;
	private long tempoInicio;
	private long tempoFim;
	
	
	
	@XmlElement
	public String getImei() {
		return imei;
	}
	public void setImei(String imei) {
		this.imei = imei;
	}
	@XmlElement
	public int getTotalToques() {
		return totalToques;
	}
	public void setTotalToques(int totalToques) {
		this.totalToques = totalToques;
	}
	
	@XmlElement
	public long getTempoInicio() {
		return tempoInicio;
	}
	public void setTempoInicio(long tempoInicio) {
		this.tempoInicio = tempoInicio;
	}
	
	@XmlElement
	public long getTempoFim() {
		return tempoFim;
	}
	public void setTempoFim(long tempoFim) {
		this.tempoFim = tempoFim;
	}
	
	
	
	
	
	
}
