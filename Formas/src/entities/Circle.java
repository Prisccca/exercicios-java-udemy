package entities;

public class Circle extends Shape {
	
	private Double raio;
	
	
	public Circle(Color color, Double raio) {
		super(color);
		this.raio = raio;
	}

	
	public Double getRaio() {
		return raio;
	}

	public void setRaio(Double raio) {
		this.raio = raio;
	}

	@Override
	public double area() {
		return Math.PI * raio * raio;
	}

}
