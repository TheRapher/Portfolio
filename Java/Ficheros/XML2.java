package Pract;

import java.io.File;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Pract7 {

   public static void main(String[] args) {

      try {
         File inputFile = new File("C:\\Actividades_Java\\Pract7_AD\\src\\Pract\\demo.xml");
         SAXParserFactory factory = SAXParserFactory.newInstance();
         SAXParser saxParser = factory.newSAXParser();
         UserHandler userhandler = new UserHandler();
         saxParser.parse(inputFile, userhandler);     
      } catch (Exception e) {
         e.printStackTrace();
      }
   }   
}

class UserHandler extends DefaultHandler {

   boolean id = false;
   boolean name = false;
   boolean gender = false;
   boolean culture = false;
   boolean born = false;
   boolean died = false;
   boolean alive = false;
   boolean titles = false;
   boolean title = false;
   boolean rialiases = false;
   boolean aliases = false;
   boolean alias = false;
   boolean father = false;
   boolean mother = false;
   boolean spouse = false;
   boolean allegiances = false;
   boolean allegiance = false;
   boolean books = false;
   boolean book = false;
   boolean TvSeries = false;
   boolean season = false;
   
   
   @Override
   public void startElement(
      String uri, String localName, String qName, Attributes attributes)
      throws SAXException {
      if(qName.equalsIgnoreCase("GOT")) {
    	  System.out.println("--->GOT");
       
      }else if (qName.equalsIgnoreCase("character")) {
          System.out.println("---->character");
          
      }else if(qName.equalsIgnoreCase("id")) {
    	  id = true;
           
      } else if (qName.equalsIgnoreCase("name")) {
         name = true;
      } else if (qName.equalsIgnoreCase("gender")) {
         gender = true;
      } else if (qName.equalsIgnoreCase("culture")) {
         culture = true;
      } else if (qName.equalsIgnoreCase("born")) {
         born = true;
      } else if (qName.equalsIgnoreCase("died")) {
          died = true;
      } else if (qName.equalsIgnoreCase("alive")) {
           alive = true;
      } else if (qName.equalsIgnoreCase("titles")) {
           titles = true;
      } else if (qName.equalsIgnoreCase("title")) {
           title = true;
      } else if (qName.equalsIgnoreCase("rialiases")) {
           rialiases = true;
      } else if (qName.equalsIgnoreCase("aliases")) {
           aliases = true;
      } else if (qName.equalsIgnoreCase("alias")) {
           alias = true;
      } else if (qName.equalsIgnoreCase("father")) {
           father = true;
      } else if (qName.equalsIgnoreCase("mother")) {
          mother = true;
      } else if (qName.equalsIgnoreCase("spouse")) {
    	  spouse = true;
      } else if (qName.equalsIgnoreCase("allegiances")) {
    	  allegiances = true;
      } else if (qName.equalsIgnoreCase("allegiance")) {
    	  allegiance = true;
      }  else if (qName.equalsIgnoreCase("books")) {
    	  books = true;
      } else if (qName.equalsIgnoreCase("book")) {
    	  book = true;
      } else if (qName.equalsIgnoreCase("TvSeries")) {
          TvSeries = true;
      } else if (qName.equalsIgnoreCase("season")) {
          season = true;
      }
   }

   @Override
   public void endElement(String uri, 
      String localName, String qName) throws SAXException {
      
      if (qName.equalsIgnoreCase("GOT")) {
         System.out.println("End Element :" + qName);
      }
   }

   @Override
   public void characters(char ch[], int start, int length) throws SAXException {

      if (id) {
         System.out.println("------>id ");
         System.out.println("--------->" + new String(ch, start, length));
         id = false;
      } else if (name) {
    	  System.out.println("------>name ");
          System.out.println("--------->" + new String(ch, start, length));
           name = false;
      } else if (gender) {
    	  System.out.println("------>gender ");
          System.out.println("--------->" + new String(ch, start, length));
           gender = false;
      } else if (culture) {
    	  System.out.println("------>culture ");
          System.out.println("--------->" + new String(ch, start, length));
           culture = false;
      } else if (born) {
    	  System.out.println("------>born ");
          System.out.println("--------->" + new String(ch, start, length));
           born = false;
      } else if (died) {
    	  System.out.println("------>died ");
          System.out.println("--------->" + new String(ch, start, length));
           died = false;
      } else if (alive) {
    	  System.out.println("------>alive ");
          System.out.println("--------->" + new String(ch, start, length));
           alive = false;
      } else if (titles) {
    	  System.out.print("------>titles ");
          System.out.print(new String(ch, start, length));
           titles = false;
      } else if (title) {
    	  System.out.println("-------->title ");
          System.out.println("----------->" + new String(ch, start, length));
           title = false;
      } else if (rialiases) {
    	  System.out.print("------>rialiases ");
          System.out.println("--------->" + new String(ch, start, length));
           rialiases = false;
      } else if (aliases) {
    	  System.out.print("------>aliases ");
          System.out.print(new String(ch, start, length));
          aliases = false;
      } else if (alias) {
    	  System.out.println("-------->alias ");
          System.out.println("----------->" + new String(ch, start, length));
           alias = false;
      } else if (father) {
    	  System.out.println("------>father ");
          System.out.println("--------->" + new String(ch, start, length));
          father = false;
      } else if (mother) {
    	  System.out.println("------>mother ");
          System.out.println("--------->" + new String(ch, start, length));
           mother = false;
      } else if (spouse) {
    	  System.out.println("------>spouse ");
          System.out.println("-------->"+new String(ch, start, length));
           spouse = false;
      } else if (allegiances) {
    	  System.out.println("------>allegiances ");
          System.out.println("------->"+new String(ch, start, length));
          allegiances = false;
      } else if (allegiance) {
    	  System.out.println("------>allegiance ");
          System.out.println("--------->" + new String(ch, start, length));
          allegiance = false;
      } else if (books) {
    	  System.out.print("------>books ");
          System.out.print(new String(ch, start, length));
          books = false;
      } else if (book) {
    	  System.out.println("-------->book ");
          System.out.println("----------->" + new String(ch, start, length));
          book = false;
      } else if (TvSeries) {
    	  System.out.print("------>TvSeries ");
          System.out.print(new String(ch, start, length));
          TvSeries = false;
      } else if (season) {
    	  System.out.println("-------->season ");
          System.out.println("----------->" + new String(ch, start, length));
          season = false;
      }
   }
}