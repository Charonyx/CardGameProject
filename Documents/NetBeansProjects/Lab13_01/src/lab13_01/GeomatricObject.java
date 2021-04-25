
package lab13_01;

public abstract class GeomatricObject implements Cloneable{

    public GeomatricObject() {
    }
    public abstract double getArea();
    public abstract double getPerimeter();
    public String color;
    public boolean isFilled;
    public double weight;
    
    public boolean isIsFilled() {
        return isFilled;
    }

    public void setIsFilled(boolean isFilled) {
        this.isFilled = isFilled;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
    
    @Override
     public Object clone()throws CloneNotSupportedException{
        return super.clone();
    }

    public boolean equals(GeomatricObject a)
    {
        return this.getArea() == a.getArea();
    }
  
}
