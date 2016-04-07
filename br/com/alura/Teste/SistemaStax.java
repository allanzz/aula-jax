package br.com.alura.Teste;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.*;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.XMLEvent;

import br.com.alura.Modelo.Produto;

public class SistemaStax {
	public static void main(String[] args) throws Exception {
		InputStream ips = new FileInputStream("src/vendas.xml");
		XMLInputFactory xmlFabrica = XMLInputFactory.newFactory();
		XMLEventReader eventos = xmlFabrica.createXMLEventReader(ips);
		List<Produto> listaProduto = new ArrayList<>();
		while(eventos.hasNext())
		{
			XMLEvent evento = eventos.nextEvent();
			if(evento.isStartElement()&&evento.asStartElement().getName().getLocalPart().equals("produto"))
			{
				Produto prod = ProcessaProduto(eventos);
				//System.out.println("Produto: "+prod);
				listaProduto.add(prod);
			}
		}
		System.out.println(listaProduto);
	}

	private static Produto ProcessaProduto(XMLEventReader eventos) throws XMLStreamException {
		Produto prod = new Produto();
		while(eventos.hasNext())
		{
			XMLEvent evento = eventos.nextEvent();
			if(evento.isEndElement()&&evento.asEndElement().getName().getLocalPart().equals("produto"))
			{
				break;
			}
			else if(evento.isStartElement()&&evento.asStartElement().getName().getLocalPart().equals("nome"))
			{
				evento=eventos.nextEvent();
				String nome = evento.asCharacters().getData();
				prod.setNome(nome);
			}else if(evento.isStartElement()&&evento.asStartElement().getName().getLocalPart().equals("preço"))
			{
				evento = eventos.nextEvent();
				Double preco =Double.parseDouble(evento.asCharacters().getData());
				prod.setPreco(preco);
			}
		}
		return prod;
	}

}
