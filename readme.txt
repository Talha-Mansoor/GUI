//Talha Mansoor
//kgy284
//11346490
//Assignment 4

You can run my program by opening A4 folder in IntelliJ (or VS code)
Then by going into A4>src>main>java>com>example>a4

Everything Until Part 4 works completely as intended. we have 4 views. 


Part 1: MVC Basics
MVC Architecture: established the required classes which aligns with MVC architecture principles.
(SpaceApp, MainUI, SpaceModel, SpaceView, SpaceController, InteractionModel, PublishSubscribe) 

Class Asteroid & Star: Asteroids and stars are well implemented with normalized coordinates. 
Creating 10 asteroids in MainUI is consistent with the requirements.

View Drawing: SpaceView class uses immediate-mode graphics to draw the starfield and asteroids, 
fulfilling the specified drawing requirements.


Part 2: Procedural Asteroids and Animation
Asteroid Polygon Generation: properly added functionality in the Asteroid class to generate 
a polygon shape for each asteroid.

Asteroid Movement and Spin: code correctly updates the position and spin of the asteroids. 
The use of xVelocity, yVelocity, and aVelocity is as per the instructions.

World Rotation: The InteractionModel handles the world rotation, and it's updated in the 
handleAnimationTick method of SpaceController.

Part 3: Multiple Views
Miniature and Cursor Views: created additional views (miniatureView and cursorView) and added 
them to a panel in the UI. The implementation of these views appears to follow the requirements.

Control Panel View: The control panel with a slider and checkboxes to control world rotation and 
asteroid dynamics is correctly implemented.

Part 4: Selection and Interaction
Asteroid Selection: my current code does not have proper selection logic or event handling for mouse 
interactions. 

Everything until the end of part 3 is completely implemented according to the rquirements mentioned 
in the assignment text.
The code runs without any errors.
