import java.util.Date;

public class Reserva {
	public Livro liv;
	public Date dataResrva;
	public Usuario usu;
	public Reserva(Date dtreserva, Usuario usu, Livro liv){
		this.dataResrva = dtreserva;
		this.usu = usu;
		this.liv = liv;
	}
	public Date getDataResrva() {
		return dataResrva;
	}
	
}
