import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class Biblioteca {
	ArrayList<Usuario> usu = new ArrayList();
	ArrayList<Livro> liv = new ArrayList();
	public static Biblioteca instancia;

	private Biblioteca() {

	}

	public static Biblioteca getInstancia() {
		if (instancia == null) {
			instancia = new Biblioteca();
		}
		return instancia;
	}

	public Usuario buscarUsu(String codusu) {
		Iterator<Usuario> usu = this.usu.iterator();
		while (usu.hasNext()) {
			Usuario cadausu = usu.next();
			if (cadausu.getCodigo().equals(codusu)) {
				return cadausu;
			}
		}
		return null;
	}

	public Livro buscarLiv(String codliv) {
		Iterator<Livro> liv = this.liv.iterator();
		while (liv.hasNext()) {
			Livro cadaliv = liv.next();
			if (cadaliv.getCodigo().equals(codliv)) {
				return cadaliv;
			}
		}
		return null;
	}

	public void fzremprestimo(String codusu, String codliv) {
		Iterator<Usuario> usu = this.usu.iterator();
		Usuario cadausu = usu.next();
		cadausu.emprestar(buscarUsu(codusu), buscarLiv(codliv));
	}

	public void fzdDevolucao(String codusu, String codliv) {
		Iterator<Usuario> usu = this.usu.iterator();
		Usuario cadausu = usu.next();
		cadausu.Devolucao(buscarUsu(codusu), buscarLiv(codliv));
	}

	public void fzrReserva(String codusu, String codliv) {
		Iterator<Usuario> usu = this.usu.iterator();
		Usuario cadausu = usu.next();
		cadausu.Reserva(buscarUsu(codusu), buscarLiv(codliv));
	}

	public void fzrConsultaLivro(String codliv) {
		Iterator<Livro> liv = this.liv.iterator();
		Livro cadaliv = liv.next();
		cadaliv.consultarLivro(buscarLiv(codliv));

	}

	public void fzrConsultaUsuario(String codusu) {
		Iterator<Usuario> usu = this.usu.iterator();
		Usuario cadausu = usu.next();
		cadausu.consultaUsuario(buscarUsu(codusu));

	}

	public void registrarProfObs(String codusu, String codliv) {
		Iterator<Usuario> usu = this.usu.iterator();
		Usuario cadausu = usu.next();
		cadausu.registrarObservador(buscarUsu(codusu), buscarLiv(codliv));
	}

	public void fzrConsultaUsuarioProf(String codusu) {
		Iterator<Usuario> usu = this.usu.iterator();
		Usuario cadausu = usu.next();
		cadausu.mostrarNotificados(buscarUsu(codusu));

	}
}
