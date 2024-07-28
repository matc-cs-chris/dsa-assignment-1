Assignment for Data Structures and Algorithms - Madison College 
Author: Instructor Chris Peterson


-About This Project-


This project includes reusable classes to serialize objects. You don't have to understand serialization completely.
The intent is rather to provide practice in debugging.

I've intentionally made common errors in my code: syntax, logical, and runtime errors.
It will help if you understand the code somewhat, but is not strictly necessary in order to debug it.

Your job is twofold:

1) to get the code running. It should properly serialize and deserialize objects when you're done.

2) You must version your project using git with github.com
You should push revisions to your remote github repository at least once per bug fixed.


-What's Serialization?-


"Serialization" in programming refers to the process of storing the "state" of an object instance in text or binary. 
This is often then written to file or sent via the internet.

Remember that the "state" of an object instance is comprised of the data stored in its fields. 
This is because methods cannot store any data for an object beyond manipulating fields.

This could be in a variety of formats: XML, JSON, pure binary, or a custom representation. 
Remember that all formats boil down to binary eventually as characters are encoded as numbers which are written in binary.

XML or JSON provide well-structured textual representations of saved data, 
but binary will be most memory efficient as it eliminates all formatting or need for encoding characters.

In contrast, binary will not be human readable without programmatic deserialization. 
Deserialization is the process of restoring the state of an object from a serialized representation of it.

Serialization to binary in Java is accomplished with an ObjectOutputStream and deserialization uses the ObjectInputStream. 
You could also create your own custom way of serialization, or use a known library.

Any object that can be serialized must implement the marker interface "Serializable.
Recall that marker interfaces are interfaces that define no methods, and are just used to mark a class as belonging to some group.

There are some issues when you try to serialize a field of a non-serializable non-primitive type.
An example would be if a movie object stores a list of song objects in an instance field.

You can mark a field as "transient" to tell Java that it should not attempt to serialize a field.
An example:

public class EggSalad implements Serializable {

  public double weightInKG; //this will be serialized

  private transient int numberOfEggs; //this will not
  
}


-Classes Contained Here-


Main - contains the main method of the project, so it's runnable. 
It's merely a test, and you can modify the main method as needed for your own testing.

Movie, Song- These are just examples, you'll see that they implement Serializable so you should be able to serialize and deserialize them

Exceptions- These custom exceptions indicate some things could go wrong at runtime with serialization

IOjectStorage- an interface that defines the methods for a class that serializes, stores, and deserializes objects
Note that you must specify an ID to identify a saved object with for later access

ObjectStorage- an abstract class that provides a utility method that transforms an object's state into an array of bytes

FileObjectStorage - an implementation of ObjectStorage that saves to file

MemoryObjectStorage - an implementation of ObjectStorage that stores serialized objects in memory
this really isn't necessary, since the deserialized objects are already stored in memory

MemoryObjectStorage is just meant as an example of another method of ObjectStorage
You could have numerous other ways of storing objects, such as in a database, or communication with remote computers via http


-Other Notes-


My documentation here is not exhaustive, but it's probably more than you'd get in a job.

One of the objectives of this project is to get used to reading others' code and even fixing it.

If you're confused, as always, you should ask me for clarification. 
A great way to guarantee I have time to answer fairly fully is to ask in class.
