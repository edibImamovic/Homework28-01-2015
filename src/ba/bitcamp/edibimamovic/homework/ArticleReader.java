package ba.bitcamp.edibimamovic.homework;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.LinkedList;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * 
 * @author Edib Imamovic
 *
 */
public class ArticleReader {
	/**
	 * 
	 * @param args
	 * @throws TransformerException
	 * @throws SAXException
	 * @throws IOException
	 * @throws ParserConfigurationException
	 */
	public static void main(String[] args) throws TransformerException,
			SAXException, IOException, ParserConfigurationException {
		/**
		 * url : rss feed for klix.ba
		 */
		URL url = new URL("http://www.klix.ba/rss/svevijesti");
		URLConnection conn = url.openConnection();
		/**
		 * Parse for conn (url)
		 */
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.parse(conn.getInputStream());

		NodeList xmlKlixTitle = doc.getElementsByTagName("title");
		NodeList xmlKlixContent = doc.getElementsByTagName("content");
		/**
		 * for loop to determine the number of titles
		 */
		int count = 0;
		for (int i = 0; i < xmlKlixTitle.getLength(); i++) {
			String title = xmlKlixTitle.item(i).getNodeValue();
			System.out.println(title);
			count++;
		}
		System.out.println("Ukupan broj èlanaka: " + count);
		/**
		 * for loop and value input of selected article.
		 */
		System.out.println("Unesite broj èlanka koji želite proèitati:");
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();

		String content = "";
		for (int i = 0; i < xmlKlixContent.getLength(); i++) {
			content = xmlKlixContent.item(num).getTextContent();
		}
		System.out.println(content.toString());
	}
}
