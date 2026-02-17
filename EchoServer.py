# A dummy echo TCP server


#Import the module
from socket import *

#Create a socket
echoserver = socket(AF_INET, SOCK_STREAM)
echoserver.setsockopt(SOL_SOCKET, SO_REUSEADDR, 1)

# Bind socket with address and port
port = 2103
echoserver.bind(('localhost',port))

#Listen to the port
echoserver.listen(1)
print("Echo server is waiting")

#waiting for the connnection forever


#accept an connection
connection, address = echoserver.accept()
message = "start.."
while message !='quit':
    data = connection.recv(1024)   
    message =data.decode('utf-8')
    print("message from client: ", message)
    messageBack ="Echo message: " + message.upper()+"\n"
    connection.send(bytes(messageBack,'utf-8'))

connection.close()
echoserver.close()    
    
