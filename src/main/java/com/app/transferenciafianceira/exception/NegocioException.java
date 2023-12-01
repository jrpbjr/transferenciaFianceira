package com.app.transferenciafianceira.exception;

public class NegocioException extends Exception{
    private static final long serialVersionUID = 4675002567460179137L;
    private Object[] parametros;

    public NegocioException(String message) {
        super(message);
    }
    public NegocioException(final String pMessage, final Throwable pThrowable){
        super(pMessage, pThrowable);
    }
    public NegocioException(final String pMessage, final Throwable pThrowable, final Object[] params){
        super(pMessage,pThrowable);
        this.parametros = params;
    }
    public void setParametros(final Object[] parametros){
        this.parametros = parametros;
    }

}

