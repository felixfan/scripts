def isPalindrom(s):
	def toChars(s):
		s = s.lower()
		ans = ''
		for c in s:
			if c.isalpha():
				ans += c
	def isPal(s):
		if len(s) <= 1:
			return True
		else:
			return s[0]==s[-1] and isPal[1:-1]