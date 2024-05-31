PHANAGRAM
-
     _                      __  _           
    |_) |_|  /\  |\ |  /\  /__ |_)  /\  |\/|
    |   | | /--\ | \| /--\ \_| | \ /--\ |  |


Phanagram is a blend of the words Phantipa and anagram.

An anagram is a word or phrase created by rearranging the letters of another word or phrase, using each original letter exactly once.(https://en.wikipedia.org/wiki/Anagram)

Phanagram is a small program which groups words into anagram sets by sorting their characters and using the sorted representation as a key in a map.

![AnagramMap](https://github.com/phantipa/phanagram/assets/4380010/7b56beec-520d-411a-8c80-7aacea8d23b5)

Content
-------
[Technologies](https://github.com/phantipa/phanagram/tree/master?tab=readme-ov-file#technologies)

[Project Structure](https://github.com/phantipa/phanagram/tree/master?tab=readme-ov-file#project-structure)

[Note](https://github.com/phantipa/phanagram/tree/master?tab=readme-ov-file#note)

[Running](https://github.com/phantipa/phanagram/tree/master?tab=readme-ov-file#running)

[Input](https://github.com/phantipa/phanagram/tree/master?tab=readme-ov-file#input)

[AnagramMap](https://github.com/phantipa/phanagram/tree/master?tab=readme-ov-file#anagramMap)

[Output](https://github.com/phantipa/phanagram/tree/master?tab=readme-ov-file#output)

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

Note
-

    [1] Not all words has an anagram.
    [2] We are only interested in single-word anagrams.
    [3] If the list contains the same word multiple times, it will only appear once in the anagram list.
    [4] This program supports StandardCharsets.UTF_8.

Running
-
    java .\src\main\java\com\phantipa\phanagram\Main.java


Input
-
Input is a text file with words, with one word per line.

Example:

    øl
    lø
    alt
    tal
    tal
    tall

AnagramMap

    {
    "lø": ["øl", "lø"],
    "alt": ["alt", "tal", "tal"],
    "allt": ["tall"]
    }

Output
-
Output is a list in console where each line displays all the anagrams in the same group.

Example:

    øl lø
    alt tal
