package com.lams1989.hibernate.tests;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

import com.lams1989.hibernate.modelo.Empleado;

public class TestEmpleado {
	//@PersistenceContext(unitName = "Persistencia")
	// creamos el gestor de persistencia y ejb lo proporciona automaticamente
	// llamado en la xml persistence
	@PersistenceUnit(unitName = "Persistencia")
	private static EntityManager manager;

	private static EntityManagerFactory emf;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		List<Empleado> empleados = manager.createQuery("FROM Empleado").getResultList();
		System.out.println(empleados.size());
	}

}
