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
public class FormDataXBean implements Serializable {
    private String x;

    public void validateSelectX(FacesContext facesContext,
                                UIComponent uiComponent, Object o) {

        if (o.equals("")) {
            FacesMessage message = new FacesMessage("Введите число!");
            throw new ValidatorException(message);
        }
    }
}
