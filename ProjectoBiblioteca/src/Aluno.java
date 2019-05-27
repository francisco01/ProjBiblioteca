import java.util.Date;
import java.util.Iterator;

public class Aluno implements ComportamentoEmp {

	@Override
	public boolean emprestar(Usuario usu, Livro liv, boolean temreserva) {
		if (temreserva) {
			if (liv.reserva.size() >= liv.exemplar.size() || liv.reserva.size() < liv.exemplar.size()) {
				mostraemp(usu, liv);
				return true;
			}
		} else if (!temreserva) {
			if (liv.reserva.size() < liv.exemplar.size()) {
				mostraemp(usu, liv);
				return true;
			} else if (liv.reserva.size() > liv.exemplar.size()) {
				return false;
			}
		}
		return false;
	}

	public void mostraemp(Usuario usu, Livro liv) {
		System.out.println("   O livro " + liv.getTitulo() + " foi emprestado para o aluno: " + usu.getNome());
	}

}
