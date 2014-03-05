'''
Created on Feb 22, 2014

@author: evil
'''
import pdb,logging
# logging.basicConfig(level=logging.DEBUG,
#                 format='%(asctime)s %(filename)s[line:%(lineno)d] %(levelname)s %(message)s',
#                 datefmt='%a, %d %b %Y %H:%M:%S',
#                 filename='myapp.log',
#                 filemode='w')
# logging.debug("abcd");
import threading
import time
class timer(threading.Thread):
    def __init__(self,num,interval):
        threading.Thread.__init__(self)
        self.thread_num=num
        self.interval=interval
        self.thread_stop=False
    def run(self):
        while not self.thread_stop:
            print('Thread %d,Time %s'%(self.thread_num,time.ctime(20)))
            time.sleep(self.interval)
    def stop(self):
        self.thread_stop=True

def test():
    thread1=timer(1,1)
    thread2=timer(2,2)
    thread1.start()
    thread2.start()
    time.sleep(10)
    thread1.stop()
    thread2.stop()
    return
if __name__=='__main__':
    test()
            
        
