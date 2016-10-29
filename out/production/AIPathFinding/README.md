# AIPathFinding

Inspired by the potential real world applications of the A* search algorithm,
our group decided to create something that would tackle a very pressing 
issue all students face: getting to class as soon as possible. Our pathfinder 
uses a 2d tile map copied from American University's own layout. To infer 
the traversal time of each tile, we either assigned each tile as grass, road, 
sidewalk, or building - each with their own inherent costs - and applied the 
A* algorithm on the map. We used Java to code the algorithms and JavaFX 
to create a GUI for the application that depicts a map of campus and the 
route one should take highligthed in red.
