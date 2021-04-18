/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package circle;

/**
 *
 * @author ROG
 */
public class Circle {

    //class Circle {
        //The radius of this cirlce
        double radius = 1.0;
        
        //Construct a circle object
        Circle() {
        }
        
        //Construct a circle object
        Circle(double newRadius) {
            radius = newRadius;
        }
        
        //Return the area of this circle
        double getArea() {
            return radius * radius * 3.14159;
        }
    }

