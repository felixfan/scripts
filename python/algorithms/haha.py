import random
import sys

def encode(input, p):
	es = []
	p1 = p + 3
	p2 = p + 9
	for s in input:
		tmp = 0
		if s.isalpha():
			if s.isupper():
				tmp = ord(s) + p
				while tmp > 90:
					tmp -= 26
			if s.islower():
				tmp = ord(s) + p1
				while tmp > 122:
					tmp -= 26
		elif s.isdigit():
			tmp = ord(s) + p2
			while tmp > 57:
				tmp -= 10
		else:
			if not s in spec:
				sys.exit('{} is not allowed!'.format(s))
			else:
				idx = spec.index(s)
				idx += p
				while idx > 4:
					idx -= 4
				tmp = ord(spec[idx])
		es.append(chr(tmp))
	ans = ''.join(es)
	return ans

def decode(input, p):
	es = []
	p1 = p + 3
	p2 = p + 9
	for s in input:
		tmp = 0
		if s.isalpha():
			if s.isupper():
				tmp = ord(s) - p
				while tmp < 65:
					tmp += 26
			if s.islower():
				tmp = ord(s) - p1
				while tmp < 97:
					tmp += 26
		elif s.isdigit():
			tmp = ord(s) - p2
			while tmp < 48:
				tmp += 10
		else:
			if not s in spec:
				sys.exit('{} is not allowed!'.format(s))
			else:
				idx = spec.index(s)
				idx -= p
				while idx < 0:
					idx += 4
				tmp = ord(spec[idx])
		es.append(chr(tmp))
	ans = ''.join(es)
	return ans

####################
if len(sys.argv) < 4:
	sys.exit('usage:\npython haha.py seed input encode\n')

seed = sys.argv[1]
if seed != 'None':
	seed = int(seed)
else:
	seed =None

instr = sys.argv[2]

com = sys.argv[3]

spec = ['#', '@', '=', '?', '$']

random.seed(seed)
p = random.randint(1, 100)

if com == 'encode':
	print encode(instr, p)
elif com == 'decode':
	print decode(instr, p)
else:
	sys.exit('last param can be encode or decode only')
