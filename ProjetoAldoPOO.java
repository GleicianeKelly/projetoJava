package ProjetoAldo;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;
public class ProjetoAldoPOO {

	
	static List<Colaborador> listaColaborador = new ArrayList<Colaborador>();  
	static List<Contrato> listaContrato = new ArrayList<Contrato>();
	static Scanner ler = new Scanner (System.in);
	public static void main(String[] args) {
		
		
		
		
		
		int opcao = 0;
		
		while(true) {
			
			System.out.println("** Cadastro de colaboradores** ");
			System.out.println("Digite 1 para cadastrar colaborador ");
			System.out.println("Digite 2 para registrar contrato Assalariado ");
			System.out.println("Digite 3 para registrar contrato Comissionado ");
			System.out.println("Digite 4 para registrar contrato Horista ");
			System.out.println("Digite 5 para registrar venda Comissionada ");	
			System.out.println("Digite 6 para consultar contrato ");
			System.out.println("Digite 7 para encerrar contrato ");
			System.out.println("Para encerrar digite 0");
			
			opcao = ler.nextInt();
			
			switch(opcao) {
			
			case 0:
				System.out.println("** Programa finalizado** ");
				break;
			
			case 1: 
				break;
				
			case 2:
				break;
				
			case 3: 
				break;
				
			case 4:
				break;
				
			default:
				System.out.println("Número inválido! Digite novamente: ");
				break;
					
			}
			
			
		}
		
		
		
		
		
		
	
	}
	
		public static Colaborador pesquisarColaborador(String matriculaColaborador) {
			for(Colaborador colaborador : listaColaborador) {
				if(colaborador.getMatricula() == matriculaColaborador) {
					return colaborador;
				}
			}
			return null;
		}
		
		
		public static Contrato pesquisarContrato (String matricula){
			for(Contrato contrato : listaContrato) {
				if(contrato.getColaborador().getMatricula() == matricula) {
					return contrato;
				}
			}
			return null;
		}
		
		
		public static boolean validarCpf(String cpf) {
	        // verifica CPFs formados por uma sequencia de numeros iguais
	        if (cpf.equals("00000000000") ||
	                cpf.equals("11111111111") ||
	                cpf.equals("22222222222") || cpf.equals("33333333333") ||
	                cpf.equals("44444444444") || cpf.equals("55555555555") ||
	                cpf.equals("66666666666") || cpf.equals("77777777777") ||
	                cpf.equals("88888888888") || cpf.equals("99999999999") ||
	                (cpf.length() != 11)) {
	            return(false);
	        }

	        char dig10, dig11;
	        int sm, i, r, num, peso;

	        try {
	            // Calculo do 1o. Digito Verificador
	            sm = 0;
	            peso = 10;
	            for (i=0; i<9; i++) {
	                num = (int)(cpf.charAt(i) - 48);
	                sm = sm + (num * peso);
	                peso = peso - 1;
	            }

	            r = 11 - (sm % 11);
	            if ((r == 10) || (r == 11)) {
	                dig10 = '0';
	            } else {
	                dig10 = (char)(r + 48); // converte no respectivo caractere numerico
	            }
	            // Calculo do 2o. Digito Verificador
	            sm = 0;
	            peso = 11;
	            for(i=0; i<10; i++) {
	                num = (int)(cpf.charAt(i) - 48);
	                sm = sm + (num * peso);
	                peso = peso - 1;
	            }
	            r = 11 - (sm % 11);
	            if ((r == 10) || (r == 11)) {
	                dig11 = '0';
	            }
	            else {
	                dig11 = (char)(r + 48);
	            }
	            // Verifica se os digitos calculados conferem com os digitos informados.
	            if ((dig10 == cpf.charAt(9)) && (dig11 == cpf.charAt(10))) {
	                return (true);
	            }
	            else {
	                return (false);
	            }
	        } catch (InputMismatchException erro) {
	            return(false);
	        }
	    } 
		
		
		public static int retornarIdade(String data) throws ParseException {
			Date atual = new Date();
			Date date = new SimpleDateFormat("dd/MM/yyyy").parse(data);
			Calendar c = Calendar.getInstance();
			Calendar cAtual = Calendar.getInstance();

			c.setTime(date);
			cAtual.setTime(atual);

			int idade = cAtual.get(Calendar.YEAR) - c.get(Calendar.YEAR);

			if (cAtual.get(Calendar.MONTH) + 1 == c.get(Calendar.MONTH) + 1) {
				if (cAtual.get(Calendar.DATE) + 1 >= c.get(Calendar.DATE)) {

				} else {
					idade--;
				}
			} else {
				if (cAtual.get(Calendar.MONTH) + 1 > c.get(Calendar.MONTH) + 1) {
				} else {
					idade--;
				}
			}
			return idade;
		}
		
		
	
	
		public static void inserirColaborador() throws ParseException{
			
			System.out.println(" **Inserir colaborador** ");
			
			
			while(true) {
				
				String matriculaColaborador = "";
				String cpf;
				String nome;
				
				System.out.println("Digite 0 para sair: ");
				
				try {
					System.out.println("Digite a matrícula do colaborador: ");
					matriculaColaborador = ler.next();
				}
				catch(Exception e){
					System.out.println("Digite um número válido! ");
					ler.next();
				}
				
				if(matriculaColaborador.equals("0")) {
					System.out.println("Programa encerrado!! ");
				}
				
				Colaborador colaboradorEncontrado = pesquisarColaborador(matriculaColaborador);
				
				if(colaboradorEncontrado != null) {
					System.out.println("Colaborador já cadastrado!! ");
					continue;
				}
				
				System.out.println("Digite o CPF do colaborador: ");
				cpf = ler.next();
				
				if(validarCpf(cpf) == false ) {
					System.out.println("CPF inválido!! ");
					continue;
				}
				
				System.out.println("Digite o nome do colaborador: ");
				nome = ler.next();
					
				SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
				System.out.println("Digite a data de nascimento do colaborador: ");
	            System.out.println("Formato da data dd/MM/yyyy");
	            String dataInformada = ler.next();
	            Date data= formato.parse(dataInformada);
	            
	            
	            
	            if(retornarIdade(dataInformada) < 18) {
	            	System.out.println("Impossível cadastrar, menor de 18 anos! ");
	            	continue;
	           	
	            }
	            
	            
	            
				
			}
			
			
			
			
			
		}
		
		
		public static void  registrarContratoAssalariado() throws ParseException {
			
			System.out.println("** Registrar Contrato assalariado **");
			
			if(listaColaborador.isEmpty()) {
				System.out.println("Não há colaborador na lista! ");
				return;
			}
			
			while(true) {
				System.out.println("Para sair digite 0");
				
				
				String matriculaColaborador = "";
				float salarioMensal;
				float percentualInsalubridade;
				float percentualPericulosidade;
				
				SimpleDateFormat formato1 = new SimpleDateFormat("dd/MM/yyyy");
				System.out.println("Digite a data de início: ");
	            System.out.println("Formato da data dd/MM/yyyy");
	            String dataInformadaInicio = ler.next();
	            Date dataInicio= formato1.parse(dataInformadaInicio);
				
				
	            SimpleDateFormat formato2 = new SimpleDateFormat("dd/MM/yyyy");
				System.out.println("Digite a data de Encerramento: ");
	            System.out.println("Formato da data dd/MM/yyyy");
	            String dataInformadaEncerramento = ler.next();
	            Date dataEncerramento= formato2.parse(dataInformadaEncerramento);
				
	            try {
					System.out.println("Digite a matrícula do colaborador: ");
					matriculaColaborador = ler.next();
				}
				catch(Exception e){
					System.out.println("Digite um número válido! ");
					ler.next();
				}
				
				Colaborador colaboradorEncontrado = pesquisarColaborador(matriculaColaborador);
				
				if(colaboradorEncontrado == null) {
					System.out.println("Colaborador não cadastrado!! ");
					continue;
				}
				
				System.out.println("Digite o salário mensal: ");
				salarioMensal = ler.nextFloat();
				
				//Implementar a data inicial não pode ser anterior a data atual
				
				System.out.println("Digite o percentual de insalubridade: ");
				percentualInsalubridade = ler.nextFloat();
				
				System.out.println("Digite o percentual de periculosidade: ");
				percentualPericulosidade = ler.nextFloat();
				
				ContratoAssalariado contratoAssalariado = (new ContratoAssalariado(dataInicio, dataEncerramento, colaboradorEncontrado, 
						true, salarioMensal, percentualInsalubridade, percentualPericulosidade));
				
				System.out.println("O id do contrato é: " + contratoAssalariado.getId()); 
				
				listaContrato.add(contratoAssalariado);
				
				
			}
			
			
		}
	
	
public static void  registrarContratoComissionado() throws ParseException {
			
			System.out.println("** Registrar Contrato comissionado**");
			
			if(listaColaborador.isEmpty()) {
				System.out.println("Não há colaborador na lista! ");
				return;
			}
			
			while(true) {
				System.out.println("Para sair digite 0");
				
				
				String matriculaColaborador = "";
				float percentualComissao;
				float ajudaCusto;
				
				SimpleDateFormat formato1 = new SimpleDateFormat("dd/MM/yyyy");
				System.out.println("Digite a data de início: ");
	            System.out.println("Formato da data dd/MM/yyyy");
	            String dataInformadaInicio = ler.next();
	            Date dataInicio= formato1.parse(dataInformadaInicio);
				
				
	            SimpleDateFormat formato2 = new SimpleDateFormat("dd/MM/yyyy");
				System.out.println("Digite a data de Encerramento: ");
	            System.out.println("Formato da data dd/MM/yyyy");
	            String dataInformadaEncerramento = ler.next();
	            Date dataEncerramento= formato2.parse(dataInformadaEncerramento);
				
	            try {
					System.out.println("Digite a matrícula do colaborador: ");
					matriculaColaborador = ler.next();
				}
				catch(Exception e){
					System.out.println("Digite um número válido! ");
					ler.next();
				}
				
				Colaborador colaboradorEncontrado = pesquisarColaborador(matriculaColaborador);
				
				if(colaboradorEncontrado == null) {
					System.out.println("Colaborador não cadastrado!! ");
					continue;
				}
				
				
				//Implementar a data inicial não pode ser anterior a data atual
				
				System.out.println("Digite o percentual de comissão: ");
				percentualComissao = ler.nextFloat();
				
				System.out.println("Digite a ajuda de custo: ");
				ajudaCusto = ler.nextFloat();
				
				ContratoComissionado contratoComissionado = (new ContratoComissionado(dataInicio, dataEncerramento, colaboradorEncontrado, 
						true, percentualComissao, ajudaCusto));
				
				System.out.println("O id do contrato é: " + contratoComissionado.getId()); 
				
				listaContrato.add(contratoComissionado);
				
				
			}
			
			
		}
	

		public static void  registrarContratoHorista() throws ParseException {
				
				System.out.println("** Registrar Contrato comissionado**");
				
				if(listaColaborador.isEmpty()) {
					System.out.println("Não há colaborador na lista! ");
					return;
				}
				
				while(true) {
					System.out.println("Para sair digite 0");
					
					
					String matriculaColaborador = "";
					int horaMes;
					float valorHora;
					
					SimpleDateFormat formato1 = new SimpleDateFormat("dd/MM/yyyy");
					System.out.println("Digite a data de início: ");
		            System.out.println("Formato da data dd/MM/yyyy");
		            String dataInformadaInicio = ler.next();
		            Date dataInicio= formato1.parse(dataInformadaInicio);
					
					
		            SimpleDateFormat formato2 = new SimpleDateFormat("dd/MM/yyyy");
					System.out.println("Digite a data de Encerramento: ");
		            System.out.println("Formato da data dd/MM/yyyy");
		            String dataInformadaEncerramento = ler.next();
		            Date dataEncerramento= formato2.parse(dataInformadaEncerramento);
					
		            try {
						System.out.println("Digite a matrícula do colaborador: ");
						matriculaColaborador = ler.next();
					}
					catch(Exception e){
						System.out.println("Digite um número válido! ");
						ler.next();
					}
					
					Colaborador colaboradorEncontrado = pesquisarColaborador(matriculaColaborador);
					
					if(colaboradorEncontrado == null) {
						System.out.println("Colaborador não cadastrado!! ");
						continue;
					}
					
					
					//Implementar a data inicial não pode ser anterior a data atual
					
					System.out.println("Digite o percentual de comissão: ");
					horaMes = ler.nextInt();
					
					System.out.println("Digite a ajuda de custo: ");
					valorHora = ler.nextFloat();
					
					ContratoHorista contratoHorista = (new ContratoHorista(dataInicio, dataEncerramento, colaboradorEncontrado, 
							true, horaMes, valorHora));
					
					System.out.println("O id do contrato é: " + contratoHorista.getId()); 
					
					listaContrato.add(contratoHorista);
					
					
					
				}
				
				
			}

			public static void consultarContrato() {
				
				System.out.println(" **Consultar contrato** ");
				
				while(true) {
					
					String matriculaColaborador = "";
					
					try {
					System.out.println("Digite a matrícula: ");
					matriculaColaborador = ler.next();
					
					}
					
					catch(Exception e) {
						System.out.println("Digite um número válido! ");
						
					}
					
					Colaborador colaboradorEncontrado = pesquisarColaborador(matriculaColaborador);
					
					if(colaboradorEncontrado == null) {
						System.out.println("Colaborador não cadastrado! Não há contrato"
								+ "a ser exibido!");
						continue;
					}
					
						
						Contrato contratoEncontrado = pesquisarContrato (matriculaColaborador);
						
						//Fazer o system
						contratoEncontrado.getId();
						contratoEncontrado.getDataInicio();
						contratoEncontrado.getDataEncerramento();
						contratoEncontrado.isAtivo();
						contratoEncontrado.getColaborador().getMatricula();
						contratoEncontrado.getColaborador().getNome();
						contratoEncontrado.getColaborador().getCpf();
						contratoEncontrado.getColaborador().isSituacao();
					
					if(contratoEncontrado instanceof ContratoAssalariado) {
						System.out.println("Contrato assalariado! ");
					}
					
					if(contratoEncontrado instanceof ContratoComissionado) {
						System.out.println("Contrato comissionado! ");
					}
					
					if(contratoEncontrado instanceof ContratoHorista) {
						System.out.println("Contrato horista! ");
					}
					
					
				}
				
						
				
				
				
				
			}
	

}
