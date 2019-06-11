
public class NtfCommand extends Comandos implements Command {

	//public String codusu;
	@Override
	public void execute(String codigo) {
		codusu = codigo.substring(0, 3);
		Biblioteca biblioteca = Biblioteca.getInstancia();
		biblioteca.fzrConsultaUsuarioProf(codusu);
	}

}
