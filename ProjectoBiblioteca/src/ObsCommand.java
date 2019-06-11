
public class ObsCommand extends Comandos implements Command {

	//public String codliv;
	//public String codusu;
	@Override
	public void execute(String codigo) {
		//codusu = codigo.substring(0, 3);
		//codliv = codigo.substring(4, 7);
		Biblioteca biblioteca = Biblioteca.getInstancia();
		biblioteca.registrarProfObs(getCodusu(codigo), getCodliv(codigo));
	}

}
