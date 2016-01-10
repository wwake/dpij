# dpij
Source code for *[Design Patterns in Java][1]* by Steve Metsker and Bill Wake

[1]: http://www.amazon.com/exec/obidos/ASIN/0321333020/xp123com "Design Patterns in Java"

The original code from the book is in OozinozDpij-original.zip; the current code is updated to use generics etc. 

Thanks to Juan Manuel Gimeno for making those changes:
* Added an interface com.oozinoz.iterator.AcycliclyIterable to allow generic iterator code.
* Used foreach rather than for/while loops.
* Corrected some javadoc problems.
* Changed StringBuffers to StringBuilders and Hashtables to HashMaps. 
* Changed the locale to ENGLISH to get tests to pass regardless of local locale.





