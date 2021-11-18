package ProjetoAldo;
import java.util.Date;
import java.text.SimpleDateFormat;




public abstract class Contrato {

	static int contador = 0;
	private int id;
	private Date dataInicio;
	private Date dataEncerramento;
	private Colaborador colaborador;
	private boolean ativo;
	
	
	
	
	public Contrato( Date dataInicio, Date dataEncerramento, Colaborador colaborador, boolean ativo) {
		
		this.id = contador++;
		this.dataInicio = dataInicio;
		this.dataEncerramento = dataEncerramento;
		this.colaborador = colaborador;
		this.ativo = false;
	}
	
	
	
	
	public int getId() {
		return id;
	}
	
	public Date getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}
	public Date getDataEncerramento() {
		return dataEncerramento;
	}
	public void setDataEncerramento(Date dataEncerramento) {
		this.dataEncerramento = dataEncerramento;
	}
	public Colaborador getColaborador() {
		return colaborador;
	}
	public void setColaborador(Colaborador colaborador) {
		this.colaborador = colaborador;
	}
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
	
	public void encerrarContrato() {
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
