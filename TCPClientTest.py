#Import the module
from socket import *

#Create a socket
chatclient = socket(AF_INET, SOCK_STREAM)

#Connect to a server
serverName = "172.17.137.71"
serverPort = 2766
chatclient.connect((serverName,serverPort))

#communication


#send
helomessage = raw_input("Enter your chat message")
chatclient.send(helomessage)

#receive
message = chatclient.recv(1024)
print message


#close
chatclient.close()





