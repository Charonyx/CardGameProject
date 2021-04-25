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
public class ComparableTriangle extends Triangle implements Comparable<Triangle> {
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ComparableTriangle() {
    }
    
    public ComparableTriangle(double a,double b,double c,String color, double weight) {
        super(a,b,c,color,weight);
    }
    
    @Override
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