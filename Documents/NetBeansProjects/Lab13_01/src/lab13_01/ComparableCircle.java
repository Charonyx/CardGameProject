
package lab13_01;

public class ComparableCircle extends Circle implements Comparable<Circle> {
    String name;
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public ComparableCircle() {
    }
    
    public ComparableCircle(double a) {
        super(a);
    }

    public ComparableCircle(double a, String color, double weight) {
        super(a, color, weight);
    }

    @Override
    public int compareTo(Circle a) {
        if (this.getArea() > a.getArea()) {
            return 1;
        } else if (this.getArea() < a.getArea()) {
            return -1;
        } else {
            return 0;
        }
    }
    
    public int Max(ComparableCircle a, ComparableCircle b){
        if(a.getA()> b.getA())
        {
            return 1;
        } else if(a.getA() < b.getA())
        {
            return 2;
        } 
        else return 0;
    }


    
}
