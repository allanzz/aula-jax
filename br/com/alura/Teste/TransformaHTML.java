package br.com.alura.Teste;

import java.io.FileInputStream;
import java.io.InputStream;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class TransformaHTML {

	public static void main(String[] args) throws Exception {
		InputStream str = new FileInputStream("src/vendas.xml");
		StreamSource srcXML = new StreamSource(str);
		InputStream strXSL =new FileInputStream("src/XMLparaHTML.xsl");
		StreamSource srcXSL = new StreamSource(strXSL);
		Transformer transform = TransformerFactory.newInstance().newTransformer(srcXSL);
		StreamResult resultado = new StreamResult("src/resultado.html");
		transform.transform(srcXML, resultado);
		System.out.println("ok");

	}

}
