package org.lab3.wed.weblab3;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class AreaCheckBean implements Serializable {

    @Inject
    FormDataXBean xBean;
    @Inject
    FormDataYBean yBean;
    @Inject
    FormDataRBean rBean;

    public void checkHit(){
        final double X = Double.parseDouble(xBean.getX());
        final double Y = Double.parseDouble(yBean.getY());
        final double R = Double.parseDouble(rBean.getR());
        final boolean hit = (X <= R && Y <= R && X >= 0 &&  Y >= 0) ||
                (Math.pow(X, 2) + Math.pow(Y, 2) <= Math.pow(R, 2) && X <= 0 && Y <= 0) ||
                (Math.abs(Y) + Math.abs(X) * 2 <= R && X <= 0 && Y >= 0);

        System.out.println(hit);
    }
}
