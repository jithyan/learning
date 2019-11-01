# Functional Interfaces, Lambdas and Streams

## Functional Interfaces

* Is annotated with `@FunctionalInterface`
* Can have only **one** method, which is abstract.

Example:
```java
@FunctionalInterface
public interface Example {
   public abstract void greeter(String name);
}
```

* Functional interfaces basically allow you to pass around code as data. 

To implement the above example:
```java
public class Main {
   public static void main(String... args) {
      Example greetingPrinter = new Example() {
         @Override
         public void greeter(String name) {
            System.out.println("Hello " + name);
         }
      }
      greetingPrinter.greeter("John");
   }
}
```
## Lambdas

This allows you to circumvent all the boiler plate code in implementing a functional interface.

```java
public class Main {
   public static void main(String... args) {
      //String in the argument is optional - since it has to comply with the Example interface
      Example greetingPrinter = (String name)  -> {
            System.out.println("Hello " + name);
         };  
      greetingPrinter.greeter("John");
   }
}
```

## Method References
![m](./methodreferences.PNG)

The above is used when you're using a lambda to take an argument and invoke a single method on it.
I n this instance, you can use the syntactic sugar: <ArgType>::<MethodToInvoke>
Example: `Shape s = Square::calculateArea`

## Streams

![extiter](./extiter.PNG)

* Streams are faster than external iteration.
* Streams use internal iteration.
* When you call `.stream()`, a `Stream` object is returned, instead of an iterator.
* There are two types of methods provided by Stream: lazy evaluation and eager evaluation.
* Filter is a lazy evaluation that adds objects from an existing stream to a new one. Execution will only proceed to the next line once the entire stream is filtered.
* Foreach which eagerly evaluate every object in the stream.

## Parallel Streams

To take care of parallelization, simply use `.parallelStream()` instead of  `.stream()`!