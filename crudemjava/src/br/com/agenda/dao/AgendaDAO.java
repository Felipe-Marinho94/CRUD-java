package br.com.agenda.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.*;
import br.com.agenda.factory.ConnectionFactory;
import br.com.agenda.model.Agenda;

public class AgendaDAO {
	
	/*CRUD
	 * CREATE
	 * READ
	 * UPDATE
	 * DELETE
	 * */
	
	public void save(Agenda contato) {

		String sql = "INSERT INTO contatos(nome, idade, datacadastro) VALUE(?, ?, ?)";
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			//Criando uma conexão com banco de dados
			conn = ConnectionFactory.createConnectionToMySQL();
			
			//Criamos uma PreparedStatement(sql)
			pstm = conn.prepareStatement(sql);
			
			//Recebendo os parâmetros
			pstm.setString(1, contato.getNome());
			pstm.setInt(2, contato.getIdade());
			pstm.setDate(3, new Date (contato.getDataCadastro().getTime()));
			
			//Executar a query
			pstm.execute();
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				//fechar as conexões
				try {
					if(pstm != null) {
						pstm.close();
					}
					
					if(conn != null) {}
					pstm.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		
	}

	public List<Agenda> getContatos(){
		String sql = "SELECT * FROM contatos";
		List<Agenda> contatos = new ArrayList<Agenda>();
		Connection conn = null;
		PreparedStatement pstm = null;
		
		//Classe que vai recuperar os dados do banco. ***SELECT***
		ResultSet rset = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();
			
			while(rset.next()) {
				Agenda contato = new Agenda();
				
				//Recuperar o ID
				contato.setId(rset.getInt("id"));
				
				//Recuperar o nome
				contato.setNome(rset.getString("nome"));
				
				//Recuperar a idade
				contato.setIdade(rset.getInt("idade"));
				
				//Recuperar a data de cadastro
				contato.setDataCadastro(rset.getDate("datacadastro"));
				
				//Adcionando os elementos
				contatos.add(contato);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
			if(rset != null) {
				rset.close();
			}
			if(pstm != null) {
				pstm.close();
			}
			if(conn != null) {
				conn.close();
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return contatos;
	}
	
	
}
	
	public void update(Agenda contato) {
		String sql = "UPDATE contatos SET nome = ?, idade = ?, datacadastro = ? WHERE id = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			//Criar conexão com o banco
			conn = ConnectionFactory.createConnectionToMySQL();
			
			//Criar classe para executar query
			pstm = conn.prepareStatement(sql);
			
			//Adicionar os valores para atualizar
			pstm.setString(1, contato.getNome());
			pstm.setInt(2, contato.getIdade());
			pstm.setDate(3, new Date(contato.getDataCadastro().getTime()));
			pstm.setInt(4, contato.getId());
			
			//Executar a query
			pstm.execute();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn != null) {
					conn.close();
				}
				if(pstm != null) {
					pstm.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		
	}

	public void delete(int id) {
		String sql = "DELETE FROM contatos WHERE id = ?";
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			//Criando a conexão
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			
			//Recebendo os parâmetros
			pstm.setInt(1, id);
			
			//Execução
			pstm.execute();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn != null) {
					conn.close();
				}
				if(pstm != null) {
					pstm.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		
	}
}

