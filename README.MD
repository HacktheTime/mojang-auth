This project is NOT affiliated with Mojang in any way. I wasn't able to find a very nice explanation which is why I created this example repository.

The Clientside code is an example and the Minecraft Sources will obviously not work here since they are not imported and I feel like that would be overkill. So ignore if Minecraft Client is highlighted red. I did in fact test the 
code and provided 1.20.2 fabric and 1.8.9 forge code. 
**THE SERVER SIDE NEEDS NO MINECRAFT SOURCES! (All done with apache http library)**

How it works:

a server id needs to be determined. You do it either way. Meet in the middle or one side sets it hardly. A middle with random on both sides is the securest (to my knowledge). not doing it that way could mean some security issues. 

**Server side sets it**: someone could log in to Hypixel and use your join request to validate that they would be you (if hypixel makes them a challenge with their side setting the id → you get told to log in there)

**Client only**: someone who would know the server id could say here is the id and login into the server as you.

if both create something random they can tell each other theirs and combine it to an id. the client then uses the id and the server requests with that id. (example: client random+server random)



The Client than goes to mojang with that server id as well as the access token **(WHICH IS PRIVATE AND YOU SHOULD NEVER SHARE!)** that you want to log in to the Server with that id.

Client then goes in and tells the server they want to connect to the server. Then the server checks the server id (which was determined see above for what best) The server also needs to know the MC Username (case-sensitive)

The Sever then goes too mojang and asks via an url hey do you certify that that username wants to connect to that server id? The server is told and the verify method returns true otherwise false. Optionally an ip can be given which makes it so the mojang also tells you that they connected with that id to them as well.

Sources:
(minecraft related btw ↓)
https://wiki.vg/Protocol_Encryption

Thanks to hannibal2 for support for finding the sources. great help


License:
You may do whatever you like with this code with the exception that you say you made it yourself. You do not need to give credit to this project in any way.
You may call a project which was made by you your own work (if as a whole) even when you used this as source.