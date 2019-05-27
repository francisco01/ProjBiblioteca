import java.util.Date;
import java.util.Iterator;

public class Prof implements ComportamentoEmp {

	@Override
	public boolean emprestar(Usuario usu, Livro liv, boolean temreserva) {
			mostraemp(usu, liv);
			return true;
	}

	public void mostraemp(Usuario usu, Livro liv) {
		System.out.println("O livro " + liv.getTitulo() + " foi emprestado para o professor: " + usu.getNome());
	}

}
