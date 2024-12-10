#  [Easy Tuples for Java](https://easytuples.github.io/easy-tuples/)

---

## Overview

With Java 16 providing us with [records](https://openjdk.java.net/jeps/395) as a standard feature we now have a way
of creating tuples in Java. However, these are 'nominal' tuples - in other words the tuples need to be named.

In some situations (where the scope of the tuple will only exist within a single method
body, for example) it is just more convenient to not bother naming the tuple and view it
instead structurally - for example as a pair (2-tuple) or triplet (3-tuple) or otherwise.

Enter the easy-tuples library...

easy-tuples provides easy and convenient generic records representing tuples with one to ten fields and with a
consistent naming. You can use easy-tuples in the situation where it makes code more readable to remove the
'nominal' and think 'structural'.

```java
// Create a pair and a triplet...       // toString():
var d1 = _2.of(25, "December");         // _2[_1=25, _2=December]
var d2 = _3.of(12, "January", 2021);    // _3[_1=12, _2=January, _3=2021]

// Append the missing year on d1.
var d1Updated = d1.append(2021);        // _3[_1=25, _2=December, _3=2021]

// Get the month of d1 and use a setter
// of d2 to make them equal. 
var d1Month = d1._2();                  // Use the getter for the field 
var d2Updated = d2.set2(d1Month);       // _3[_1=12, _2=December, _3=2021]
```

## Usage

### Dependency Coordinates

easy-tuples [is available at Maven Central](https://central.sonatype.com/artifact/io.github.easytuples/easy-tuples)

![Maven Central Version](https://img.shields.io/maven-central/v/io.github.easytuples/easy-tuples)

Maven style coordinates:
```xml
<dependency>
    <groupId>io.github.easytuples</groupId>
    <artifactId>easy-tuples</artifactId>
    <version>$LATEST_VERSION<!-- see above badge --></version>
</dependency>
```

And Gradle:

```groovy
implementation 'io.github.easytuples:easy-tuples:$LATEST_VERSION' // See maven central badge above for latest version
```

### API

Each tuple exposes an intuitive, uniform API:
- Name
    - Tuples are named with an underscore followed by the size of the record e.g. `_1`, `_2`, etc.
    - Similarly, fields within the tuple are named with an underscore followed by their positional index.
        - Tuples are 1-indexed (not 0-indexed), so the names of their fields are `_1`, `_2`, etc.
    ```java
    // Declarations illustrating the intuitive naming convention of each generic tuple record and its fields:
    // ... 
    public record _2<A, B>(A _1, B _2) { /* ... */ }
    public record _3<A, B, C>(A _1, B _2, C _3) { /* ... */ }
    // ...
    ```
- Creation/Factory Method
    - You can use the canonical constructor to create an instance of each tuple:
  ```java
  // Creating a 2-tuple of a String and Int using the constructor:
  _2<String, Integer> a = new _2<>("hello", 4);
  // If you use type inference (var) and the diamond operator, <>, you don't have to specify any types:
  var b = new _2<>("hello", 4); // Type of _2<String, Integer>
  ```   
    - Alternatively you can use the factory method, `of(..)` which is defined for each tuple, along
      with `var` and also avoid having to declare any types.
  ```java
  var c = _2.of("what's", "up?");            // Type of _2<String, String>
  var d = _3.of(1, 'c', "what's up doc?");   // Type of _3<Integer, Character, String> 
  ```
- Getters
    - Fields of the tuple are retrievable with public getter methods named after the fields themselves e.g.  `_1()`, `_2
      ()`, etc.
  ```java
  var d = _3.of(1, 'c', "what's up doc?");
  Integer fst = d._1();    // Integer: 1
  Character snd = d._2();  // Char: 'c'
  String thd = d._3();     // String: "what's up doc?"
  ```
- Setters
    - Setters allow you to generate a new tuple with the element at the given index in the tuple replaced with your
      object.
    - Setters are named `setN` with `N` replaced with the index in the tuple we want to replace (remember tuples are
      1-indexed not 0-indexed).
    - Tuples are immutable so setters always return a new object.
  ```java
  // 3-tuple will come with three setters, named set1(..), set2(..), set3(..)
  var harry = _3.of("Harry", "Potter", "4 Privet Drive"); // _3[_1=Harry, _2=Potter, _3=4 Privet Drive]
  // We want to set field at the third index to a new value.
  var harryUpdated = harry.set3("Hogwarts School");       // _3[_1=Harry, _2=Potter, _3=Hogwarts School]
  // harry remains unchanged since tuples are immutable....   
  ```
- Appender
    - Tuples come with a method `append(T arg)` which takes a single argument and returns a new tuple one size
      larger that has the `T arg` object appended on at the last index.
    - All tuples have this method except the 10-tuple which, being the largest size tuple available, cannot append
      anymore objects to it.
  ```java
  // We want to append to an existing tuple
  var harry = _3.of("Harry", "Potter", "4 Privet Drive"); // _3[_1=Harry, _2=Potter, _3=4 Privet Drive]
  var harryUpdated = harry.append("Student");             // _4[_1=Harry, _2=Potter, _3=4 Privet Drive, _4=Student]
  ```
    - Appending is particularly useful in streams when you need to perform a `map` on an object in the tuple but
      don't want to lose the object itself in the next operation in the stream. 

## Suggested Use

- As intermediate, temporary objects within a stream.
- Within non-public method bodies and (rarely) as non-public method return types.


## Non suggested use

It is probably best to avoid using these tuples:
- across code boundaries in public APIs (in that case a properly named tuple would be better).


## FAQs

- Q: I want more than a 10-tuple.
- A: Check out the code generator sub-project in this repo and use it to generate your own records up to 26 in size.
