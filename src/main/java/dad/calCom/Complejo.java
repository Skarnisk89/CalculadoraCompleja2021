package dad.calCom;



	

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class Complejo {

	private DoubleProperty real = new SimpleDoubleProperty();
	private DoubleProperty imaginario = new SimpleDoubleProperty();
	
	public Complejo() {}
	
	public Complejo(double real, double imaginario) {
		super();
		setReal(real);
		setImaginario(imaginario);
	}

	public final DoubleProperty realProperty() {
		return this.real;
	}

	public final double getReal() {
		return this.realProperty().get();
	}

	public final void setReal(final double real) {
		this.realProperty().set(real);
	}

	public final DoubleProperty imaginarioProperty() {
		return this.imaginario;
	}

	public final double getImaginario() {
		return this.imaginarioProperty().get();
	}

	public final void setImaginario(final double imaginario) {
		this.imaginarioProperty().set(imaginario);
	}
	
	@Override
	public String toString() {
		return getReal() + "+" + getImaginario() + "i";
	}
	
	public Complejo add(Complejo c) {
		Complejo r = new Complejo();
		r.realProperty().bind(realProperty().add(c.realProperty()));
		r.imaginarioProperty().bind(imaginarioProperty().add(c.imaginarioProperty()));
		return r;
	}
	
	public Complejo multiply(Complejo c) {
		Complejo r = new Complejo();
        r.realProperty().bind(realProperty().multiply(c.realProperty())
                .subtract(imaginarioProperty().multiply(c.imaginarioProperty())));
        r.imaginarioProperty().bind(realProperty().multiply(c.imaginarioProperty())
                .add(imaginarioProperty().multiply(c.realProperty())));
        return r;
		
		
	}
	
	public Complejo divide(Complejo c) {
		Complejo r = new Complejo();
        r.realProperty().bind((realProperty()
                .multiply(c.realProperty())
                .add(imaginarioProperty().multiply(c.imaginarioProperty())))
                .divide(c.realProperty().multiply(c.realProperty()).add(c.imaginarioProperty().multiply(c.imaginarioProperty()))));
	
        r.imaginarioProperty().bind((imaginarioProperty()
                .multiply(c.realProperty())
                .subtract(realProperty().multiply(c.imaginarioProperty())))
                .divide(c.realProperty().multiply(c.realProperty()).add(c.imaginarioProperty().multiply(c.imaginarioProperty()))));
        
        return r;
	}
	
	public Complejo substract(Complejo c) {
		Complejo r = new Complejo();
		r.realProperty().bind(realProperty().subtract(c.realProperty()));
		r.imaginarioProperty().bind(imaginarioProperty().subtract(c.imaginarioProperty()));
		return r;
	}
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
