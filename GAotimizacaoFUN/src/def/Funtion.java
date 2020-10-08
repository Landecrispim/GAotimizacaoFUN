package def;



public class Funtion {

	
	//Primeira equação
	public double calcula_1(double x, double y) {
		double a, b;
		a = Math.sin(x);
		b = Math.cos(x * Math.sqrt(3));
		return a + b;
	}
//Segunda equação
	public double calcula_2(double x, double y) {
		double a, b, c, d, e;
		a = (-1) * (y + 47);
		b = (x / 2) + (y + 47);
		if (b < 0)
			b = b * (-1);
		c = a * Math.sin(b);
		d = x - (y + 47);
		if (d < 0)
			d = d * (-1);
		e = x * Math.sin(Math.sqrt(d));
		return c - e;
	}


}
