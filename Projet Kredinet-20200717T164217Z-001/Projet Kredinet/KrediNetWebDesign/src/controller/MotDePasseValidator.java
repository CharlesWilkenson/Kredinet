package controller;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator( value = "MotDePasseValidator" )
public class MotDePasseValidator implements Validator {

    private static final String MOTS_DE_PASSE = "Le mot de passe contenir une chaîne de 8 à 20 caractères avec au moins un chiffre, une lettre majuscule, une lettre minuscule et un symbole spécial";
    
    @Override
    public void validate( FacesContext context, UIComponent component, Object value ) throws ValidatorException {
    	/* Récupération de la valeur à traiter depuis le paramètre value */
        String password = (String) value;
        if (Utility.validate(password)){
	       
	                throw new ValidatorException(
	                        new FacesMessage( FacesMessage.SEVERITY_ERROR, MOTS_DE_PASSE, null ) );
	   }
	        
	         
	        }
    
}
