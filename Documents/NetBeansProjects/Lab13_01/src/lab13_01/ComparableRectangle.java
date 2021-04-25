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
public class ComparableRectangle extends Rectangle implements Comparable<Rectangle> {
    String name;
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public ComparableRectangle(double a) {
        super(a);
    }
    
    public ComparableRectangle(double a,double b,
		String color, double weight) {
        super(a,b, color, weight);
    }
    
    @Override
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

