package br.com.caelum.livraria.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;

import br.com.caelum.livraria.dao.DAO;
import br.com.caelum.livraria.modelo.Livro;
import br.com.caelum.livraria.modelo.Venda;

@Named
@ViewScoped
public class VendaBean implements Serializable{

	private static final long serialVersionUID = 1L;


	public BarChartModel getVendasModel() {
		BarChartModel model = new BarChartModel();
		model.setAnimate(true);
        ChartSeries vendaSerie = new ChartSeries();
        vendaSerie.setLabel("Vendas 2021");
        
        List<Venda> vendas = getVendas(1234);
        for (Venda venda : vendas) {
			vendaSerie.set(venda.getLivro().getTitulo(), venda.getQuantidade());
		}
        
        ChartSeries vendaSerie2020 = new ChartSeries();
        vendaSerie.setLabel("Vendas 2020");
        
        vendas = getVendas(5431);
        for (Venda venda : vendas) {
			vendaSerie.set(venda.getLivro().getTitulo(), venda.getQuantidade());
		}
        
        model.addSeries(vendaSerie);
        model.addSeries(vendaSerie2020);
        
        return model;
	}
	
	
	public List<Venda> getVendas(long seed){
		List<Livro> livros = new DAO<Livro>(Livro.class).listaTodos();
		List<Venda> vendas = new ArrayList<Venda>();
		Random random = new Random(seed);
		
		for(Livro livro : livros) {
			Integer quantidade = random.nextInt(500);
			vendas.add(new Venda(livro, quantidade));
		}
		
		return vendas;
	}
	
}
