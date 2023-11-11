package org.lab3.wed.weblab3.Model;

public class CheckHit {
    public static boolean checkHit(double X, double Y, double R){
        return (X <= R && Y <= R && X >= 0 &&  Y >= 0) ||
                (Math.pow(X, 2) + Math.pow(Y, 2) <= Math.pow(R, 2) && X <= 0 && Y <= 0) ||
                (Math.abs(Y) + Math.abs(X) * 2 <= R && X <= 0 && Y >= 0);
    }
}
