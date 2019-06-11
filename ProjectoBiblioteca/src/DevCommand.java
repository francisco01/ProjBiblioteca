
public class DevCommand extends Comandos implements Command {

	//public String codusu;
	//public String codliv;
	@Override
	public void execute(String codigo) {
		//codusu = codigo.substring(0, 3);
		//codliv = codigo.substring(4, 7);
		Biblioteca biblioteca = Biblioteca.getInstancia();
		biblioteca.fzdDevolucao(getCodusu(codigo), getCodliv(codigo));
	}

}
