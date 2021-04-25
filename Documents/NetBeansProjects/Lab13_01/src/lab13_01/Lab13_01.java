/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab13_01;

import java.util.Scanner;

/**
 *
 * @author ROG
 */
public class Lab13_01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws CloneNotSupportedException {
        double j, g, a, c, e, i;
        String r, u, o, t;
        boolean check;
        Scanner input = new Scanner(System.in);

        System.out.println("Menu(1=Circle, 2=Rectangle,3=Triangle 4=Exit) : ");
        j = input.nextDouble();

        //circle
        if (j == 1) {
            Circle c1 = new Circle();
            Circle c2 = new Circle();
            Circle c3 = new Circle();
            ComparableCircle com1 = new ComparableCircle();
            ComparableCircle com2 = new ComparableCircle();
            ComparableCircle com3 = new ComparableCircle();

            System.out.println("Circle c1(radius color weight): ");
            g = input.nextDouble();
            r = input.next();
            a = input.nextDouble();
            c1.setA(g);
            c1.setColor(r);
            c1.setWeight(a);

            System.out.println("Circle c2(radius color weight): ");
            g = input.nextDouble();
            r = input.next();
            a = input.nextDouble();
            c2.setA(g);
            c2.setColor(r);
            c2.setWeight(a);

            System.out.println("3.1 Find the larger object using max method: ");

            u = input.next();
            com1.setName(u);
            o = input.next();
            com2.setName(o);

            //Compare
            if (com1.getA() > com2.getA()) {
                System.out.println("c1");
            } else {
                System.out.println("c2");
            }

            //Cloning
            System.out.println("Cloning Circle c3 by using : ");
            u = input.next();
            com1.setName(u);
            com2.setName(u);

            //c1
            if (u.contains("c1")) {
                System.out.printf("c1 == c3 : ");
                if (com3 != com1) {
                    System.out.println("False");
                } else {
                    System.out.println("True");
                }

                System.out.printf("c1.equals(c3) is : ");
                c3 = (Circle) c1.clone();
                if (c1.equals(c3)) {
                    System.out.println("True");
                } else {
                    System.out.println("False");
                }
            }

            //c2
            if (u.contains("c2")) {
                System.out.println("c2 == c3 : ");
                if (com3 != com2) {
                    System.out.println("False");
                } else {
                    System.out.println("True");
                }

                System.out.println("c2.equals(c3) is : ");
                c3 = (Circle) c2.clone();
                if (c2.equals(c3)) {
                    System.out.println("True");
                } else {
                    System.out.println("False");
                }
            }

            System.out.println("Find the larger of 2 instance of comparable objects: ");
            u = input.next();
            com1.setName(u);
            t = input.next();
            com2.setName(t);     

            if (u.contains("c1") && t.contains("c2")) {
                switch (c1.compareTo(c2)) {
                    case -1 -> {
                        System.out.println("c2");
                    }
                    case 1 -> {
                        System.out.println("c1");
                    }
                    default -> {
                        System.out.println("equal");
                    }
                }
            }

            if (u.contains("c1") && t.contains("c3")) {
                switch (c1.compareTo(c3)) {
                    case -1 -> {
                        System.out.println("c3");
                    }
                    case 1 -> {
                        System.out.println("c1");
                    }
                    default -> {
                        System.out.println("equal");
                    }
                }
            }
            if (u.contains("c2") && t.contains("c3")) {
                switch (c2.compareTo(c3)) {
                    case -1 -> {
                        System.out.println("c3");
                    }
                    case 1 -> {
                        System.out.println("c2");
                    }
                    default -> {
                        System.out.println("equal");
                    }
                }
            }

            //rectangle   
        } else if (j == 2) {
            Rectangle r1 = new Rectangle();
            Rectangle r2 = new Rectangle();
            Rectangle r3 = new Rectangle();
            ComparableCircle com1 = new ComparableCircle();
            ComparableCircle com2 = new ComparableCircle();
            ComparableCircle com3 = new ComparableCircle();

            System.out.println("Rectangle r1(width height color weight): ");
            g = input.nextDouble();
            c = input.nextDouble();
            r = input.next();
            a = input.nextDouble();
            r1.setA(g);
            r1.setB(c);
            r1.setColor(r);
            r1.setWeight(a);

            System.out.println("Rectangle r2(width height color weight): ");
            g = input.nextDouble();
            c = input.nextDouble();
            r = input.next();
            a = input.nextDouble();
            r2.setA(g);
            r2.setB(c);
            r2.setColor(r);
            r2.setWeight(a);

            System.out.println("3.1 Find the larger object using max method: ");

            u = input.next();
            com1.setName(u);
            o = input.next();
            com2.setName(o);

            //Compare
            if (com1.getArea() > com2.getArea()) {
                System.out.println("r1");
            } else {
                System.out.println("r2");
            }

            //Cloning
            System.out.println("Cloning Rectangle r3 by using : ");
            u = input.next();
            com1.setName(u);
            com2.setName(u);

            //r1
            if (u.contains("r1")) {
                System.out.printf("r1 == r3 : ");
                if (com3 != com1) {
                    System.out.println("False");
                } else {
                    System.out.println("True");
                }

                System.out.printf("r1.equals(r3) is : ");
                r3 = (Rectangle) r1.clone();
                if (r1.equals(r3)) {
                    System.out.println("True");
                } else {
                    System.out.println("False");
                }
            }

            //r2
            if (u.contains("r2")) {
                System.out.println("r2 == r3 : ");
                if (com3 != com2) {
                    System.out.println("False");
                } else {
                    System.out.println("True");
                }

                System.out.println("r2.equals(r3) is : ");
                r3 = (Rectangle) r2.clone();
                if (r2.equals(r3)) {
                    System.out.println("True");
                } else {
                    System.out.println("False");
                }
            }
            System.out.println("Find the larger of 2 instance of comparable objects: ");
            u = input.next();
            com1.setName(u);
            t = input.next();
            com2.setName(t);

            if (u.contains("r1") && t.contains("r2")) {
                switch (r1.compareTo(r2)) {
                    case -1 -> {
                        System.out.println("r2");
                    }
                    case 1 -> {
                        System.out.println("r1");
                    }
                    default -> {
                        System.out.println("equal");
                    }
                }
            }

            if (u.contains("r3") && t.contains("r1")) {
                switch (r1.compareTo(r3)) {
                    case -1 -> {
                        System.out.println("r1");
                    }
                    case 1 -> {
                        System.out.println("r3");
                    }
                    default -> {
                        System.out.println("equal");
                    }
                }
            }
            if (u.contains("r2") && t.contains("r3")) {
                switch (r2.compareTo(r3)) {
                    case -1 -> {
                        System.out.println("r3");
                    }
                    case 1 -> {
                        System.out.println("r2");
                    }
                    default -> {
                        System.out.println("equal");
                    }
                }
            }
        }
        
        //triangle
        else if(j==3)
        {
            Triangle t1 = new Triangle();
            Triangle t2 = new Triangle();
            Triangle t3 = new Triangle();
            ComparableCircle com1 = new ComparableCircle();
            ComparableCircle com2 = new ComparableCircle();
            ComparableCircle com3 = new ComparableCircle();

            System.out.println("Triangle t1(side side side color weight): ");
            g = input.nextDouble();
            e = input.nextDouble();
            i = input.nextDouble();
            r = input.next();
            a = input.nextDouble();
            t1.setA(g);
            t1.setB(e);
            t1.setC(i);
            t1.setColor(r);
            t1.setWeight(a);

            System.out.println("Triangle t2(side side color weight): ");
            g = input.nextDouble();
            e = input.nextDouble();
            i = input.nextDouble();
            r = input.next();
            a = input.nextDouble();
            t2.setA(g);
            t2.setB(e);
            t2.setC(i);
            t2.setColor(r);
            t2.setWeight(a);

            System.out.println("3.1 Find the larger object using max method: ");

            u = input.next();
            com1.setName(u);
            o = input.next();
            com2.setName(o);

            //Compare
            if (com1.getA() > com2.getA()) {
                System.out.println("t1");
            } else {
                System.out.println("t2");
            }

            //Cloning
            System.out.println("Cloning Triangle t3 by using : ");
            u = input.next();
            com1.setName(u);
            com2.setName(u);

            //c1
            if (u.contains("t1")) {
                System.out.printf("t1 == t3 : ");
                if (com3 != com1) {
                    System.out.println("False");
                } else {
                    System.out.println("True");
                }

                System.out.printf("t1.equals(t3) is : ");
                t3 = (Triangle) t1.clone();
                if (t1.equals(t3)) {
                    System.out.println("True");
                } else {
                    System.out.println("False");
                }
            }

            //c2
            if (u.contains("t2")) {
                System.out.println("t2 == t3 : ");
                if (com3 != com2) {
                    System.out.println("False");
                } else {
                    System.out.println("True");
                }

                System.out.println("t2.equals(t3) is : ");
                t3 = (Triangle) t2.clone();
                if (t2.equals(t3)) {
                    System.out.println("True");
                } else {
                    System.out.println("False");
                }
            }

            System.out.println("Find the larger of 2 instance of comparable objects: ");
            u = input.next();
            com1.setName(u);
            t = input.next();
            com2.setName(t);     
            
            
            if (u.contains("t1") && t.contains("t2")) {
                switch (t1.compareTo(t2)) {
                    case -1 -> {
                        System.out.println("t2");
                    }
                    case 1 -> {
                        System.out.println("t1");
                    }
                    default -> {
                        System.out.println("equal");
                    }
                }
            }

            if (u.contains("t1") && t.contains("t3")) {
                switch (t1.compareTo(t3)) {
                    case -1 -> {
                        System.out.println("t3");
                    }
                    case 1 -> {
                        System.out.println("t1");
                    }
                    default -> {
                        System.out.println("equal");
                    }
                }
            }
            if (u.contains("t2") && t.contains("t3")) {
                switch (t2.compareTo(t3)) {
                    case -1 -> {
                        System.out.println("t3");
                    }
                    case 1 -> {
                        System.out.println("t2");
                    }
                    default -> {
                        System.out.println("equal");
                    }
                }
            }

        }
    }
}
