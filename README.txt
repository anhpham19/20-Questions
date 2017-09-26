* The new Java class I integrated in this program:

Since we have only worked a lot with the visual (GUI), I want my program to have
sound as well. To do this, I did some research online and learned to do this.
First of all, my GUI class has to import javax.sound.sampled.AudioInputStream, 
javax.sound.sampled.AudioSystem, javax.sound.sampled.Clip and java.io.File.
Then, I wrote a new method to play the music. I chose a (awesome) youtube song, 
convert it to wav type. And then I create an AudioInputStream object by 
getting AudioInputStream from the AudioSystem. Then I created a Clip object.
The Clip will open the AudioInputStream and starts to play. Because the song 
only lasts 4 minutes, I set the Clip to loop continuously until the user turn 
off the program.


** Guiding through the entire program:

I created 3 packages to make it organized and easier to understand. The first package
is datastructures which contain Linked List and Binary Tree data structure classes.
The second package is the (restricted) twenty question game and the third package
is the unrestricted twenty question game, each has Reader, Controller,  GUI and 
Application. Run by pressing the green button in the application class.

** Additional files:

+ Can’t Touch This_McHammer.wav is the audio file that I used to play the music for the program. This audio will automatically starts playing as soon as you open the program and it will also stops when you quit the program.

+ TwentyQuestionText.xml is the xml file which holds the data for the questions and objects initially. This XML file will be parsed and put in a binary tree for the purpose of this program.

+ README.text is the instruction for the whole program.