# dpij
Source code for *[Design Patterns in Java][1]* by Steve Metsker and Bill Wake

[1]: http://www.amazon.com/exec/obidos/ASIN/0321333020/xp123com "Design Patterns in Java"

2022-12-26
Verified no source changes needed for Java 17 and JUnit 5.9.1. - Bill Wake

2022-12-26
Verified no source changes needed to run with Java 17 and JUnit 5.4.2. - Bill Wake

2020-04-11
Verified that no source changes needed to run with Java 14 and JUnit 5.4.2. - Bill Wake

2020-04-11
Verified that no source changes needed to run with Java 11 and JUnit 5.4.2. - Bill Wake

2020-04-11 
Added support for Java 10 and JUnit 5.4.2. - Bill Wake.

2020-04-10
I've [Bill Wake] updated the code to work with JDK 1.8 and JUnit 4.13. This eliminated the need for references to TestCase, and let tests use assertThrows().

2016-01-10
The original code from the book is in OozinozDpij-original.zip; the current code is updated to use generics etc. 

Thanks to Juan Manuel Gimeno for making those changes:
* Added an interface com.oozinoz.iterator.AcycliclyIterable to allow generic iterator code.
* Used foreach rather than for/while loops.
* Corrected some javadoc problems.
* Changed StringBuffers to StringBuilders and Hashtables to HashMaps. 
* Changed the locale to ENGLISH to get tests to pass regardless of local locale.





