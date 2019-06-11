
public class UsuCommand extends Comandos implements Command {

	//public String codusu;
	//public String codliv;
	@Override
	public void execute(String codigo) {
		codusu = codigo.substring(0, 3);
		Biblioteca biblioteca = Biblioteca.getInstancia();
		biblioteca.fzrConsultaUsuario(codusu);
	}

}
