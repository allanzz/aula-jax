package br.com.alura.Teste;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import br.com.alura.Modelo.Produto;

public class Sistema {

	public static void main(String[] args) throws Exception {
		DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();
		fabrica.setValidating(true);
		fabrica.setNamespaceAware(true);
		fabrica.setAttribute("http://java.sun.com/xml/jaxp/properties/schemaLanguage", "http://www.w3.org/2001/XMLSchema");
		DocumentBuilder builder = fabrica.newDocumentBuilder();
		Document document=builder.parse("src/vendas.xml");
		Element venda = document.getDocumentElement();
		String moeda = venda.getAttribute("moeda");
		String caminho = "vendas/produtos/produto[2]";
		XPathFactory fPath = XPathFactory.newInstance();
		XPath path = fPath.newXPath();
		XPathExpression expressao = path.compile(caminho);
		//NodeList produtos = document.getElementsByTagName("produto");
		NodeList produtos =(NodeList)expressao.evaluate(document, XPathConstants.NODESET);
		for(int i=0;i<produtos.getLength();i++)
		{
			Element produto = (Element)produtos.item(i);
			String nome = produto.getElementsByTagName("nome").item(0).getTextContent();
			Double preco = Double.parseDouble(produto.getElementsByTagName("preço").item(0).getTextContent());
		    Produto prod = new Produto(nome,preco);
		    System.out.println(prod);
		}
		

	}

}
