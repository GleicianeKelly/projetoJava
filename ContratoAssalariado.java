package ProjetoAldo;

import java.util.Date;

public class ContratoAssalariado extends Contrato {

	
	private float  salarioMensal;
	private float percInsalubridade;
	private float percPericulosidade;
	
	
	
	
	public ContratoAssalariado(Date dataInicio, Date dataEncerramento, Colaborador colaborador, 
			float salarioMensal, float percInsalubridade, float percPericulosidade) {
		super(dataInicio, dataEncerramento, colaborador);
		this.salarioMensal = salarioMensal;
		this.percInsalubridade = percInsalubridade / 100 ;
		this.percPericulosidade = percPericulosidade / 100;
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



	



	/*@Override
	public String toString() {
		return "\n**Contrato assalariado** "  +
				"\n Data de in�cio : " + this.getDataInicio() +
				"\n Data de encerramento:  " + this.getDataEncerramento() + 
				"\n Situa��o do contrato: " + this.isAtivo();
	
	}*/
	


	//M�todo que calcula o vencimento do colaborador
	public float calcVencimento() {
		
		float resultado1 = this.salarioMensal * this.percInsalubridade;
		float resultado2 = this.salarioMensal * this.percPericulosidade;
	
		
		return this.salarioMensal + resultado1 + resultado2;
	}
	
	
	
	
	public float calcularSeguro(){
		
		float resultado = 0;
		
		float calculo = (this.calcVencimento() * 2) /100;
		
		if(calculo <= 25){
			resultado = 25;
		}
		else if(calculo >= 150){
			resultado = 150;
		}
		else {
			resultado = calculo;
		}
		
		return resultado;
	
		}

	
	
}
