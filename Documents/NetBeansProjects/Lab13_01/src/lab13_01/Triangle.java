
package lab13_01;

public class Triangle extends GeomatricObject{
    double a,b,c;
    

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

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    public double getS() {
        return s;
    }

    public void setS(double s) {
        this.s = s;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isIsFilled() {
        return isFilled;
    }

    public void setIsFilled(boolean isFilled) {
        this.isFilled = isFilled;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Triangle(double a, double b, double c, double s) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.s = s;
    }
    double s;
    
    public Triangle() {
    }
    public Triangle(double a, double b, double c,String color,double weight)
    {
        this.a=a;
        this.b=b;
        this.c=c;
        setColor(color);
	setWeight(weight);
    }
    public Triangle(double a, double b, double c)
    {
        this.a = a;
        this.b = b;
        this.c = c;
        
    }


    @Override
    public double getArea() {
        s = (this.a+this.b+this.c)/2;
        return Math.sqrt(s*(s-a)*(s-b)*(s-c));
    }

    @Override
    public double getPerimeter() {
        return a+b+c;
    }
    
    public int compareTo(Triangle a) {
        if (this.getArea() > a.getArea()) {
            return 1;
        } else if (this.getArea() < a.getArea()) {
            return -1;
        } else {
            return 0;
        }
    }
}
