import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
public class parser {
	public static void main(String[] args)throws Exception {

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();

		Document document = builder.parse(new File("/root/eclipse-workspace/XML/WebContent/users.xml"));
		//Normalize the XML Structure; It's just too important !!
		//document.getDocumentElement().normalize();
		// TODO Auto-generated method stub
		//Here comes the root node
		Element root = document.getDocumentElement();
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter User Id");
		String id=br.readLine();
		//Get all employees
		NodeList nList = document.getElementsByTagName("user");
		System.out.println(root.getNodeName());
		System.out.println("============================");
		for (int temp = 0; temp < nList.getLength(); temp++)
		{
			Node node = nList.item(temp);
			System.out.println(""); //Just a separator
			if (node.getNodeType() == Node.ELEMENT_NODE)
			{
				//Print employee's details of given id
				Element eElement = (Element) node;
				if(eElement.getAttribute("id").equals(id))
				{
					System.out.println("Employee id : " + eElement.getAttribute("id"));
					System.out.println("First Name : " +
							eElement.getElementsByTagName("firstName").item(0).getTextContent());
					System.out.println("Last Name : " +
							eElement.getElementsByTagName("lastName").item(0).getTextContent());
					System.out.println("Location : " +
							eElement.getElementsByTagName("location").item(0).getTextContent());
				}
			}
		}
	}
}
