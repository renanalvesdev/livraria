package br.com.caelum.livraria.tx;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.interceptor.InterceptorBinding;

//anotacao ligaca a um interceptador
@InterceptorBinding
//onde pode ser usada
@Target({ElementType.METHOD, ElementType.TYPE})
//em tempo de compilação ou em tempo de execução
@Retention(RetentionPolicy.RUNTIME)
public @interface Transacional {

}
