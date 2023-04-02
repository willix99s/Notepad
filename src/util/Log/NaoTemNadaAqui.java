package util.Log;

/**
 * <h1>NaoTemNadaAqui</h1> é uma classe {@code NaoTemNadaAqui} exclusivamente para ser uma exception
 * que seja ocasionada ao tentar acessar um elemnto que seja nulo ou inexistente.
 */
public class NaoTemNadaAqui extends RuntimeException {
    public NaoTemNadaAqui(String msg){
        super(msg);
    }
}
