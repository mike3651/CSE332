Annie Lace && Michael Wilson
1328572 1242639
lacea mike365
CSE 373
5.26.15


1)Describe the worst-case asymptotic running times of your methods adjacentVertices, edgeCost, and shortestPath. In your answers, use |E| for the number of edges and |V| for the number of vertices. Explain and justify your answers.

For adjacentVertices the worst case run time is O|E|. This is the case because it is entirely possible that one vertex could be connected to all the vertices and all of the edges could just so happen to come from that one vertex.

In terms of the worst run time for the edgeCost method, the run time is O|E|. This is because we might have to look through all of the edges and still fail to find an edge cost.

In terms of finding the shortestPath the worst-case asymptotic run time is O|V^2|. This is the worst case because we are continuously searching through the number of possible unknown vertices and while were are doing that we are finding all of the possible outgoing edges of each vertex.

2) Describe how you tested your code.
	For testing the code we created several different files to test non existent directed edge cases and non existent paths. We tested to see that our shortestPath method would find the shortest edge from a vertex and never return to that vertex. We also tested the adjacentVertices and edgeCost methods to make sure that our adjacentVertices and edgeCost methods returned the expected results. 


3) If you worked with a partner,
a) Describe the process you used for developing and testing your code. If you divided it, describe that. If you did everything together, describe the actual process used (eg. how long you talked about what, what order you wrote and tested, and how long it took). 
	Annie and Mike both discussed matters of Djikstra's method for several hours spread over the course of multiple days, reviewing lecture slides and information that we obtained from the help sessions. The first thing we started on was the shortestPath method, which Annie completed, and then Annie worked on the adjacentVertices and edgeCost methods. Mike then wrote a specialized print method, to print off the short lines of code that were used to print off the directed graphs, and then the print method for the shortestPath in the FindPaths class.

 	This whole assignment took several hours to complete. The estimated work time is 6 hours.

 	We worked together on the write-up.
b) Describe each group member's contributions/responsibilities in the project. 
	Annie created multiple text files of different graphing scenarios. The test graph was similar to the second example of the graph introduction slide, without the connection from node B to node A or from C to D. Annie also created two additional graphs that were used for the extra credit.
 	
 	Mike and Annie collaborated to create one vertex & edge text file to test the case where you have a central node that only has edges coming out of it but not going back into it. Each outer node has one edge, that is coming into it, from the central node.


c) Describe at least one good thing and one bad thing about the process of working together.
	A good thing from this process would have to be the experience of collaborating with another person to get a different approach on how to go about certain coding problems. The one bad thing was trying to debug without any real visualization of the graph.

4) If you did any above-and-beyond, describe what you did.

	Annie used a street scramble scavenger hunt map, a real world data set. She used the checkpoints as vertices and used the each block as a marker for 1 unit of distance. The shortestPath represents the shortest distance between two checkpoints.

	Annie and Mike worked on the minimum spanning tree method together.
