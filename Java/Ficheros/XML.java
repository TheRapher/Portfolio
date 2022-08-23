package UD1;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

public class Pract6 {

	public static void main(String[]args) {
		try {

			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document documento = builder.parse(new File("/home/2dam/Descargas/DAM_AD_UD01_P6_GOT_Ini.xml"));
			documento.getDocumentElement().normalize();
			System.out.println("---"+documento.getDocumentElement().getNodeName());

			NodeList got = documento.getElementsByTagName("character");

			
			for(int i = 0; i< got.getLength(); i++) {
				Node serie = got.item(i);

					if(serie.getNodeType() == Node.ELEMENT_NODE) {
						Element elemento = (Element) serie;
						System.out.println("-----"+serie.getNodeName());

						if(elemento.getElementsByTagName("id").getLength() > 0) {
						System.out.println("-------"+elemento.getElementsByTagName("id").item(0).getNodeName());
						System.out.println("--------->"+elemento.getElementsByTagName("id").item(0).getTextContent());
						}
						
						if(elemento.getElementsByTagName("name").getLength() > 0) {
						System.out.println("-------"+elemento.getElementsByTagName("name").item(0).getNodeName());
						System.out.println("--------->"+elemento.getElementsByTagName("name").item(0).getTextContent());
						}
						
						if(elemento.getElementsByTagName("gender").getLength() > 0) {
						System.out.println("-------"+elemento.getElementsByTagName("gender").item(0).getNodeName());
						System.out.println("--------->"+elemento.getElementsByTagName("gender").item(0).getTextContent());
						}
						
						if(elemento.getElementsByTagName("culture").getLength() > 0) {
						System.out.println("-------"+elemento.getElementsByTagName("culture").item(0).getNodeName());
						System.out.println("--------->"+elemento.getElementsByTagName("culture").item(0).getTextContent());
						}
						
						if(elemento.getElementsByTagName("born").getLength() > 0) {
						System.out.println("-------"+elemento.getElementsByTagName("born").item(0).getNodeName());
						System.out.println("--------->"+elemento.getElementsByTagName("born").item(0).getTextContent());
						}
						
						if(elemento.getElementsByTagName("died").getLength() > 0) {
						System.out.println("-------"+elemento.getElementsByTagName("died").item(0).getNodeName());
						System.out.println("--------->"+elemento.getElementsByTagName("died").item(0).getTextContent());
						}
						
						if(elemento.getElementsByTagName("alive").getLength() > 0) {
						System.out.println("-------"+elemento.getElementsByTagName("alive").item(0).getNodeName());
						System.out.println("--------->"+elemento.getElementsByTagName("alive").item(0).getTextContent());
						}
						
						if(elemento.getElementsByTagName("titles").getLength() > 0) {
						System.out.println("-----"+elemento.getElementsByTagName("titles").item(0).getNodeName());
						for(int j =0; j<elemento.getElementsByTagName("title").getLength(); j++) {

							System.out.println("-------"+elemento.getElementsByTagName("title").item(j).getNodeName());
							System.out.println("--------->"+elemento.getElementsByTagName("title").item(j).getTextContent());
						}
						}
						
						if(elemento.getElementsByTagName("aliases").getLength() > 0) {

							System.out.println("-----"+elemento.getElementsByTagName("aliases").item(0).getNodeName());

							for(int j =0; j<elemento.getElementsByTagName("alias").getLength(); j++) {

								System.out.println("-------"+elemento.getElementsByTagName("alias").item(j).getNodeName());

								System.out.println("--------->"+elemento.getElementsByTagName("alias").item(j).getTextContent());
							}
						}else {
							System.out.println("-------"+elemento.getElementsByTagName("rialiases").item(0).getNodeName());
							System.out.println("--------->"+elemento.getElementsByTagName("rialiases").item(0).getTextContent());
						}
						
						if(elemento.getElementsByTagName("father").getLength() > 0) {
						System.out.println("-------"+elemento.getElementsByTagName("father").item(0).getNodeName());
						System.out.println("--------->"+elemento.getElementsByTagName("father").item(0).getTextContent());
						}
						
						if(elemento.getElementsByTagName("mother").getLength() > 0) {
						System.out.println("-------"+elemento.getElementsByTagName("mother").item(0).getNodeName());
						System.out.println("--------->"+elemento.getElementsByTagName("mother").item(0).getTextContent());
						}
						
						if(elemento.getElementsByTagName("spouse").getLength() > 0) {
						System.out.println("-------"+elemento.getElementsByTagName("spouse").item(0).getNodeName());
						System.out.println("--------->"+elemento.getElementsByTagName("spouse").item(0).getTextContent());
						}
						
						if(elemento.getElementsByTagName("allegiances").getLength() > 0) {
						System.out.println("-----"+elemento.getElementsByTagName("allegiances").item(0).getNodeName());

						for(int j =0; j<elemento.getElementsByTagName("allegiance").getLength(); j++) {
							System.out.println("--------"+elemento.getElementsByTagName("allegiance").item(j).getNodeName());
							System.out.println("--------->"+elemento.getElementsByTagName("allegiance").item(j).getTextContent());
							}
						}
						
						if(elemento.getElementsByTagName("books").getLength() > 0) {
						System.out.println("-----"+elemento.getElementsByTagName("books").item(0).getNodeName());

						for(int j =0; j<elemento.getElementsByTagName("book").getLength(); j++) {

							System.out.println("-------"+elemento.getElementsByTagName("book").item(j).getNodeName());
							System.out.println("--------->"+elemento.getElementsByTagName("book").item(j).getTextContent());
						}
						}
						
						if(elemento.getElementsByTagName("tvSeries").getLength() > 0) {
						System.out.println("-----"+elemento.getElementsByTagName("tvSeries").item(0).getNodeName());
						}
						if(elemento.getElementsByTagName("season").getLength() > 0) {
						for(int j =0; j<elemento.getElementsByTagName("season").getLength(); j++) {

							System.out.println("-------"+elemento.getElementsByTagName("season").item(j).getNodeName());
							System.out.println("--------->"+elemento.getElementsByTagName("season").item(j).getTextContent());
						}
						System.out.println("**************************************************");
					}
					}
			}

			//Añadir al XML
			Element raiz = documento.createElement("character");
			documento.getDocumentElement().appendChild(raiz); 
			Element elem = documento.createElement("id"); 
			Text text = documento.createTextNode("583");
			raiz.appendChild(elem);
			elem.appendChild(text);
			
			Element elem2 = documento.createElement("name"); 
			Text text2 = documento.createTextNode("Jon Snow");
			raiz.appendChild(elem2);
			elem2.appendChild(text2);
			
			
			Element elem3 = documento.createElement("born"); 
			Text text3 = documento.createTextNode("In 283 AC, at Winterfell");
			raiz.appendChild(elem3);
			elem3.appendChild(text3);
			
			Element elem4 = documento.createElement("alive"); 
			Text text4 = documento.createTextNode("False");
			raiz.appendChild(elem4);
			elem4.appendChild(text4);
			
			Element elem5 = documento.createElement("titles"); 
			Element text5 = documento.createElement("title");
			Element text52 = documento.createElement("title");

			Text text5a = documento.createTextNode("Lord Commander of the Night's Watch");
			Text text5b = documento.createTextNode("King in the North");
			 
			raiz.appendChild(elem5);
			elem5.appendChild(text5);
			elem5.appendChild(text52);

			text5.appendChild(text5a);
			text52.appendChild(text5b);
			
			Element elem6 = documento.createElement("aliases"); 
			Element text6 = documento.createElement("alias");
			Element text62 = documento.createElement("alias");
			Element text63 = documento.createElement("alias");
			Element text64 = documento.createElement("alias");
			Element text65 = documento.createElement("alias");
			Element text66 = documento.createElement("alias");
			Element text67 = documento.createElement("alias");
			Element text68 = documento.createElement("alias");	
			
			Text text6a = documento.createTextNode("Lord Snow");
			Text text6b = documento.createTextNode("Ned Stark's Bastard");
			Text text6c = documento.createTextNode("The Snow of Winterfell");
			Text text6d = documento.createTextNode("The Crow-Come-Over");
			Text text6e = documento.createTextNode("The 998th Lord Commander of the Night's Watch");
			Text text6f = documento.createTextNode("The Bastard of Winterfell");
			Text text6g = documento.createTextNode("The Black Bastard of the Wall");
			Text text6h = documento.createTextNode("Lord Crow");

			raiz.appendChild(elem6);
			elem6.appendChild(text6);
			elem6.appendChild(text62);
			elem6.appendChild(text63);
			elem6.appendChild(text64);
			elem6.appendChild(text65);
			elem6.appendChild(text66);
			elem6.appendChild(text67);
			elem6.appendChild(text68);

			text6.appendChild(text6a);
			text62.appendChild(text6b);
			text63.appendChild(text6c);
			text64.appendChild(text6d);
			text65.appendChild(text6e);
			text66.appendChild(text6f);
			text67.appendChild(text6g);
			text68.appendChild(text6h);
			
			
			Element elem7 = documento.createElement("books"); 
			Element text7 = documento.createElement("book");
			Element text72 = documento.createElement("book");
			Element text73 = documento.createElement("book");
			Element text74 = documento.createElement("book");
			Element text75 = documento.createElement("book");
			Element text76 = documento.createElement("book");
			Text text7a = documento.createTextNode("A Game of Thrones (1996)");
			Text text7b = documento.createTextNode("A Clash of Kings (1998)");
			Text text7c = documento.createTextNode("A Storm of Swords (2000)");
			Text text7d = documento.createTextNode("A Feast for Crows (2005)");
			Text text7e = documento.createTextNode("A Dance with Dragons (2011)");			
			Text text7f = documento.createTextNode("The Bastard of Winterfell");


			raiz.appendChild(elem7);
			elem7.appendChild(text7);
			elem7.appendChild(text72);
			elem7.appendChild(text73);
			elem7.appendChild(text74);
			elem7.appendChild(text75);
			elem7.appendChild(text76);

			text7.appendChild(text7a);
			text72.appendChild(text7b);
			text73.appendChild(text7c);
			text74.appendChild(text7d);
			text75.appendChild(text7e);
			text76.appendChild(text7f);

			Element elem8 = documento.createElement("season");
			Element elem82 = documento.createElement("season");
			Element elem83 = documento.createElement("season");
			Element elem84 = documento.createElement("season");
			Element elem85 = documento.createElement("season");
			Element elem86 = documento.createElement("season");
			Element elem87 = documento.createElement("season");
			Element elem88 = documento.createElement("season");

			Text text8a = documento.createTextNode("Season 1");
			Text text8b = documento.createTextNode("Season 2");
			Text text8c = documento.createTextNode("Season 3");
			Text text8d = documento.createTextNode("Season 4");
			Text text8e = documento.createTextNode("Season 5");
			Text text8f = documento.createTextNode("Season 6");
			Text text8g = documento.createTextNode("Season 7");
			Text text8h = documento.createTextNode("Season 8");
			raiz.appendChild(elem8);
			raiz.appendChild(elem82);
			raiz.appendChild(elem83);
			raiz.appendChild(elem84);
			raiz.appendChild(elem85);
			raiz.appendChild(elem86);
			raiz.appendChild(elem87);
			raiz.appendChild(elem88);

			elem8.appendChild(text8a);
			elem82.appendChild(text8b);
			elem83.appendChild(text8c);
			elem84.appendChild(text8d);
			elem85.appendChild(text8e);
			elem86.appendChild(text8f);
			elem87.appendChild(text8g);
			elem88.appendChild(text8h);
			

			
			//Meter los interpretes en los personajes(playedBy)
			String[] interpretes = {" Alfie Allen"," Isaac Hempstead-Wright"," Art Parkinson"," Richard Madden"," Sophie Turner"," Kit Harington"};

			NodeList personajes = documento.getElementsByTagName("name");
			for(int i =0; i<personajes.getLength(); i++) {
				
			Node personajeDef = personajes.item(i);

				if(personajeDef.getNodeType() == Node.ELEMENT_NODE) {
					
					Element playedBy = documento.createElement("playedBy");
					playedBy.appendChild(documento.createTextNode(interpretes[i]));
					personajeDef.appendChild(playedBy);
				}
			}
			
			//Guardar documento
			DOMSource fuente = new DOMSource(documento);
			Result resultado = new StreamResult(new java.io.File("/home/2dam/Documentos/mixml.xml"));
			Transformer transformador = TransformerFactory.newInstance().newTransformer();
			transformador.transform(fuente, resultado);
		}catch(Exception e) {
			System.out.print(e.getMessage());
		}
	}
}
