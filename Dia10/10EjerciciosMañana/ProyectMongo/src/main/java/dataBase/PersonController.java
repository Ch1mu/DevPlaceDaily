package dataBase;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

import models.Person;

public class PersonController {
Connect connection;
MongoDatabase mdb;
MongoCollection <Document> persons; 
public PersonController()
{
	connection = new Connect();
	mdb = connection.getDb();
	 persons = mdb.getCollection("Person");
}

public void insertPerson(Person person)
{
	
	persons.insertOne(new Document("FirstName", person.getFirstname()).append("LastName", person.getLastname()).append("DNI", person.getDni()).append("Address", person.getAddress()));
}

public void getPersons()
{
	MongoCursor<Document> pIterator = persons.find().iterator();
	while(pIterator.hasNext())
	{
		System.out.println(pIterator.next().toJson());
	}
}
public void getPersonDni(String Dni)
{
	FindIterable<Document> personD = persons.find().filter(new Document("DNI", Dni));
	
if(personD.first() != null)
		System.out.println(personD.first().toJson());


}
public void deletePerson(String Dni)
{
	persons.deleteOne(new Document("DNI", Dni));
}
}
