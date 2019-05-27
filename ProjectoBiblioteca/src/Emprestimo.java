import java.util.Calendar;
import java.util.Date;

public class Emprestimo {
	public Date dtemp;
	public Date dtdvl;
	public Usuario usu;
	public Exemplar exmp;
	public String status;

	public Emprestimo(Date dtdvl, Usuario usu, Exemplar exmp, String status) {
		this.dtemp = new Date();
		this.dtdvl = dtdvl;
		this.usu = usu;
		this.exmp = exmp;
		this.status = status;
	}

	public String getNome() {
		return usu.getNome();
	}

	public String getCodigolivro() {
		return exmp.getCodliv();
	}

	public String getTitulo() {
		return exmp.liv.getTitulo();
	}

	public Date getDtemp() {
		return dtemp;
	}

	public Date getDtdvl() {
		return dtdvl;
	}

	public String getStatus() {
		return status;
	}

	public void setDtdvl(Date dtdvl) {
		this.dtdvl = dtdvl;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
