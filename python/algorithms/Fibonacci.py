def fibonacci(x):
	assert type(x)==int and x >= 0
	if x == 0 or x == 1:
		return 1
	else:
		return fibonacci(x-1) + fibonacci(x-2)
