package br.com.agenda.aplicação;

import java.util.Date;
import br.com.agenda.model.Agenda;
import br.com.agenda.dao.AgendaDAO;

public class Main {
	public static void main(String[] args) {
		//Salvando elementos no BD
		Agenda contato = new Agenda();
		AgendaDAO contatoDAO = new AgendaDAO();
		contato.setNome("Letícia Rayanne Alves Carvalho Marinho");
		contato.setIdade(29);
		contato.setDataCadastro(new Date());
		
		//contatoDAO.save(contato);
		
		//Visualização dos dados
		for(Agenda c: contatoDAO.getContatos()) {
			System.out.println("Contato: " + c.getNome());
		}
		
		//Atualizando os dados do BD
		Agenda c1 = new Agenda();
		c1.setNome("Maria Gabriela Dias Orlando");
		c1.setIdade(37);
		c1.setDataCadastro(new Date());
		c1.setId(1);
		contatoDAO.update(c1);
		
		//Deletando elementos pelo ID
		contatoDAO.delete(4);
		contatoDAO.delete(5);
	} 

}
