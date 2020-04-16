# animal_shelter
The simple project for basic Java ecosystem practice

The project is an *Animal Shelter* system management in which one can:
- store data about animals in the shelter
- add new animal to the shelter
- delete animal from the shelter
- show specific animal data
- show statistics for Animal Shelter

Program uses *Java Serialization* for saving state of the shelter. *Extensions* for storing Objects are implemented Using dedicated class (**ExtensionClass.java**) which all business classes inherits over her for this purpose.

The **main method** is in **Main.java** class. This will show console menu where user can interact with by choosing the apriopiate menu (1-4) at the moment.

![Picture of Terminal with the Menu of possible actions in Animal Shelter System.](/images/consoleMenu.png)

When adding new animal One must give name of animal, species (lower case letters), date of birth of an Animal (in format shown), and weight (it is a float):

![Picture of adding new animal and what values and how one can give.](/images/addingNewAnimalFromConsoleMenu.png)

When One chooses to show status in console there is a short info about the current status of the shelter:

![Picture of the status info after choosing show status from console menu](/images/printingCurrentStatusOfAnimalShelterFromConsoleMenu.png)

When One would like to remove animal from the shelter it is asked to give **ID** of an Animal shown in the short list of Animals possible to delete:

![Picture of deleting animal. One must pick the ID from the short list and write it in the console](/images/deletingTheAnimalUsingConsoleMenu.png)

The last option closes the Program and saves its state to the **data.adf** file in the current *classpath*.

Also one can run program with the commands in the console:

`java com.slawomirlasik.animalshelter.Main <command> <args>`

To show current status of the shelter:

`java com.slawomirlasik.animalshelter.Main status`

![Picture of console command of showing current status of Animal Shelter](/images/showingStatusOfAnimalShelterUsingConsoleCommand.png)

To see help for console commands use:

`java com.slawomirlasik.animalshelter.Main ?`

or
`java com.slawomirlasik.animalshelter.Main help`

![Picture of console command for displaying help about console commands usage](/images/showingHelpForConsoleCommands.png)

To see animals stored in the Animal Shelter:

`java com.slawomirlasik.animalshelter.Main animals`

![Picture of console command for displaying all animals in the shelter at the moment](/images/showingAnimalsCurrentlyInTheShelterUsingConsoleCommand.png)

To add new animal using console command:

`java com.slawomirlasik.animalshelter.Main add <name_of_animal> <species> <date_of_birth> <weight>`

like so:

![Picture of console command for adding new animal with add name of animal, species, date of birth, weight](/images/addingNewAnimalUsingConsoleCommand.png)

and to delete using console command:

`java com.slawomirlasik.animalshelter.Main delete <ID>`

like so:

![Picture of console command for deleting animal giving the ID from the given list](/images/deletingTheAnimalUsingConsoleCommand.png)


There are some bugs. It is a working progress. All the found bugs can be found by browsing the [current branches](https://github.com/SlawomirLasik/animal_shelter/branches/yours).

