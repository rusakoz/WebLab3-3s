package org.lab3.wed.weblab3;

import lombok.Getter;
import lombok.Setter;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named
@Getter
@Setter
@SessionScoped
public class AreaCheckBean implements Serializable {
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
