package ProjetoAldo;

import java.util.Date;

public class ContratoComissionado extends Contrato {

	
	
	private float percComissao;
	private float ajudaCusto;
	
	
	
	
	public ContratoComissionado( Date dataInicio, Date dataEncerramento, Colaborador colaborador, boolean ativo,
			float percComissao, float ajudaCusto) {
		super (dataInicio, dataEncerramento, colaborador, ativo);
		this.percComissao = percComissao;
		this.ajudaCusto = ajudaCusto;
	}




	public float getPercComissao() {
		return percComissao;
	}




	public void setPercComissao(float percComissao) {
		this.percComissao = percComissao;
	}




	public float getAjudaCusto() {
		return ajudaCusto;
	}




	public void setAjudaCusto(float ajudaCusto) {
		this.ajudaCusto = ajudaCusto;
	}
	
	
	
	public float calcVencimento(float vlFaturamento) {
		
		return
	}




	@Override
	public String toString() {
		String situacao = "\n**Contrato comissionado** "  +
				"\n Data de início : " + this.getDataInicio() +
				"\n Data de encerramento:  " + this.getDataEncerramento() + 
				"\n Situação do contrato: " + this.isAtivo() +
				"\n Matrícula colaborador: "
			
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
}
