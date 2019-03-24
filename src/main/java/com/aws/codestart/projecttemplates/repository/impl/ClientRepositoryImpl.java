package com.aws.codestart.projecttemplates.repository.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Repository;

import com.aws.codestart.projecttemplates.controller.response.KpiClient;
import com.aws.codestart.projecttemplates.domain.Client;
import com.aws.codestart.projecttemplates.repository.ClientRepository;

@Repository
public class ClientRepositoryImpl implements ClientRepository {
	
private static final AtomicLong counter = new AtomicLong();
	
	private static List<Client> clients;
	
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
	public List<Client> findAll() {
		return clients;
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

}
