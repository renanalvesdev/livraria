package br.com.caelum.livraria.tx;

import java.io.Serializable;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;


@Transacional
@Interceptor
public class GerenciadorDeTransacoes implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	EntityManager em;
	
	@AroundInvoke
	public Object executaTX(InvocationContext contexto) throws Exception {
		// abre transacao
		em.getTransaction().begin();

		//chamar os daos que precisam de um TX
		Object resultado = contexto.proceed();
		
		// commita a transacao
		em.getTransaction().commit();
		
		return resultado;
	}
	
}
