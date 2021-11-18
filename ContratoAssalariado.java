package ProjetoAldo;

import java.util.Date;

public class ContratoAssalariado extends Contrato {

	
	private float  salarioMensal;
	private float percInsalubridade;
	private float percPericulosidade;
	
	
	
	
	public ContratoAssalariado(Date dataInicio, Date dataEncerramento, Colaborador colaborador, boolean ativo,
			float salarioMensal, float percInsalubridade, float percPericulosidade) {
		super(dataInicio, dataEncerramento, colaborador, ativo);
		this.salarioMensal = salarioMensal;
		this.percInsalubridade = percInsalubridade;
		this.percPericulosidade = percPericulosidade;
	}



	public float getSalarioMensal() {
		return salarioMensal;
	}



	public void setSalarioMensal(float salarioMensal) {
		this.salarioMensal = salarioMensal;
	}


	public float getPercInsalubridade() {
		return percInsalubridade;
	}


	public void setPercInsalubridade(float percInsalubridade) {
		this.percInsalubridade = percInsalubridade;
	}


	public float getPercPericulosidade() {
		return percPericulosidade;
	}


	public void setPercPericulosidade(float percPericulosidade) {
		this.percPericulosidade = percPericulosidade;
	}



	



	@Override
	public String toString() {
		return "\n**Contrato assalariado** "  +
				"\n Data de início : " + this.getDataInicio() +
				"\n Data de encerramento:  " + this.getDataEncerramento() + 
				"\n Situação do contrato: " + this.isAtivo();
	
	}
	



	public float calcVencimento() {
		return
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
