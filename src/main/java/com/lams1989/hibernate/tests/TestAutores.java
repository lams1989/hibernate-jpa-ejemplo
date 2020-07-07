package com.lams1989.hibernate.tests;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.lams1989.hibernate.modelo.Autor;
import com.lams1989.hibernate.modelo.Libro;

public class TestAutores {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistencia");

	public static void main(String[] args) {
		CrearDatos();
		imprimirDatos();
	}

	static void CrearDatos() {

		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Autor autor1 = new Autor(1L, "Pablo Perez", "Españoña" );
		Autor autor2 =new Autor (2L, "Elena Gomez", "Mexicana");
		Autor autor3 = new Autor (3L, "Miguel Lopez", "Chilena");
		em.persist(autor1);
		em.persist(autor2);
		em.persist(autor3);
		
		em.persist(new Libro(1L, "programar en java es facil", autor2));
		em.persist(new Libro(2L, "como vestirse con estilo", autor3));
		em.persist(new Libro(3L, "como cocinar sin quemar la cocina",autor1));
		em.persist(new Libro(4L, "programar en cobol es divertido", autor2));
		em.persist(new Libro(5L, "programar en cobol no es divertido", autor2));
		
		em.getTransaction().commit();
		em.close();

	}
	
	static void imprimirDatos() {
		EntityManager em = emf.createEntityManager();
		
		Autor autor2 = em.find(Autor.class, 2L);
		List<Libro> libros = autor2.getLibros();
		for (Libro libro : libros)
			System.out.println("*" + libro.toString());
		
		em.close();
	}
}
