package com.aws.codestart.projecttemplates.repository.impl;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Repository;

import com.aws.codestart.projecttemplates.controller.response.ClientResponse;
import com.aws.codestart.projecttemplates.controller.response.KpiClient;
import com.aws.codestart.projecttemplates.domain.Client;
import com.aws.codestart.projecttemplates.repository.ClientRepository;

@Repository
public class ClientRepositoryImpl implements ClientRepository {
	
private static final AtomicLong counter = new AtomicLong();
	
	private static List<Client> clients;
	private static int ageDeath = 74;
	
	static{
		clients= populateDummyClients();
	}

	public List<Client> findAllClients() {
		return clients;
	}
	
	@Override
	public void create(Client client) {
		client.setId(counter.incrementAndGet());
		clients.add(client);
	}

	@Override
	public KpiClient findKpi() {
		KpiClient kpiClient= new  KpiClient();
		kpiClient.setOldAverage(promedio(clients));
		kpiClient.setOldDesviation(desviacion(clients));
		return kpiClient;
	}

	@Override
	public List<ClientResponse> findAll() {
		List<ClientResponse> clientsReponse = new ArrayList<ClientResponse>();
		ClientResponse clientReponse;
		for (int i = 0; i < clients.size(); i++) {
			clientReponse = new ClientResponse();
			clientReponse.setFirstName(clients.get(i).getFirstName());
			clientReponse.setLastName(clients.get(i).getFirstName());
			clientReponse.setBirthDay(clients.get(i).getBirthDay());
			clientReponse.setAge(clients.get(i).getAge());
			if (clients.get(i).getBirthDay() == null || clients.get(i).getBirthDay().length()<1) {
				clientReponse.setBirthDay("");
				clientReponse.setDeathDay("");
			}
			else {
				clientReponse.setBirthDay(clients.get(i).getBirthDay());
				clientReponse.setDeathDay(calcularDeathDay(clients.get(i).getBirthDay()));
			}
			clientsReponse.add(clientReponse);
		}
		return clientsReponse;
	}
	
	private static List<Client> populateDummyClients(){
		List<Client> clients = new ArrayList<Client>();
		clients.add(new Client(counter.incrementAndGet(),"Axel Cristhofer", "Gonzales Llerena","1997-09-27",21));
		clients.add(new Client(counter.incrementAndGet(),"Joyce Kathery", "Gonzales Llerena","2000-09-27",18));
		clients.add(new Client(counter.incrementAndGet(),"Sofhie Luciana", "Gonzales Llerena","2007-09-27",11));
		clients.add(new Client(counter.incrementAndGet(),"Axel Cristhofer", "Gonzales Llerena","1996-09-27",22));
		return clients;
	}
	
	public static double desviacion ( List<Client> clients) {
	    double prom, sum = 0; int i, n = clients.size();
	    prom = promedio (clients);

	    for ( i = 0; i < n; i++ ) 
	      sum += Math.pow ( clients.get(i).getAge()- prom, 2 );

	    return Math.sqrt ( sum / ( double ) n );
	  }
	  
	public static double promedio ( List<Client> clients) {
	    double prom = 0.0;
	    for ( int i = 0; i < clients.size(); i++ )
	      prom += clients.get(i).getAge();

	    return prom / ( double ) clients.size();  
	  }
	
	public String calcularDeathDay(String birthDay) {
		String deathDay = "";
		int yearLife = ageDeath - calcularEdad(birthDay);
		int yearDeath = yearLife + Integer.parseInt(birthDay.substring(0,4));
		deathDay = yearDeath + birthDay.substring(4);
		return deathDay;
	}
	public int calcularEdad(String birthDay) {
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate fechaNac = LocalDate.parse(birthDay, fmt);
		LocalDate ahora = LocalDate.now();
		Period periodo = Period.between(fechaNac, ahora);
		return periodo.getYears();
	}
	

}
