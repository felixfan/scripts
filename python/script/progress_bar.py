import time
import sys

# method 1
i, n = 0, 100
for i in range(n):
    time.sleep(0.1)
    if (i+1) % 10 == 0:
        print '{}\r'.format(i+1)

# method 2
def progress_bar(num, total):
    rate = float(num) / total
    ratenum = int(100 * rate)
    r = '\r[{}{}]{}%'.format('*' * ratenum, ' ' * (100-ratenum), ratenum)
    sys.stdout.write(r)
    sys.stdout.flush()

i, n = 0, 100
for i in range(n):
    time.sleep(0.1)
    progress_bar(i+1, n)
