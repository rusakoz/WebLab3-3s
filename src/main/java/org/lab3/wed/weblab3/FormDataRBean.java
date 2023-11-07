package org.lab3.wed.weblab3;

import lombok.Getter;
import lombok.Setter;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@Getter
@Setter
@SessionScoped
public class FormDataRBean implements Serializable {
    private String r;
}
