package org.lab3.wed.weblab3;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.enterprise.context.ApplicationScoped;
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
    //private String str = "das";
    @Inject
    FormDataXBean xBean;
    @Inject
    FormDataYBean yBean;
    @Inject
    FormDataRBean rBean;

    public void doLog(){

        System.out.println(xBean.getX() + " " + yBean.getY());
    }
}
