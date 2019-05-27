
public class LivCommand implements Command {

	public String codliv;
	@Override
	public void execute(String codigo) {
		codliv = codigo.substring(0, 3);
		Biblioteca biblioteca = Biblioteca.getInstancia();
		biblioteca.fzrConsultaLivro(codliv);
	}

}
