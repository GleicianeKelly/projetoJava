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

	static SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
	static List<VendaComissionada> listaVendas = new ArrayList<VendaComissionada>();
	static List<Colaborador> listaColaborador = new ArrayList<Colaborador>();  
	static List<Contrato> listaContrato = new ArrayList<Contrato>();
	static Scanner ler = new Scanner (System.in);
	public static void main(String[] args) throws ParseException {
		
		
		
		
		
		int opcao = 0;
		
		while(true) {
			
			System.out.println("** Cadastro de colaboradores** ");
			System.out.println("Digite 1 para cadastrar colaborador ");
			System.out.println("Digite 2 para registrar contrato Assalariado ");
			System.out.println("Digite 3 para registrar contrato Comissionado ");
			System.out.println("Digite 4 para registrar contrato Horista ");	
			System.out.println("Digite 5 para consultar contrato ");
			System.out.println("Digite 6 para encerrar contrato ");
			System.out.println("Digite 7 para listar colaboradores ativos ");
			System.out.println("Digite 8 para consultar contrato do colaborador ");
			System.out.println("Digite 9 lan�ar vendas comissionadas ");
			System.out.println("Digite 10 para emitir folha de pagamento");
			System.out.println("Para encerrar digite 0");
			
			opcao = ler.nextInt();
			
			switch(opcao) {
			
			case 0:
				System.out.println("** Programa finalizado** ");
				break;
			
			case 1: 
				inserirColaborador();
				break;
				
			case 2:
				registrarContratoAssalariado();
				break;
				
			case 3: 
				registrarContratoComissionado();
				break;
				
			case 4:
				registrarContratoHorista();
				break;
				
				
			case 5:
				consultarContrato();
				break;
				
				
			case 6:
				encerrarContrato();
				break;
				
				
			case 7:
				listarColaboradoresAtivos();
				break;
				
			case 8:
				consultarContratoColaborador();
				break;
				
			case 9:
				lancarVendaComissionada();
				break;
				
			case 10:
				emitirFolhaPagamento();
				break;
				
			
			default:
				System.out.println("N�mero inv�lido! Digite novamente: ");
				break;
					
			}
			
			
		}
		
		
		
		
		
		
	
	}
		//M�todo que pesquisa colaborador, se ele est� na lista ou n�o existe
		public static Colaborador pesquisarColaborador(String matriculaColaborador) {
			for(Colaborador colaborador : listaColaborador) {
				if(colaborador.getMatricula().equals(matriculaColaborador)) {
					return colaborador;
				}
			}
			return null;
		}
		
		//M�todo que pesquisa o contrato, se ele est� na lista ou n�o existe
		public static Contrato pesquisarContrato(int IdContrato) {
			for(Contrato contrato : listaContrato) {
				if(contrato.getId() == IdContrato) {
					return contrato;
				}
			}return null;
		}
		
		/*M�todo que pesquisa o contrato do colaborador, recebe uma
		* String com a matricula do colaborador e diz qual o n�mero de
		* contrato dele
		*/
		public static Contrato pesquisarContratoColaborador (String matricula){
			for(Contrato contrato : listaContrato) {
				if(contrato.getColaborador().getMatricula().equals(matricula)) {
					return contrato;
				}
			}
			return null;
		}
		
		/*M�todo que diz o nome da classe do contrato encontrado. Primeiro
		* descobre o contrato pelo id chamando o m�todo pesquisarContrato,
		* e depois passa o contrato encontrado dentro do par�metro para v� de
		* qual classe ele pertence pelo instanceof
		*/
		public static String pesquisarClasse(Contrato contratoEncontrado){

		String contrato = "";
	
			if(contratoEncontrado instanceof ContratoAssalariado){
				contrato = " **Contrato Assalariado** ";
			}
			else if(contratoEncontrado instanceof ContratoComissionado){
				contrato = " **Contrato Comissionado** ";
			}
			else{
				contrato = " **Contrato Horista** ";
			}
				return contrato;
		}

		//M�todo que valida CPF e diz se ele � v�lido ou n�o
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
		
		//M�todo que compara dois anos e faz a subtra��o para tirar a idade
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
		

		/*M�todo que valida a matr�cula. Varre toda a String e verifica Char
		* por Char usando a condi��o que seja igual a n�mero para n�o ter
		* letras
		*/
		public static boolean validarMatricula(String matriculaColaborador) {
			
			boolean validarMatricula = false;
			
			for(int c = 0 ; c < matriculaColaborador.length() ; c++) {
				if(matriculaColaborador.charAt(c) == '1' || matriculaColaborador.charAt(c) == '2'
					||	matriculaColaborador.charAt(c) == '3' || matriculaColaborador.charAt(c) == '4' || matriculaColaborador.charAt(c) == '5'
					|| matriculaColaborador.charAt(c) == '6' || matriculaColaborador.charAt(c) == '7' ||
					matriculaColaborador.charAt(c) ==  '8' || matriculaColaborador.charAt(c) == '9'
					|| matriculaColaborador.charAt(c) == '0') {
					
					return validarMatricula = true;
					
				}
				else {
					return validarMatricula = false;
				}
			}return validarMatricula;
		}
		
		
		//M�todo que insere o colaborador numa lista
		public static void inserirColaborador() throws ParseException{
			
			System.out.println(" **Inserir colaborador** ");
			
			
			while(true) {
				
				String matriculaColaborador = "", cpf, nome;
				
				
				System.out.println("Digite a matr�cula do colaborador: ");
				matriculaColaborador = ler.next();
				
				if(validarMatricula(matriculaColaborador) == false) {
					System.out.println("Digite um n�mero v�lido!! ");
					continue;
				}
					
			
				Colaborador colaboradorEncontrado = pesquisarColaborador(matriculaColaborador);
				
				if(colaboradorEncontrado != null) {
					System.out.println("Colaborador j� cadastrado!! ");
					continue;
				}
				
				System.out.println("Digite o CPF do colaborador: ");
				cpf = ler.next();
				
				if(validarCpf(cpf) == false ) {
					System.out.println("CPF inv�lido!! ");
					continue;
				}
				
				System.out.println("Digite o nome do colaborador: ");
				nome = ler.next();
					
				
				System.out.println("Digite a data de nascimento do colaborador: ");
	            System.out.println("Formato da data dd/MM/yyyy");
	            String dataInformada = ler.next();
	            Date data= formato.parse(dataInformada);
	            
	            
	            
	            if(retornarIdade(dataInformada) < 18) {
	            	System.out.println("Imposs�vel cadastrar, menor de 18 anos! ");
	            	continue;
	           	
	            }
	            
	            Colaborador colaborador = new Colaborador(matriculaColaborador, cpf, nome, data);
	            colaborador.validarCpf();
	            listaColaborador.add(colaborador);
	            
	            
	            System.out.println(listaColaborador.toString());
	            
	            System.out.println("Deseja sair do programa? [S] ou [N]");
				String resposta = ler.next();
				
				if(resposta.equalsIgnoreCase("S")) {
					System.out.println("Programa Encerrado! ");
					return;
				}
				else {
					continue;
				}
				
	            
	            
			}
			
			
			
			
			
		}
		
		//M�todo que registra o contrato assalariado de um colaborador
		public static void  registrarContratoAssalariado() throws ParseException {
			
			System.out.println("** Registrar Contrato assalariado **");
			
			if(listaColaborador.isEmpty()) {
				System.out.println("N�o h� colaborador na lista! ");
				return;
			}
			
			while(true) {
					
				String matriculaColaborador = "";
				float salarioMensal, percentualInsalubridade, percentualPericulosidade;
				
				
				
				System.out.println("Digite a data de in�cio: ");
	            System.out.println("Formato da data dd/MM/yyyy");
	            String dataInformadaInicio = ler.next();
	            Date dataInicio= formato.parse(dataInformadaInicio);
	            
	            
	            if(dataInicio.equals("0")) {
	            	System.out.println("Data digitada no formato incorreto!! ");
	            	break;
	            }
	            
	            if(dataInicio.before(new Date())) {
	            	System.out.println("Data de in�cio errada, anterior a data atual! ");
	            }
				
				
				System.out.println("Digite a data de Encerramento: ");
	            System.out.println("Formato da data dd/MM/yyyy");
	            String dataInformadaEncerramento = ler.next();
	            Date dataEncerramento= formato.parse(dataInformadaEncerramento);
	            
	            if(dataEncerramento.equals("0")) {
	            	System.out.println("Data digitada no formato incorreto!! ");
	            	continue;
	            }
	            
	           
	     
	            System.out.println("Digite a matr�cula do colaborador: ");
				matriculaColaborador = ler.next();
			

				if(validarMatricula(matriculaColaborador) == false) {
					System.out.println("Digite um n�mero v�lido!! ");
					continue;
				}
				
				
				Colaborador colaboradorEncontrado = pesquisarColaborador(matriculaColaborador);
				
				if(colaboradorEncontrado == null) {
					System.out.println("Colaborador n�o cadastrado!! ");
					continue;
				}
				
				System.out.println("Digite o sal�rio mensal: ");
				salarioMensal = ler.nextFloat();
				
				
				System.out.println("Digite o percentual de insalubridade: ");
				percentualInsalubridade = ler.nextFloat();
				
				System.out.println("Digite o percentual de periculosidade: ");
				percentualPericulosidade = ler.nextFloat();
				
				ContratoAssalariado contratoAssalariado = (new ContratoAssalariado(dataInicio, dataEncerramento, colaboradorEncontrado, 
						 salarioMensal, percentualInsalubridade, percentualPericulosidade));
				
				contratoAssalariado.setAtivo(true);
				colaboradorEncontrado.ativar();
				
				System.out.println("O id do contrato �: " + contratoAssalariado.getId()); 
				
				listaContrato.add(contratoAssalariado);
				
				System.out.println("Deseja sair do programa? [S] ou [N]");
				String resposta = ler.next();
				
				if(resposta.equalsIgnoreCase("S")) {
					System.out.println("Programa Encerrado! ");
					return;
				}
				else {
					continue;
				}
				
				
			}
			
			
		}
	
		//M�todo que registra o contrato assalariado de um colaborador
		public static void  registrarContratoComissionado() throws ParseException {
					
					System.out.println("** Registrar Contrato comissionado**");
					
					if(listaColaborador.isEmpty()) {
						System.out.println("N�o h� colaborador na lista! ");
						return;
					}
					
					while(true) {
						System.out.println("Para sair digite 0");
						
						
						String matriculaColaborador = "";
						float percentualComissao, ajudaCusto;
						
						
						System.out.println("Digite a data de in�cio: ");
			            System.out.println("Formato da data dd/MM/yyyy");
			            String dataInformadaInicio = ler.next();
			            Date dataInicio= formato.parse(dataInformadaInicio);
						

			            if(dataInicio.equals("0")) {
			            	System.out.println("Data digitada no formato incorreto!! ");
			            	break;
			            }
			            
			            if(dataInicio.before(new Date())) {
			            	System.out.println("Data de in�cio errada, anterior a data atual! ");
			            }
						
			            
						System.out.println("Digite a data de Encerramento: ");
			            System.out.println("Formato da data dd/MM/yyyy");
			            String dataInformadaEncerramento = ler.next();
			            Date dataEncerramento= formato.parse(dataInformadaEncerramento);
			            
			           
						
			            
						System.out.println("Digite a matr�cula do colaborador: ");
						matriculaColaborador = ler.next();
						
		
						if(validarMatricula(matriculaColaborador) == false) {
							System.out.println("Digite um n�mero v�lido!! ");
							continue;
						}
						
						
						Colaborador colaboradorEncontrado = pesquisarColaborador(matriculaColaborador);
						
						if(colaboradorEncontrado == null) {
							System.out.println("Colaborador n�o cadastrado!! ");
							continue;
						}
						
						
						System.out.println("Digite o percentual de comiss�o: ");
						percentualComissao = ler.nextFloat();
						
						System.out.println("Digite a ajuda de custo: ");
						ajudaCusto = ler.nextFloat();
						
						ContratoComissionado contratoComissionado = (new ContratoComissionado(dataInicio, dataEncerramento, colaboradorEncontrado, 
								 percentualComissao, ajudaCusto));
						
						System.out.println("O id do contrato �: " + contratoComissionado.getId()); 
						
						listaContrato.add(contratoComissionado);
						
						System.out.println("Deseja sair do programa? [S] ou [N]");
						String resposta = ler.next();
						
						if(resposta.equalsIgnoreCase("S")) {
							System.out.println("Programa Encerrado! ");
							return;
						}
						else {
							continue;
						}
						
						
					}
					
					
				}
			
		//M�todo que registra o contrato horista de um colaborador
		/*Id do contrato � mostrado aoo fim e � gerado de forma sequencial
		* pelo construtor da classe
		*/
		public static void  registrarContratoHorista() throws ParseException {
				
			System.out.println("** Registrar Contrato comissionado**");
				
			if(listaColaborador.isEmpty()) {
				System.out.println("N�o h� colaborador na lista! ");
				return;
			}
				
				while(true) {
					System.out.println("Para sair digite 0");
					
					
					String matriculaColaborador = "";
					int horaMes;
					float valorHora;
					Date dataAtual = new Date();
					
					
					System.out.println("Digite a data de in�cio: ");
		            System.out.println("Formato da data dd/MM/yyyy");
		            String dataInformadaInicio = ler.next();
		            Date dataInicio= formato.parse(dataInformadaInicio);
		            

		            if(dataInicio.equals("0")) {
		            	System.out.println("Data digitada no formato incorreto!! ");
		            	break;
		            }
		            
		            if(dataInicio.before(new Date())) {
		            	System.out.println("Data de in�cio errada, anterior a data atual! ");
		            }
					
					
		            
					System.out.println("Digite a data de Encerramento: ");
		            System.out.println("Formato da data dd/MM/yyyy");
		            String dataInformadaEncerramento = ler.next();
		            Date dataEncerramento= formato.parse(dataInformadaEncerramento);
		            
		          
					
		            
					System.out.println("Digite a matr�cula do colaborador: ");
					matriculaColaborador = ler.next();
					
					

					if(validarMatricula(matriculaColaborador) == false) {
						System.out.println("Digite um n�mero v�lido!! ");
						continue;
					}
						
										
					Colaborador colaboradorEncontrado = pesquisarColaborador(matriculaColaborador);
					
					if(colaboradorEncontrado == null) {
						System.out.println("Colaborador n�o cadastrado!! ");
						continue;
					}
					
					
					
					System.out.println("Digite o percentual de comiss�o: ");
					horaMes = ler.nextInt();
					
					System.out.println("Digite a ajuda de custo: ");
					valorHora = ler.nextFloat();
					
					ContratoHorista contratoHorista = (new ContratoHorista(dataInicio, dataEncerramento, colaboradorEncontrado, 
							 horaMes, valorHora));
					
					System.out.println("O id do contrato �: " + contratoHorista.getId()); 
					
					listaContrato.add(contratoHorista);
					
					System.out.println("Deseja sair do programa? [S] ou [N]");
					String resposta = ler.next();
					
					if(resposta.equalsIgnoreCase("S")) {
						System.out.println("Programa Encerrado! ");
						return;
					}
					else {
						continue;
					}
					
					
				}
				
				
			}

		//M�todo que recebe o Id de um contrato e consulta
		public static void consultarContrato() {
				
			System.out.println(" **Consultar contrato** ");
				
			while(true) {
					
				int idContrato;
					
				System.out.println("Digite o Id do contrato");
				idContrato = ler.nextInt();
					
				Contrato contratoEncontrado = pesquisarContrato(idContrato);	
					
				if(contratoEncontrado == null) {
						System.out.println("Contrato n�o existe!! ");
						return;
				}
					

	           
				
				System.out.println(contratoEncontrado.getId()); 
				System.out.println(formato.format(contratoEncontrado.getDataInicio()));						
				System.out.println(formato.format(contratoEncontrado.getDataEncerramento()));		
				System.out.println(contratoEncontrado.isAtivo());	;
				System.out.println(contratoEncontrado.getColaborador().getMatricula());	
				System.out.println(contratoEncontrado.getColaborador().getNome());	
				System.out.println(contratoEncontrado.getColaborador().getCpf());	
				System.out.println(contratoEncontrado.getColaborador().isSituacao());	
					
				String classeEncontrada = pesquisarClasse(contratoEncontrado);

				System.out.println(classeEncontrada);
					
				System.out.println("Deseja sair do programa? [S] ou [N]");
				String resposta = ler.next();
				
				if(resposta.equalsIgnoreCase("S")) {
					System.out.println("Programa Encerrado! ");
					return;
				}
				else {
					continue;
				}
			}
				
				
				
		}
	
		
			
		/*M�todo que verifica se um contrato existe ou j� foi encerrado,
		 * verifica tamb�m a data de encerramento que n�o pode ser ap�s a data 
		 * atual. Encerra o contrato, desativa o colaborador e coloca no contrato a data de encerramento
		 */
		
		
		public static void encerrarContrato() throws ParseException {
				
			System.out.println(" **Encerrar contrato** ");
				
			while(true) {
					
				int idContrato;
					
					
				System.out.println("Digite o Id do contrato: ");
				idContrato = ler.nextInt();
					
				Contrato contratoEncontrado = pesquisarContrato(idContrato);
					
				if(contratoEncontrado == null) {
					System.out.println("Contrato n�o existe!!");
					return;
				}
					
				if(contratoEncontrado.isAtivo() == false) {
					System.out.println("Contrato j� encerrado!! ");
					return;
				}
					
				
				System.out.println("Digite a data de encerramento: ");
		        System.out.println("Formato da data dd/MM/yyyy");
		        String dataInformadaEncerramento = ler.next();
		        Date dataEncerramento= formato.parse(dataInformadaEncerramento);
					
					
					
		        if(dataEncerramento.after(new Date())) {
					System.out.println("Data de encerramento posterior a data atual! ");
					continue;
				}
					
				contratoEncontrado.encerrarContrato();
					
				contratoEncontrado.getColaborador().desativar();
					
				contratoEncontrado.setDataEncerramento(dataEncerramento);
				
				System.out.println(contratoEncontrado.isAtivo());
				System.out.println(contratoEncontrado.getColaborador().isSituacao());
				System.out.println(contratoEncontrado.getDataEncerramento());
					
				
				System.out.println("Deseja sair do programa? [S] ou [N]");
				String resposta = ler.next();
				
				if(resposta.equalsIgnoreCase("S")) {
					System.out.println("Programa Encerrado! ");
					return;
				}
				else {
					continue;
				}
				
			}
				
			
		}
			
			
		//M�todo que lista todos os colaboradores ativos
		public static void listarColaboradoresAtivos() {
				
			System.out.println(" **Listar colaboradores ativos** ");
				
			if(listaColaborador.isEmpty()) {
				System.out.println("N�o h� colaboradores na lista!! ");
				return;
			}
				
				
			for(Colaborador colaborador : listaColaborador) {
				if(colaborador.isSituacao()) {
					System.out.println(colaborador.getMatricula());
					System.out.println(colaborador.getNome());
					System.out.println(colaborador.getCpf());
						
				}else {
					System.out.println("N�o h� colaboradores ativos!! ");
							break;
						}	
				
			}
				
				while(true) {
					
				System.out.println("Deseja sair do programa? [S] ou [N]");
				String resposta = ler.next();
				
				if(resposta.equalsIgnoreCase("S")) {
					System.out.println("Programa Encerrado! ");
					return;
				}
				else {
					continue;
				}
				
			}
				
				
		}
			
		/*M�todo que consulta o contrato do colaborador pela 
		 * matr�cula dele. 
		 * Digita a matr�cula e chama o m�todo que pela matr�cula encontra
		 * o colaborador. Encontrando o colaborador, mostra os dados dele.
		 * Para mostrar os dados do contrato dele, tem que chamar o m�todo que 
		 * varre o contrato e ao passar a matr�cula por par�metro, acha o contrato. 
		 * Ap�s isso chama o m�todo que verifica a classe onde o objeto foi instanciado
		 * 	
		 */
		
		public static void consultarContratoColaborador() {
			System.out.println(" **Consultar colaborador** ");
				
			while(true) {
					
				String matriculaColaborador = "";
					
				System.out.println("Digite a matr�cula do funcion�rio: ");
				matriculaColaborador = ler.next();
					

				if(validarMatricula(matriculaColaborador) == false) {
					System.out.println("Digite um n�mero v�lido!! ");
					continue;
				}
					
					
				Colaborador colaboradorEncontrado = pesquisarColaborador(matriculaColaborador);
					
				if(colaboradorEncontrado == null) {
					System.out.println("Colaborador n�o cadastrado!! ");
				}
					
				System.out.println(colaboradorEncontrado.getMatricula()); 
				System.out.println(colaboradorEncontrado.getCpf()); 
				System.out.println(colaboradorEncontrado.isSituacao()); 
					
					
				Contrato  contratoEncontrado =  pesquisarContratoColaborador (matriculaColaborador);
					
					
				System.out.println(contratoEncontrado.getId()); 
				System.out.println(contratoEncontrado.getDataInicio());
				System.out.println(contratoEncontrado.getDataEncerramento());
				System.out.println(contratoEncontrado.isAtivo());
					

				String classeEncontrada = pesquisarClasse(contratoEncontrado);

				System.out.println(classeEncontrada);
					
					
				System.out.println("Deseja sair do programa? [S] ou [N]");
				String resposta = ler.next();
				
				if(resposta.equalsIgnoreCase("S")) {
					System.out.println("Programa Encerrado! ");
					return;
				}
				else {
					continue;
				}
				
			}
		}
			
		//Verifica se as vendas � de contrato comissionado e instancia o objeto	
		public static void lancarVendaComissionada () {
			
			System.out.println(" **Lan�ar vendas comissionadas** ");
			
			while(true) {
				
				int idContrato;
				int mes, ano;
				float valor;
				
				try {
				System.out.println("Digite o ID do contrato: ");
				idContrato = ler.nextInt();
				}
				catch(Exception e) {
					System.out.println("N�mero incorreto! Digite novamente: ");
					ler.nextLine();
					continue;
				}
				
				Contrato contratoEncontrado = pesquisarContrato(idContrato);
				
				if(contratoEncontrado == null) {
					System.out.println("Contrato n�o cadastrado!! ");
					continue;
				}
				
				if(contratoEncontrado.isAtivo() == false) {
					System.out.println("Contrato j� encerrado!! ");
					continue;
				}
				
				if(!(contratoEncontrado instanceof ContratoComissionado)) {
					System.out.println("Contrato digitado n�o � de "
							+ "contrato comissionado! ");
					continue;
				}
				
				System.out.println("Digite o m�s: ");
				System.out.println("Ex: 01...");
				mes = ler.nextInt();
				
				System.out.println("Digite o ano: ");
				System.out.println("Ex: 2021");
				ano = ler.nextInt();
				
				System.out.println("Digite o valor total das vendas: ");
				valor = ler.nextFloat();
				
				VendaComissionada vendaComissionada = new VendaComissionada (mes, ano, valor, (ContratoComissionado)contratoEncontrado);
				
				listaVendas.add(vendaComissionada);
				
				
			}
			
			
			
			
		}
		
		//Manuten��o que emite a folha de pagamento com os dados do contrato	
		public static void emitirFolhaPagamento() {

			System.out.println(" **Emitir folha de pagamento** ");


			while(true) {

				int mes, ano;
	
				String dadosContrato = "";
				
				System.out.println("Digite o m�s da folha a ser emitida: ");
				mes = ler.nextInt();
	
				System.out.println("Digite o ano da folha a ser emitida: ");
				ano = ler.nextInt();
	
				for(Contrato contrato : listaContrato) {
					if(contrato.isAtivo()) { 
	
						dadosContrato = "\nId: " + contrato.getId() +
						"\n Matr�cula: " + contrato.getColaborador().getMatricula() +
						"\n Nome: " + contrato.getColaborador().getNome() +
						"\nSal�rio: " ;
					}
				
		
				if(contrato instanceof ContratoAssalariado){
					dadosContrato += ((ContratoAssalariado) contrato).calcVencimento();
					
				}
	
	
				else if(contrato instanceof ContratoComissionado){
					for(VendaComissionada vendaComissionada : listaVendas) {
							if(vendaComissionada.getContrComissionado().equals(contrato)){
								dadosContrato += ((ContratoComissionado) contrato).calcVencimento(vendaComissionada.getValor());
						
							}
					}
				}

			
			else if(contrato instanceof ContratoHorista){
				dadosContrato += ((ContratoHorista) contrato).calcVencimento();
			}

			System.out.println(dadosContrato);

			}

			
		}

		}


			
}
		

