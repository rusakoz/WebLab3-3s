package org.lab3.wed.weblab3;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.inject.Named;
import java.io.Serializable;

@Named
@Getter
@Setter
@EqualsAndHashCode
@ToString
@SessionScoped
public class FormDataBean implements Serializable {
    private double x;
    private String y;
    private String r;

    public void validateSelectR(FacesContext facesContext, UIComponent uiComponent, Object o) {
        if (o == null || o.equals("") && !(Double.parseDouble(o.toString()) >= 0.1 && Double.parseDouble(o.toString()) <= 3)) {
            FacesMessage message = new FacesMessage("Не верно значение R!");
            throw new ValidatorException(message);
        }
    }
    public void validateSelectY(FacesContext facesContext, UIComponent uiComponent, Object o) {
        if (o == null || o.equals("") && !(Double.parseDouble(o.toString()) >= -3 && Double.parseDouble(o.toString()) <= 5)) {
            FacesMessage message = new FacesMessage("Не верно значение Y!");
            throw new ValidatorException(message);
        }
    }
    public void validateSelectX(FacesContext facesContext, UIComponent uiComponent, Object o) {
        if (o == null || o.equals("") || !(Double.parseDouble(o.toString()) >= -2 && Double.parseDouble(o.toString()) <= 2)) {
            FacesMessage message = new FacesMessage("Не верно значение X!");
            throw new ValidatorException(message);
        }
    }
}
