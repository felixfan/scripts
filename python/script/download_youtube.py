#coding=utf-8

'''
youtube-dl: https://rg3.github.io/youtube-dl/
mac: brew install youtube-dl

pip install pytube
'''

import sys
from pytube import YouTube

def get_vedio(link, res='360p', ddir="."):
    yt = YouTube(link)
    video = yt.get('mp4', res)
    video.download(ddir)

if __name__ == '__main__':
    if len(sys.argv) < 2:
        sys.exit('usage:\npython {} link ["360p"] ["/Users/yourname/yourdir"]'.format(sys.argv[0]))
    elif len(sys.argv) == 2:
        get_vedio(sys.argv[1])
    elif len(sys.argv) == 3:
        get_vedio(sys.argv[1], sys.argv[2])
    elif len(sys.argv) == 4:
        get_vedio(sys.argv[1], sys.argv[2], sys.argv[3])
    else:
        sys.exit('usage:\npython {} link ["360p"] ["/Users/yourname/yourdir"]'.format(sys.argv[0]))
