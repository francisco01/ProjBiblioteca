import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

public class Professor extends Usuario implements Observer{
	public int contNotif = 0;
	
	public Professor(String codusu, String nome) {
		this.codigo = codusu;
		this.nome = nome;
		this.compemp = new Prof();
	}
	
	public void display(){
		System.out.println("Foram observadas: " + this.contNotif + " vezes");
	}

	@Override
	public Date CalcularDataDev() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.DATE, 4);
		return cal.getTime();
	}
	@Override
	public Boolean QuantEmp(Usuario usu) {
		return true;
	}

	@Override
	public void update() {
		this.contNotif++;
	}
	

}
