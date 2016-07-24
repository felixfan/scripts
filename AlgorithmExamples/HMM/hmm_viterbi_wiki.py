#coding=utf-8

# example code from https://en.wikipedia.org/wiki/Viterbi_algorithm

'''
Consider a village where all villagers are either healthy or have a fever 
and only the village doctor can determine whether each has a fever. 

The doctor diagnoses fever by asking patients how they feel. 
The villagers may only answer that they feel normal, dizzy, or cold.

The doctor believes that the health condition of his patients 
operate as a discrete Markov chain. There are two states, 
"Healthy" and "Fever", but the doctor cannot observe them directly, 
they are hidden from him. 

On each day, there is a certain chance that the patient will tell
the doctor he/she is "normal", "cold", or "dizzy", depending on her health condition.

- start_probability
represents the doctor's belief about which state the HMM is in 
when the patient first visits (all he knows is that the patient tends to be healthy). 
The particular probability distribution used here is not the equilibrium one, 
which is (given the transition probabilities) approximately {'Healthy': 0.57, 'Fever': 0.43}. 

- transition_probability
represents the change of the health condition in the underlying Markov chain. 
In this example, there is only a 0.3 chance that tomorrow the patient will 
have a fever if he is healthy today.

- emission_probability
represents how likely the patient is to feel on each day. 
If he is healthy, there is a 0.5 chance that he feels normal; 
if he has a fever, there is a 0.6 chance that he feels dizzy.

- observations 
('normal', 'cold', 'dizzy')

- question
what is the hidden state for the observations?
'''

def viterbi(obs, states, start_p, trans_p, emit_p):
	V = [{}]
	path = {}

	# Initialize base cases (t == 0)
	for y in states:
		V[0][y] = start_p[y] * emit_p[y][obs[0]]
		path[y] = [y]

	# Run Viterbi when t > 0
	for t in range(1, len(obs)):
		V.append({})
		newpath = {}

		for y in states:
			(prob, state) = max([(V[t-1][y0] * trans_p[y0][y] * emit_p[y][obs[t]], y0) for y0 in states])
			V[t][y] = prob
			newpath[y] = path[state] + [y]

		# Don't need to remember the old paths
		path = newpath

	(prob, state) = max([(V[len(obs) - 1][y], y) for y in states])

	print "{:>7s}{}".format('index', ':'),
	for i in range(len(V)): print "{:>7d}".format(i),
	print

	print "{:>7s}{}".format('observ', ':'),
	for s in observations:
		print '{:>7s}'.format(s),
	print
	print

	for y in V[0].keys():
		print '{:>7}{}'.format(y,':'),
		for t in range(len(V)):
			print '{:.5f}'.format(V[t][y]),
		print
	print

	print "{:>7s}{}".format('state', ':'),
	for s in path[state]:
		print '{:>7s}'.format(s),
	print


if __name__ == "__main__":

	states = ('Healthy', 'Fever')

	observations = ('normal', 'cold', 'dizzy')

	start_probability = {'Healthy': 0.6, 'Fever': 0.4}

	transition_probability = {
		'Healthy' : {'Healthy': 0.7, 'Fever': 0.3},
		'Fever' : {'Healthy': 0.4, 'Fever': 0.6}
		}

	emission_probability = {
		'Healthy': {'normal': 0.5, 'cold': 0.4, 'dizzy': 0.1},
		'Fever': {'normal': 0.1, 'cold': 0.3, 'dizzy': 0.6}
		}
	
	viterbi(
		observations,
		states,
		start_probability,
		transition_probability,
		emission_probability)
