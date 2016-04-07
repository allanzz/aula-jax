package br.com.alura.Teste;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import java.io.*;

import br.com.alura.Handler.LeXMLcomSAX;

public class SistemaSAX {

	public static void main(String[] args) throws SAXException, IOException {
		XMLReader leitor = XMLReaderFactory.createXMLReader();
		LeXMLcomSAX logica = new LeXMLcomSAX();
		leitor.setContentHandler(logica);
		InputStream ips = new FileInputStream("src/vendas.xml");
		InputSource source = new InputSource(ips);
		leitor.parse(source);
		System.out.println(logica.getProdutos());
	}

}
