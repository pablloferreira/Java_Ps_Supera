package br.com.psSupera.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Carrinho{

	@Id
	@GeneratedValue
	private long id;
	
	private String id_client;
	private BigDecimal sub_total;
	private BigDecimal total;
	private float frete;

	public Carrinho(long id, String id_client, BigDecimal sub_total, BigDecimal total, float frete) {
		this.id = id;
		this.id_client = id_client;
		this.sub_total = sub_total;
		this.total = total;
		this.frete = frete;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getId_client() {
		return id_client;
	}

	public void setId_client(String id_client) {
		this.id_client = id_client;
	}

	public BigDecimal getSub_total() {
		return sub_total;
	}

	public void setSub_total(BigDecimal sub_total) {
		this.sub_total = sub_total;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public float getFrete() {
		return frete;
	}

	public void setFrete(float frete) {
		this.frete = frete;
	}
	
	
}
