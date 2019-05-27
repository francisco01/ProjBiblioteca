import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Vector;

public abstract class Usuario {

	public String nome;
	public String codigo;
	ComportamentoEmp compemp;
	ArrayList<Emprestimo> emprestimos = new ArrayList();
	ArrayList<Reserva> reserva = new ArrayList();

	public String getNome() {
		return nome;
	}

	public String getCodigo() {
		return codigo;
	}

	public ComportamentoEmp getCompemp() {
		return compemp;
	}

	public abstract Date CalcularDataDev();

	public abstract Boolean QuantEmp(Usuario usu);

	public Boolean verifikemp(Usuario usu, Livro liv) {
		Iterator<Emprestimo> emp = usu.emprestimos.iterator();
		while (emp.hasNext()) {
			Emprestimo cada = emp.next();
			if (cada.getCodigolivro().equals(liv.getCodigo()) && cada.getStatus().equals("Em curso")) {
				return false;
			}
		}
		return true;
	}

	public Boolean verifikdevedor(Usuario usu, Livro liv) {
		Date data_atual = new Date();
		Iterator<Emprestimo> emp = usu.emprestimos.iterator();
		while (emp.hasNext()) {
			Emprestimo cada = emp.next();
			if (cada.dtdvl.compareTo(data_atual) < 0 && cada.getStatus().equals("Em curso")) {
				return false;
			}
		}
		return true;
	}

	public void emprestar(Usuario usu, Livro liv) {
		Date datadvl;
		boolean temreserva = false;
		Iterator<Reserva> res = liv.reserva.iterator();
		Iterator<Exemplar> exmp = liv.exemplar.iterator();
		datadvl = usu.CalcularDataDev();
		while (res.hasNext()) {
			Reserva cadareserva = res.next();
			if (cadareserva.usu.getCodigo().equals(usu.getCodigo())
					&& cadareserva.liv.getCodigo().equals(liv.getCodigo())) {
				temreserva = true;
				break;
			}
		}
		while (exmp.hasNext()) {
			Exemplar cadaexemplar = exmp.next();
			if (cadaexemplar.getStatus().equals("Disponivel")) {
				if (verifikemp(usu, liv) && verifikdevedor(usu, liv) && usu.QuantEmp(usu)
						&& this.compemp.emprestar(usu, liv, temreserva)) {
					usu.emprestimos.add(new Emprestimo(datadvl, usu, cadaexemplar, "Em curso"));
					cadaexemplar.emp = new Emprestimo(datadvl, usu, cadaexemplar, "Em curso");
					cadaexemplar.setStatus("Emprestado");
					if (temreserva) {
						res.remove();
					}
					return;
				} else if (!verifikemp(usu, liv)) {
					System.out.println("Usuario ja possui este livro como emprestimo!");
					return;
				} else if (!verifikdevedor(usu, liv)) {
					System.out.println("Usuario esta devendo um livro!");
					return;
				} else if (!QuantEmp(usu)) {
					System.out.println("Usuario excedeu limite de emprestimos!");
					return;
				} else if (!this.compemp.emprestar(usu, liv, temreserva)) {
					System.out.println("Exemplares todos reservados.");
					return;
				}
			}
		}
		System.out.println("Exemplares todos emprestados!");
	}

	public void Devolucao(Usuario usu, Livro liv) {
		Iterator<Emprestimo> empusu = usu.emprestimos.iterator();
		Iterator<Exemplar> exempliv = liv.exemplar.iterator();
		while (empusu.hasNext()) {
			Emprestimo cadaempusu = empusu.next();
			if (cadaempusu.getCodigolivro().equals(liv.getCodigo())) {
				cadaempusu.setStatus("Finalizado");
				cadaempusu.setDtdvl(new Date());
				System.out.println("O livro " + cadaempusu.getTitulo() + " foi devolvido por " + cadaempusu.getNome());
				while (exempliv.hasNext()) {
					Exemplar cadaexemplar = exempliv.next();
					if (cadaexemplar.getStatus().equals("Emprestado")) {
						cadaexemplar.setStatus("Disponivel");
						return;
					}
				}
			}
		}
		System.out.println("Nao ha emprestimo desse livro realizado por esse usuario!");

	}

	public void Reserva(Usuario usu, Livro liv) {

		Date dt_atual = new Date();

		if (usu.reserva.size() < 3) {
			liv.reserva.add(new Reserva(dt_atual, usu, liv));
			usu.reserva.add(new Reserva(dt_atual, usu, liv));
			System.out.println("Usuario " + usu.getNome() + " fez reserva do livro " + liv.getTitulo() + " !");
		} else {
			System.out.println("Usuario " + usu.getNome() + " nao pode fazer reserva do livro " + liv.getTitulo()
					+ " pois esta no limite de reserva!");
		}
		consultaReserva(liv);

	}

	public void consultaUsuario(Usuario usu) {
		Iterator<Emprestimo> empusu = usu.emprestimos.iterator();
		Iterator<Reserva> resusu = usu.reserva.iterator();
		while (empusu.hasNext()) {
			Emprestimo cadaemp = empusu.next();
			System.out.println(
					"Titulo do Livro emprestado " + cadaemp.getTitulo() + " data do emprestimo " + cadaemp.getDtemp()
							+ " status: " + cadaemp.getStatus() + "  data devolucao " + cadaemp.getDtdvl());
		}
		while (resusu.hasNext()) {
			Reserva cadares = resusu.next();
			System.out.println("Titulo do Livro reservado " + cadares.liv.getTitulo() + " data da reserva "
					+ cadares.getDataResrva());
		}
	}

	public void consultaReserva(Livro liv) {
		int cont = 0;
		Iterator<Reserva> res = liv.reserva.iterator();
		while (res.hasNext()) {
			Reserva cadares = res.next();
			if (liv.getCodigo().equals(cadares.liv.getCodigo())) {
				cont++;
				if (cont >= 3) {
					liv.notifyObservers();
					return;
				}
			} else {
				cont = 0;
			}
		}
	}

	public void registrarObservador(Usuario usu, Livro liv) {
		Professor prof = (Professor) usu;
		liv.registerObserver(prof);
		System.out.println("Professor:  " + prof.getNome() + " está observando o livro: " + liv.getTitulo() );
	}

	public void mostrarNotificados(Usuario usu) {
		Professor prof = (Professor) usu;
		prof.display();
	}
}
