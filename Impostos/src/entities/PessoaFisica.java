package entities;

public class PessoaFisica extends Contribuinte {
	
	private double gastosSaude;

	public PessoaFisica(String nome, Double rendaAnual, double gastosSaude) {
		super(nome, rendaAnual);
		this.gastosSaude = gastosSaude;
	}

	public double getGastosSaude() {
		return gastosSaude;
	}

	public void setGastosSaude(double gastosSaude) {
		this.gastosSaude = gastosSaude;
	}
	
	@Override
	public double imposto() {
		
		double impostoBasico;
		
		if (getRendaAnual() < 20000.0) {
			impostoBasico = getRendaAnual() * 0.15;
		}
		else {
			impostoBasico = getRendaAnual() * 0.25;
		}
		
		impostoBasico -= getGastosSaude() * 0.5;
		if (impostoBasico < 0.0) {
			impostoBasico = 0.0;
		}
		
		return impostoBasico;
	}
	
	

}
