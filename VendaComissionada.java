package ProjetoAldo;

import java.util.Date;

public class VendaComissionada extends ContratoComissionado{

	
	
	private int id;
	private int mes;
	private int ano;
	private float valor;
	private ContratoComissionado contrComissionado;
	
	
	
	public VendaComissionada( Date dataInicio, Date dataEncerramento, Colaborador colaborador, boolean ativo,
			float percComissao, float ajudaCusto, int id2, int mes, int ano, float valor,
			ContratoComissionado contrComissionado) {
		super( dataInicio, dataEncerramento, colaborador, ativo, percComissao, ajudaCusto);
		id = id2;
		this.mes = mes;
		this.ano = ano;
		this.valor = valor;
		this.contrComissionado = contrComissionado;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public int getMes() {
		return mes;
	}



	public void setMes(int mes) {
		this.mes = mes;
	}



	public int getAno() {
		return ano;
	}



	public void setAno(int ano) {
		this.ano = ano;
	}



	public float getValor() {
		return valor;
	}



	public void setValor(float valor) {
		this.valor = valor;
	}



	public ContratoComissionado getContrComissionado() {
		return contrComissionado;
	}



	public void setContrComissionado(ContratoComissionado contrComissionado) {
		this.contrComissionado = contrComissionado;
	}
	
	
	

	
	
	
	
	
	
	
	
}
