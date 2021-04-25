/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab13_01;

/**
 *
 * @author ROG
 */
public class Circle extends GeomatricObject{
    double a;
    public Circle() {
    }
    public Circle(double a) {
        this.a = a;
    }
    public Circle(double a, 
		String color, double weight) {
		this.a = a;
		setColor(color);
		setWeight(weight);
	}

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public void setWeight(double weight) {
        this.weight = weight;
    }
    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public void setColor(String color) {
        this.color = color;
    }


    @Override
    public double getArea() {
        return Math.PI*a*a;
    }

    @Override
    public double getPerimeter() {
         return 2*Math.PI*a;
    }
    
    
    public int compareTo(Circle a) {
        if (this.getArea() > a.getArea()) {
            return 1;
        } else if (this.getArea() < a.getArea()) {
            return -1;
        } else {
            return 0;
        }
    }
   
}
