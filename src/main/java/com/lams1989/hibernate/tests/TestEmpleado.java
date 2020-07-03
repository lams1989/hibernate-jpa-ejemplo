package com.lams1989.hibernate.tests;

import java.time.LocalDate;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import com.lams1989.hibernate.modelo.Empleado;

public class TestEmpleado {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistencia");

	public static void main(String[] args) {
		EntityManager man = emf.createEntityManager();
		Empleado e = new Empleado(10L, "Perez", "Pepito",  LocalDate.of(1989, 8, 10));
		man.getTransaction().begin();
		man.persist(e);
		man.getTransaction().commit();
		man.close();
		imprimirTodo();
	}

	private static void insertInicial() {
		EntityManager man = emf.createEntityManager();
		Empleado e = new Empleado(10L, "Perez", "Pepito",  LocalDate.of(1989, 8, 10));
		man.getTransaction().begin();
		man.persist(e);
		man.getTransaction().commit();
		man.close();
	}

	@SuppressWarnings("unchecked")
	private static void imprimirTodo() {
		EntityManager man = emf.createEntityManager();
		List<Empleado> emps = man.createQuery("FROM Empleado").getResultList();
		System.out.println("Hay " + emps.size() + "empleados en el sistema");
		for (Empleado emp : emps) {
			System.out.println(emp.toString());
			man.close();
		}
	}

}
