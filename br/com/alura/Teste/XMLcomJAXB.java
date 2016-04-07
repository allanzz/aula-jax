package br.com.alura.Teste;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import br.com.alura.Modelo.Vendas;

public class XMLcomJAXB {

	public static void main(String[] args) throws Exception {
		JAXBContext context= JAXBContext.newInstance(Vendas.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		Vendas venda =(Vendas) unmarshaller.unmarshal(new File("src/vendas.xml"));
		System.out.println(venda);

	}

}
