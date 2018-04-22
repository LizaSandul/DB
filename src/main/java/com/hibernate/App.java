package com.hibernate;

import java.util.List;

import com.hibernate.model.Book;
import com.hibernate.model.Card;
import com.hibernate.model.Client;
import com.hibernate.service.CardService;
import com.hibernate.service.ClientService;

public class App {

	public static void main(String[] args) {
		CardService cardService = new CardService();
		ClientService clService = new ClientService();

		List<Client> clients = clService.findAll();
		System.out.println("Clients Persisted are :");
		for (Client c : clients) {
			System.out.println("-" + c.toString());
		}

		String name="Masha";

		List<Object[]> booksActual = cardService.findClientsBooksActualDate(name);
		System.out.println("Books  "+name+" has:");
		for (Object[] c : booksActual) {
			Book book1 = (Book) c[1];
			Card card1 = (Card) c[0];
			Client client1 = (Client) c[2];
			System.out.println("-client: "+client1.getName()+" title: "+book1.getTitle()+" author: "+book1.getAuthor()+" date: "+card1.getDate());
		}
		System.exit(0);
	}
}
