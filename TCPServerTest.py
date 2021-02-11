# A dummy echo TCP server


#Import the module
from socket import *

#Create a socket

echoserver = socket(AF_INET, SOCK_STREAM)

# Bind socket with address and port

port = 2766
echoserver.bind(('172.17.137.71',port))

#Listen to the port
echoserver.listen(1)
print " Echo server is waiting"

count = 0
while count < 10:
    #waiting for the connnection for ever
    #accept an connection

    connection, address = echoserver.accept()
    print "I receive a connection from ", "address"

    message = connection.recv(1024)
    #get the file name

    filename =....

    #open the file
    try:
        f = open(filename,'r')
    except IOError:
        message = "HTTP/1.1 404 Not Found\r\n........"
        connection.send(message)
    else:
        message="HTTP/1.1 200 OK\r\nContent-Type: text/html\r\n\r\n"

        
    print "message from client: ", message
    #message ="Echo message: " + message.upper()
    #message = "HTTP/1.1 200 OK\r\nContent-Type: text/html\r\n\r\n<html><body>hihi</body></html>"
    connection.send(message)

    #close all connections
    connection.close()
    count = count + 1


echoserver.close()    





    
