# WordGames
## Advanced Java word game algorithm.

This coding project involves the implementation of a Word Game program using Java. The program consists of three main components: a SubString Problem Word Game, a Points Problem Word Game, and a Menu that allows the user to choose which game to play. Additionally, the program utilizes a separate dictionary file containing words for the word games.

The entire solution is encapsulated within a single class called WordGames. This class includes the main() method, responsible for processing menu selections and initiating the corresponding game based on the user's choice. The class also contains four static methods: getSelection(), substringProblem(), pointsProblem(), and main(). These methods follow a functional programming style. The constant class variable, DICTIONARY, stores the name of the dictionary file (dictionary.txt) to avoid repetition when referring to the dictionary from multiple locations.

The menu selection functionality is implemented through the getSelection() method, which displays the available menu options, prompts the user for their selection using Java's Scanner class, and returns the chosen option to the calling method. The menu offers three options: one for each problem and one to exit the program.

The first problem, the SubString Problem Word Game, tests the player's ability to utilize word fragments to form or deconstruct complete words. The term "substring" in this context refers to fragments such as prefixes, infixes, or suffixes. The goal is to determine if a given substring is a prefix, infix, or suffix of a provided word. The program solves this problem for all the words in the dictionary file.

The second problem, the Points Problem Word Game, involves scoring based on the letters used to create a word. Each letter has a specific point value associated with it. The program calculates the total points for a given word according to the point values assigned to each letter. This problem is also solved for all the words in the dictionary file.

Overall, this coding project aims to create an interactive Word Game program where users can play different word games, such as the SubString Problem and the Points Problem, using a menu interface and a dictionary file.
