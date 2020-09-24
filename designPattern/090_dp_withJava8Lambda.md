## Design Patterns with Java 8’s Lambdas

> Hint: Any design pattern which is based on one sigle funtion. However this is not limited.

### Abstract Factory

A lambda that conforms to some interface and returns a new object. 

### Adapter

A lambda that calls a function with a different signature on some other object.
(Assuming the adapter interface has one public function.)

### Chain of responsibility

A lambda that may or may not delegate to another lambda, which may or may not delegate to another lambda, ad infinitum.
(How to get the ‘next’ reference into the lambda is left as an exercise for the reader.)

### Command

Otherwise known as: a lambda!
(Assuming you’re not planning on implementing undo. But then you just want a tuple of lambdas, don’t you?)

### Decorator

A lambda that calls another lambda with the same signature but changes the arguments on the way in, or the result on the way out, or performs some extra action.
(Assuming the decorated object has one public function.)

### Iterator

Close (though not identical) to forEach(lambda). More specific functions like map(lambda), filter(lambda), flatMap(lambda), foldLeft/Right(lambda), reduceLeft/Right(lambda), etc. cater for the majority of Iterator’s use in modern Java.

### Observer

Give some other object a lambda to call when something happens in the future.
(Assuming the Observer interface has a single function.)

### Strategy

Choose from a family of lambdas with identical signatures at runtime.

### Template method

Replace the abstract method polymorphism with composition, passing lambdas into the constructor.

### Visitor

### Validator


Once  a problem has a model. It can be implemented as a function. that can be created using:
- factory methods
- default methods

Handling exceptions are tricky though