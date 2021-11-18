package ProjetoAldo;

import java.util.Date;

public class ContratoHorista extends Contrato {

	
	
	private int horasMes;
	private float valorHora;
	
	
	
	public ContratoHorista(Date dataInicio, Date dataEncerramento, Colaborador colaborador, boolean ativo,
			int horasMes, float valorHora) {
		super(dataInicio, dataEncerramento, colaborador, ativo);
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





	public float calcVencimento() {
		return
	}
	
	
	
	@Override
	public String toString() {
		return "\n**Contrato horista** "  +
				"\n Data de início : " + this.getDataInicio() +
				"\n Data de encerramento:  " + this.getDataEncerramento() + 
				"\n Situação do contrato: " + this.isAtivo();
	
	}
	
	
	
	
	
}
