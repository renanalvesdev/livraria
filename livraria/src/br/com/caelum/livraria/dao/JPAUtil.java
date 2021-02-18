package br.com.caelum.livraria.dao;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private static EntityManagerFactory emf = Persistence
			.createEntityManagerFactory("livraria");

	
	@Produces
	@RequestScoped
	//É um método produtor, ou seja o CDI vai chamar sempre que precisar gerar um entity manager
	//para isso precisa indicar explicitamente
	//no nosso caso, tem que se criar um para cada requisicao
	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

	
	//a anotação @Disposes vai fechar o entity manager somente no final da requisição
	//isso faz com que numa inserção seguida de listagem, por exemplo, a conexao mantenha-se
	//aberta, visto que a requisição nao foi finalizada
	public void close(@Disposes EntityManager em) {
		em.close();
	}
}
