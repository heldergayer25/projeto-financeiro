package br.com.financeiro.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class Mensagens {

	public static void info(String mensagem) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso!", mensagem));
    }
     
    public static void warn(String mensagem) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Atenção!", mensagem));
    }
     
    public static void error(String mensagem) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", mensagem));
    }
     
    public static void fatal(String mensagem) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Fatal!", mensagem));
    }
	
}
