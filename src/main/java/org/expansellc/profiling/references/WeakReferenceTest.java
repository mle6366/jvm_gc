package org.expansellc.profiling.references;

public class WeakReferenceTest {

    public void execute(){

        Person hardRefPerson = new Person();

        java.lang.ref.WeakReference<Person> weakRefPerson =
                new java.lang.ref.WeakReference<Person>(hardRefPerson);

        // Should print out same hash
        System.out.println("Hard Reference to Person is " + hardRefPerson);
        System.out.println("Weak Reference to Person is " + weakRefPerson.get());

        // dereference
        System.out.println("Destroying hard reference");
        hardRefPerson = null;
        System.out.println("Hard Reference to Person is " + hardRefPerson);

        // GC hasn't occured, so the same address as hardref exists as it did before dereference
        System.out.println("Weak Reference to Person is " + weakRefPerson.get());

        // weak references immediately removed during gc
        System.out.println("Performing Garbage Collection . . .");
        System.gc();
        System.out.println("Weak Reference to Person is " + weakRefPerson.get());
    }
}

final class Person {

    @Override
    protected void finalize() throws Throwable {
        System.out.println("GC Calling finalize() of: " + this.toString());
        super.finalize();
    }
}
