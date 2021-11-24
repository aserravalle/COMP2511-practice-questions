# Sample Exam Quetions

The following questions are practice questions. They may not be representative of the style or difficulty of the questions in the exam. There may be questions in the Final Exam of a different style and structure to these examples. To get a better idea of the structure/style of questions in the exam, please refer to the [Sample Exam](https://www.cse.unsw.edu.au/~cs2511/21T3/SampleExam/) and the [Final Exam Structure](https://webcms3.cse.unsw.edu.au/COMP2511/21T3/resources/69283)

* * * * *

Short-Answer Practice Questions
-------------------------------

<mark>**Please note that the topics covered in the final exam may be different to the topics covered in these practice questions. Also, the number of questions for each section may vary.**</mark>

### Example 1

Give the most appropriate design pattern for the following situations. You must briefly justify your answer.

**(A)** You are implementing a health application that monitors heart rate of a patient. If the heart rate of a patient is out of the required range, the application needs to inform all the relevant doctors and nurses. Doctors and nurses responsible for a patient may change over time.

**(B)** A user bought an application that reads data in JSON format, and displays results on a web page. Later, the user realised that one of their data sources is in XML format. Unfortunately, the user does not have access to the source code of the application, so it is not possible to change the application.

**(C)** You run an icecream shop that sells many different styles and toppings, to try to get more customers to buy more toppings; you are introducing a bundle system, where certain toppings in conjunction with others offers discounts and unique prices.  For example, adding sprinkles ontop of a magic shell reduces the price cost of the magic shell by 40%, and the magic shell pricing is based on the surface area of the underlying toppings + icecream.

* * * * *

### Example 2

Briefly explain the important differences between the Decorator Pattern and the Builder Pattern, as discussed in the lectures.

* * * * *

### Example 3

Briefly explain the important differences between the Factory Method and Abstract Factory Method Patterns, as discussed in the lectures.

* * * * *

There are more questions in the [Sample Exam](https://www.cse.unsw.edu.au/~cs2511/21T3/SampleExam/).

* * * * *

Programming Practice Questions for Question 1
------------------------------

<mark>**Please note that the topics covered in the final exam may be different to the topics covered in these practice questions. Also, the number of questions for each section may vary.**</mark>

### Example 1 (Generics, 20T3 Final Exam)

The Java package for this question is accessible via [this link](programmingexample1/src/programmingexample1).

The interface `Hamper<E>` is for hampers that can handle elements of a generic type E. A hamper is similar to a set but allows for duplicate elements. A "hamper" in real life is a basket of gifts full of lots of nice things, e.g. fruits, chocolates, toys, etc...

Complete all methods marked TODO in `ArrayListItemHamper`, `CreativeHamper` and `FruitHamper`. The class `ArrayListItemHamper` uses an `ArrayList` of `Count<E>` to track the count of each element. Pay careful attention to the contract and documentation in `Hamper`, as well as the invariants in `ArrayListItemHamper`, `CreativeHamper`, and `FruitHamper` to make sure your implementation is correct. Make sure that your solution successfully passes the tests in `TestHamper`.

`CreativeHamper` is a hamper for which the price of the hamper is $10 more than the sum of the prices of the items inside it. A `CreativeHamper` which contains 5 or more items, must have at least 2 toy cars (at least 1 must be a premium toy car), and at least 2 fruits. When adding items to a `CreativeHamper`, if this condition cannot be adhered to, the items should not be added.

`FruitHamper` is a hamper of fruits for which the price of the hamper is 25% more than the sum of the prices of the fruits inside it (if the result of this is not an integer, the result should be rounded up to the nearest dollar). A `FruitHamper` which contains 6 or more fruits, must have at least 2 avocados, and at least 2 apples. When adding items to a `FruitHamper`, if this condition cannot be adhered to, the items should not be added.

Note that all currency values in this question and the starter code are in Australian dollars.

The tests used in automarking will be much more extensive than the JUnit tests provided in the dryrun and starter code. Thus, you should test your code thoroughly according to the details in this specification and the requirements/conditions outlined in the starter code.

You should not rely on any modifications to code other than in the files `ArrayListItemHamper.java`, `CreativeHamper.java` and `FruitHamper.java`

Note that, for your implementation of the `sum` method in `ArrayListItemHamper`, `FruitHamper`, and `CreativeHamper`, it is acceptable to create a new `ArrayListItemHamper` to contain the elements from the summation and return this.

### Example 2 (Generics, 20T2 Final Exam)

The Java package for this question is accessible via [this link](programmingexample2/src/programmingexample2).

The interface `Bag<E>` is for bags that can handle elements of a generic type E. A bag is similar to a set but allows for duplicate elements. Complete all methods marked TODO in `ArrayListBag`. The class uses an `ArrayList` of `Count<E>` to track the count of each element. Pay careful attention to the contract and documentation in `Bag`, as well as the invariant in `ArrayListBag`, to make sure your implementation is correct. Make sure that your solution successfully passes the tests in `TestBag`.

### Example 3 (Pattern Implementation, 20T3 Final Exam)

The Java package for this question is accessible via [this link](ProgrammingExample5/src/programmingexample5).

For a quick reference, the interfaces/classes from the package are listed below. Note that, most of them are partially implemented.

```
Circle    ShapeColourAreaVisitor ShapeVisitable
Rectangle ShapeColourVisitor     ShapeVisitor
Shape     ShapeGroup             Triangle
```

In this question, you must use the Visitor pattern (as discussed in the lectures) to implement your solution. Make sure that your solution successfully passes the given JUnit tests. Please note that we will use additional tests to extensively test your solution.

#### Tasks:

Using the Visitor pattern (as discussed in the lectures):

1.  Complete the interface `ShapeVisitor` for the classes that implement `ShapeVisitable` in the package `programmingexample5`.
2.  Implement the required method `accept` in the classes `Circle`, `Rectangle`, `Triangle` and `ShapeGroup`.
3.  Implement the visitor class `ShapeColourVisitor` that sets the colour of circles to red, rectangles to green, and triangles to blue.
4.  Implement the visitor class `ShapeColourAreaVisitor` that can be used to calculate total area covered by shapes of a given colour.

The tests in `ShapeVisitorTest` will guide you in completing these. You should ensure your solution passes these tests. Note that you **must** use the visitor pattern (as discussed in lectures) for the above tasks. Otherwise, you will not be awarded marks for this question, even if you pass some/all the tests provided.

### Example 4 (Pattern Implementation, 20T2 Final Exam)

The Java package for this question is accessible via [this link](ProgrammingExample6/src/programmingexample6).

The class `Product` represents a product in an online store with a price and weight. The weight is used to calculate the shipping cost. Using the decorator pattern (as discussed in lectures):

1.  Implement `DiscountDecorator` that discounts the price of a product by a given percentage. Multiple discounts are applied cumulatively (e.g. if 20% discount on $100 gives a price of $80, a further discount of 20% would give a price of $64).
2.  Implement `FreeShippingDecorator` that makes shipping free for products over a given price and under a given weight. Note that, if this decorator is applied to a discounted product, whether or not it qualifies for free shipping depends on the *discounted* price.

The tests in `TestProduct` will guide you in completing these. You should ensure your solution passes these tests. Note that you **must** use the decorator pattern (as discussed in lectures) for the above two tasks (`DiscountDecorator` and `FreeShippingDecorator`). Otherwise, you will not be awarded marks for this question, even if you pass some/all the tests provided.

Programming Practice Questions for Question 2 - Refactoring
------------------------------

| :information_source:   In the exam, you'll be asked to extend the solution after refactoring as well.   🧪  You should also revisit the labs 2, 4, 5. |
| --- |

### Example 5 (Refactoring, 20T2 Final Exam)

The Java project containing code you'll need to modify for this question is accessible via [this link](ProgrammingExample7/src/programmingexample7).

Analyse the classes `Employee`, `Engineer`, `SalesMan` and `SalesHistory`. The source code in these classes suffer from various code smells. Applying suitable refactoring techniques, modify the Java source files to address each of the following code smells. You MUST include brief comments in your code to identify the smells and explain the refactoring techniques used.

Code smells to address:

-   Refused Bequest
-   Duplicated code
-   Excessive coupling between classes
-   Lazy class

Note: the lecture notes on Code Smells are available here: ['Code Smell Lecture'](https://webcms3.cse.unsw.edu.au/static/uploads/course/COMP2511/19T2/fb0104a296f7f4cd16b4f6e762218f0d871761be462655ab7e04f9894cb79ade/week08_CodeSmell.pdf).

* * * * *

End

* * * * *

