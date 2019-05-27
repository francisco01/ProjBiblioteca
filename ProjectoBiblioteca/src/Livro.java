import java.util.ArrayList;
import java.util.Iterator;

public class Livro implements Subject {

	public String codigo;
	public String titulo;
	public String editora;
	public String edicao;
	public String ano_publicacao;
	public String autor;
	private ArrayList observers;
	ArrayList<Exemplar> exemplar = new ArrayList();
	ArrayList<Reserva> reserva = new ArrayList();

	public Livro(String codliv, String titulo, String edit, String autor, String edcao, String anopublic) {
		this.codigo = codliv;
		this.titulo = titulo;
		this.editora = edit;
		this.edicao = edcao;
		this.ano_publicacao = anopublic;
		this.autor = autor;
		observers = new ArrayList();
	}

	public String getCodigo() {
		return codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void consultarLivro(Livro liv) {
		System.out.println("Titulo do Livro: " + liv.getTitulo());
		System.out.println("Quantidade de reserva: " + liv.reserva.size());
		if (liv.reserva.size() > 0) {
			consultarReserva(liv);
		}
	}

	public void consultarReserva(Livro liv) {
		Iterator<Reserva> res = liv.reserva.iterator();
		Iterator<Exemplar> exemplar = liv.exemplar.iterator();
		System.out.println("Lista dos usuarios que reservaram esse livro: ");
		while (res.hasNext()) {
			Reserva cadares = res.next();
			System.out.println(cadares.usu.getNome());
		}
		while (exemplar.hasNext()) {
			Exemplar cadaexemplar = exemplar.next();
			System.out.println(
					"Codigo do exemplar: " + cadaexemplar.getCodexemplar() + " Status: " + cadaexemplar.getStatus());
			if (cadaexemplar.getStatus().equals("Emprestado")) {
				System.out.println("Nome: " + cadaexemplar.emp.getNome() + " Data do emprestimo: " + cadaexemplar.emp.getDtemp()
				+ " Data da devolucao: " + cadaexemplar.emp.getDtdvl());
			}
		}
	}

	@Override
	public void registerObserver(Observer o) {
		// TODO Auto-generated method stub
		observers.add(o);
	}

	@Override
	public void notifyObservers() {
		// TODO Auto-generated method stub
		for (int i = 0; i < observers.size(); i++) {
			Observer observer = (Observer)observers.get(i);
			observer.update();
		}
	}

}
