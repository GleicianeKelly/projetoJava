package ProjetoAldo;

import java.util.Date;

public class ContratoHorista extends Contrato {

	
	
	private int horasMes;
	private float valorHora;
	
	
	
	public ContratoHorista(Date dataInicio, Date dataEncerramento, Colaborador colaborador, 
			int horasMes, float valorHora) {
		super(dataInicio, dataEncerramento, colaborador);
		this.horasMes = horasMes;
		this.valorHora = valorHora;
	}
	


	public int getHorasMes() {
		return horasMes;
	}



	public void setHorasMes(int horasMes) {
		this.horasMes = horasMes;
	}





	public float getValorHora() {
		return valorHora;
	}




	public void setValorHora(float valorHora) {
		this.valorHora = valorHora;
	}




	//M�todo que calcula o vencimento do colaborador
	public float calcVencimento() {
		return this.valorHora * this.horasMes;
	}
	
	
	
	/*@Override
	public String toString() {
		return "\n**Contrato horista** "  +
				"\n Data de in�cio : " + this.getDataInicio() +
				"\n Data de encerramento:  " + this.getDataEncerramento() + 
				"\n Situa��o do contrato: " + this.isAtivo();
	
	}*/
	
	public void calcularSeguro() {
		
		float resultado = 0;
		
		
	
		if(this.calcVencimento() < 5000f){
			resultado = (this.calcVencimento() * 2) / 100;
			}
			else if(this.calcVencimento() > 5000f){
			resultado = (this.calcVencimento() * 2.5f) / 100;
			}
	
		}
			
	}
	
	
	

