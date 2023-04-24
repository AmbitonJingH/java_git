/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrator
 */
public class LinearEquation {

    private double a;
    private double b;
    private double c;
    private double d;
    private double e;
    private double f;
    public LinearEquation(double a,double b,double c,double d,double e,double f){
        this.a=a;
        this.b=b;
        this.c=c;
        this.d=d;
        this.e=e;
        this.f=f;
    }
    public double Geta(){
        return this.a;
    }
    public double Getb(){
        return this.b;
    }
    public double Getc(){
        return this.c;
    }
    public double Getd(){
        return this.d;
    }
    public double Gete(){
        return this.e;
    }
    public double Getf(){
        return this.f;
    }
    public boolean isSolvable(){
        if((a*d-b*c)!=0)
            return true;
        else
            return false;
    }
    public double getX(){
        double x =((e*d)-(b*f))/((a*d)-(b*c));
        return x;
    }
    public double getY(){
        double y =((a*f)-(e*c))/((a*d)-(b*c));
        return y;
    }
}