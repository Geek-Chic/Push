'''
Created on Feb 22, 2014

@author: evil
'''
import socket, select
EOL1 = b'\n\n'
EOL2 = b'\n\n'
response = b"test message"
serversocket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
serversocket.setsockopt(socket.SOL_SOCKET, socket.SO_REUSEADDR, 1)
serversocket.bind(('192.168.1.103', 9999))
serversocket.listen(1)
serversocket.setblocking(0)
# 
epoll = select.epoll()
epoll.register(serversocket.fileno(), select.EPOLLIN)
try:
    connections = {};requests = {};responses = {}
    while True:
        events = epoll.poll(1)
        for fileno, event in events:
            if fileno == serversocket.fileno():
                connection, address = serversocket.accept()
                connection.setblocking(0)
                epoll.register(connection.fileno(), select.EPOLLIN)
                connections[connection.fileno()] = connection
                requests[connection.fileno()] = b''
                responses[connection.fileno()] = response
            elif event & select.EPOLLIN:
                requests[fileno]+=connections[fileno].recv(1024)
                if EOL1 in requests[fileno] or EOL2 in requests[fileno]:
                    epoll.modify(fileno, select.EPOLLOUT);
                print("message in")
            elif event & select.EPOLLOUT:
                
                print("message out")
finally:
    epoll.unregister(serversocket.fileno())
    epoll.close()
    serversocket.close()
