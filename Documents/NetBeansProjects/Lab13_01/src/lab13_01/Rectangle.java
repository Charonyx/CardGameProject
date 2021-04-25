
package lab13_01;

/**
 *
 * @author ROG
 */
public class Rectangle extends GeomatricObject{
    double a;

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }
    double b;
    
    public Rectangle() {
    }
    
    public Rectangle(double b) {
        this.b = b;
    }
    
    public Rectangle(double a,double b,
		String color, double weight) {
		this.a = a;
                this.b = b;
		setColor(color);
		setWeight(weight);
	}

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setWeight(double weight) {
        super.setWeight(weight); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double getWeight() {
        return super.getWeight(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setColor(String color) {
        super.setColor(color); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getColor() {
        return super.getColor(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setIsFilled(boolean isFilled) {
        super.setIsFilled(isFilled); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isIsFilled() {
        return super.isIsFilled(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public double getArea() {
        return b*b;
    }

    @Override
    public double getPerimeter() {
        return b*4;
    }
    
    public int compareTo(Rectangle a) {
        if (this.getArea() > a.getArea()) {
            return 1;
        } else if (this.getArea() < a.getArea()) {
            return -1;
        } else {
            return 0;
        }
    }
}
