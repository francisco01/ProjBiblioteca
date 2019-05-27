import java.util.HashMap;
import java.util.Scanner;

public class TesteBiblioteca {
	public static void InitCommand(String opc, String cod) {
		Command c;
		HashMap cmds = new HashMap();
		cmds.put("emp", new EmpCommand());
		cmds.put("dev", new DevCommand());
		cmds.put("res", new ResCommand());
		cmds.put("usu", new UsuCommand());
		cmds.put("liv", new LivCommand());
		cmds.put("obs", new ObsCommand());
		cmds.put("ntf", new NtfCommand());
		c = (Command) cmds.get(opc);
		c.execute(cod);
	}

	public static void main(String[] args) {

		Biblioteca biblioteca = Biblioteca.getInstancia();

		// Dados teste UsuÃ¡rios
		AlunoGraduacao grad = new AlunoGraduacao("123", "Joao da Silva");
		AlunoGraduacao grad2 = new AlunoGraduacao("789", "Pedro Paulo");
		Professor prof = new Professor("100", "Carlos Lucena");
		AlunoPosGraduacao posgrad = new AlunoPosGraduacao("456", "Luiz Fernando Rodrigues");

		Livro liv = new Livro("100", "Engenharia de Softaware", "Addison Wesley", "Ian Somrville", "6Âª", "2000");
		Livro liv2 = new Livro("101", "UML- Guia do Usuario", "Campus", "Grady Booch,James Rumbaugh,Ivar Jacobson",
				"7Âª", "2000");
		Livro liv3 = new Livro("200", "Code Complete", "Microsoft Press", "Steve Mc Connell", "7Âª", "2000");
		Livro liv4 = new Livro("201", "Agile Software Development,Principles,Patterns, and Practices", "Prentice Hall",
				"Robert Martin", "1Âª", "2002");
		Livro liv5 = new Livro("300", "Refactoring:Improving the DEsign of Existing Code",
				"Addison-Wesley Professional", "Martin Fowler", "1Âª", "1999");
		Livro liv6 = new Livro("301", "DEsign Patterns:Elements of Reusable Object-Oriented Software",
				"Addison Wesley Professional", "Erich Gamma,Richard Helm,Ralph Johnson,Jonh Vlissides", "1Âª", "1994");
		Livro liv7 = new Livro("400", "Design Patterns", "Addison", "Martin Fowler", "1ï¿½", "1999");
		Livro liv8 = new Livro("401", "UML Distilled: A Brief Guide to the Standard Object Modeling Language",
				"Addison Wesley", "Martin Fowler", "3Âª", "2003");

		Exemplar exmp1liv = new Exemplar(liv, "01", "Disponivel");
		Exemplar exmp2liv = new Exemplar(liv, "02", "Disponivel");
		Exemplar exmp1liv2 = new Exemplar(liv2, "03", "Disponivel");
		Exemplar exmp1liv3 = new Exemplar(liv3, "04", "Disponivel");
		Exemplar exmp1liv4 = new Exemplar(liv4, "05", "Disponivel");
		Exemplar exmp1liv5 = new Exemplar(liv5, "06", "Disponivel");
		Exemplar exmp2liv5 = new Exemplar(liv5, "07", "Disponivel");
		Exemplar exmp1liv7 = new Exemplar(liv7, "08", "Disponivel");
		Exemplar exmp2liv7 = new Exemplar(liv7, "09", "Disponivel");

		liv.exemplar.add(exmp1liv);
		liv.exemplar.add(exmp2liv);
		liv2.exemplar.add(exmp1liv2);
		liv3.exemplar.add(exmp1liv3);
		liv4.exemplar.add(exmp1liv4);
		liv5.exemplar.add(exmp1liv5);
		liv5.exemplar.add(exmp2liv5);
		liv7.exemplar.add(exmp1liv7);
		liv7.exemplar.add(exmp2liv7);

		biblioteca.usu.add(grad);
		biblioteca.usu.add(grad2);
		biblioteca.usu.add(prof);
		biblioteca.usu.add(posgrad);
		biblioteca.liv.add(liv);
		biblioteca.liv.add(liv2);
		biblioteca.liv.add(liv3);
		biblioteca.liv.add(liv4);
		biblioteca.liv.add(liv5);
		biblioteca.liv.add(liv7);

		String operacao;
		String codigo;
		String opc;
		System.out.println(
				"---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- ");
		System.out.println(
				">>>>                                  SISTEMA DE BIBLIOTECAS SISB                             >>>>");
		System.out.println(
				"---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- ");

		System.out.println(">>>>           MENU  DE COMANDOS            >>>>");
		System.out.println();
		System.out.println("      emp ---- CADASTRAR EMPRESTIMO");
		System.out.println("      dev ---- CADASTRAR DEVOLU��O");
		System.out.println("      res ---- CADASTRAR RESERVA");
		System.out.println("      usu ---- CONSULTAR USU�RIO");
		System.out.println("      liv ---- CONSULTAR LIVRO");
		System.out.println("      obs ---- CADASTRAR OBSERVADORES");
		System.out.println("      ntf ---- CONSULTAR NOTIFICAC�ES");
		System.out.println("      sai ---- SAIDA");
		System.out.println();
		System.out.println();
		System.out.println();

		System.out.print("  Informe o comando / codigo do usuario / codigo do livro :  ");
		Scanner entrada = new Scanner(System.in);
		operacao = entrada.nextLine();
		System.out.println();
		System.out.println(">>>> MENSAGEM  >>>>");
		System.out.println();
		while (!operacao.equals("sai")) {
			opc = operacao.substring(0, 3);
			codigo = operacao.substring(4, operacao.length());
			InitCommand(opc, codigo);
			System.out.println();
			System.out.println(
					"---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- ");
			System.out.print("  Informe o comando / codigo do usuario / codigo do livro :  ");
			operacao = entrada.nextLine();
			System.out.println();
			System.out.println(">>>> Mensagem  >>>>");
			System.out.println();

		}
		System.out.println(">>>> ENCERRANDO A APLICA��O!  >>>>");

	}

}
