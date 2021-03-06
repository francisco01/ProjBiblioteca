import java.util.Calendar;
import java.util.Date;

public class AlunoGraduacao extends Usuario {

	public AlunoGraduacao(String codusu, String nome) {
		this.codigo = codusu;
		this.nome = nome;
		this.compemp = new Aluno();
	}

	@Override
	public Date CalcularDataDev() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.DATE, 1);
		return cal.getTime();
	}
	@Override
	public Boolean QuantEmp(Usuario usu) {
		if (usu.emprestimos.size() < 3) {
			return true;
		}
		return false;
	}

}
