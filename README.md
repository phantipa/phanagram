PHANAGRAM
-
---
Phanagram is a blend of the words Phantipa and anagram.

Phanagram is a small program capable of finding all the words in a list that have one or more anagrams.

An anagram is a word or phrase created by rearranging the letters of another word or phrase, using each original letter exactly once.(https://en.wikipedia.org/wiki/Anagram)

Note:
* Not all words has an anagram.
* We are only interested in single-word anagrams.
* If the list contains the same word multiple times, it will only appear once in the anagram list.
* This program supports StandardCharsets.UTF_8.

Technologies
-
* **Java**
* **JUnit** - Testing framework for Java applications.
* **SonarLint** - Code quality and static analysis tool.
* **Git** - Version control system for tracking code changes.
* **Markdown** - Lightweight markup language for formatting text.

  
Project Structure
-

    src
    ├── main
    │   └── java
    │       └── com
    │           └── phantipa
    │               └── phanagram
    │                   ├── Main.java
    │                   └── service
    │                       ├── AnagramService.java
    │                       └── FileService.java
    │   └── resources
    │       └── static
    │           └── words-utf8.txt
    └── test
        └── java
            └── com
                └── phantipa
                    └── phanagram
                        └── service
                            ├── AnagramServiceTest.java
                            └── FileServiceTest.java'

Input
-
Input is a list of words, with one word per line.

Example:

    øl
    lø
    alt
    tal
    tal
    tall



Output
-
Output is a list where each line displays all the anagrams in the same group.

Example:

    øl lø
    alt tal