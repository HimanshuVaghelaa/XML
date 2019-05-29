package Codes;

import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.SAXParser;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXParserExample extends DefaultHandler
{
    public static void main(String[] args) 
    {
        try
        {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            
            DefaultHandler handler = new DefaultHandler()
            {
                boolean studentFirstName = false;
                boolean studentLastName = false;
                boolean studentNickName = false;
                boolean studentMarks = false;
                
                public void startElement (String url, String lacalName, String qName, Attributes attributes) throws SAXException
                {
                    System.out.println("Start Element : " + qName);
                    System.out.println("************************");
                    
                    if (qName.equalsIgnoreCase("firstname"))
                    {
                        studentFirstName = true;
                    }
                    if (qName.equalsIgnoreCase("lastname"))
                    {
                        studentLastName = true;
                    }
                    if (qName.equalsIgnoreCase("nickname"))
                    {
                        studentNickName = true;
                    }
                    if (qName.equalsIgnoreCase("marks"))
                    {
                        studentMarks = true;
                    }
                }
                
                public void endElement(String url, String localName, String qName) throws SAXException
                {
                     System.out.println("************************");
                    System.out.println("End Element: " + qName);
                }
                
                public void characters(char ch[], int start, int length) throws SAXException
                {
                    if (studentFirstName)
                    {
                        System.out.println("First Name : " + new String(ch, start, length));
                        studentFirstName = false;
                    }
                    if (studentLastName)
                    {
                        System.out.println("Last Name : " + new String(ch, start, length));
                        studentLastName = false;
                    }
                    if (studentNickName)
                    {
                        System.out.println("Nick Name : " + new String(ch, start, length));
                        studentNickName = false;
                    }
                    if (studentMarks)
                    {
                        System.out.println("Marks : " + new String(ch, start, length));
                        studentMarks = false;
                    }
                }
            };
            saxParser.parse("src/Codes/Input.xml", handler);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
    }
    
}
