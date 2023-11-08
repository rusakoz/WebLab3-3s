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
public class FormDataYBean implements Serializable {
    private String y;

    public void validateSelectY(FacesContext facesContext,
                                UIComponent uiComponent, Object o) {

        if (o == null) {
            FacesMessage message = new FacesMessage("Выберите число!");
            throw new ValidatorException(message);
        }
    }
}
