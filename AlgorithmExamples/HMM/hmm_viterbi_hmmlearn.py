#coding=utf-8
from __future__ import division
import numpy as np
from hmmlearn import hmm

'''
Consider two friends, Alice and Bob, who live far apart from each other
and who talk together daily over the telephone about what they did that day.

Bob is only interested in three activities: walking in the park, shopping, 
and cleaning his apartment. The choice of what to do is determined 
exclusively by the weather on a given day. 

Alice has no definite information about the weather where Bob lives, 
but she knows general trends. Based on what Bob tells her he did each day, 
Alice tries to guess what the weather must have been like.

Alice believes that the weather operates as a discrete Markov chain. 
There are two states, "Rainy" and "Sunny", but she cannot observe them 
directly, that is, they are hidden from her. 

On each day, there is a certain chance that Bob will perform one of 
the following activities, depending on the weather: "walk", "shop", or
"clean". 

Since Bob tells Alice about his activities, those are the observations. 
The entire system is that of a hidden Markov model (HMM).

Alice knows the general weather trends in the area, and what Bob likes 
to do on average. In other words, the parameters of the HMM are known.

- start_probability:
represents Alice's belief about which state the HMM is in when Bob first 
calls her (all she knows is that it tends to be rainy on average). 
The particular probability distribution used here is not 
the equilibrium one, which is (given the transition probabilities) 
approximately {'Rainy': 0.57, 'Sunny': 0.43}. 

- transition_probability 
represents the change of the weather in the underlying Markov chain. 
In this example, there is only a 0.3 chance that tomorrow will be sunny 
if today is rainy. 

- emission_probability
represents how likely Bob is to perform a certain activity on each day. 
If it is rainy, there is a 0.5 chance that he is cleaning his apartment; 
if it is sunny, there is a 0.6 chance that he is outside for a walk.

observation: (0, 2, 1, 1, 2, 0)
Alice talks to Bob six days in a row and discovers that on the first day 
he went for a walk, on the second day he cleaned his apartment, on the 
third and fourth days he went shopping, on the fifth day he cleaned 
his apartment, and on the sixth day he went for a walk.

Alice's question: 
what is the most likely sequence of rainy/sunny days that would explain 
these observations? 

Answer:
This is answered by the Viterbi algorithm.
'''

states = ["Rainy", "Sunny"]
n_states = len(states)

observations = ["walk", "shop", "clean"]
n_observations = len(observations)

start_probability = np.array([0.6, 0.4])

transition_probability = np.array([
  [0.7, 0.3],
  [0.4, 0.6]
])

emission_probability = np.array([
  [0.1, 0.4, 0.5],
  [0.6, 0.3, 0.1]
])

randNum = None
model = hmm.MultinomialHMM(n_components=n_states, random_state=randNum)
model.startprob_=start_probability
model.transmat_=transition_probability
model.emissionprob_ = emission_probability

# predict a sequence of hidden states based on visible states
# predict weather based on what bob has said
bob_says = np.array([[0, 2, 1, 1, 2, 0]]).T
model.fit(bob_says)
# Find most likely state sequence corresponding to X.
logprob, alice_hears = model.decode(bob_says, algorithm="viterbi")

print "Bob says:", ", ".join(map(lambda x: observations[x], bob_says))
print "Alice hears:", ", ".join(map(lambda x: states[x], alice_hears))

# print "\ndecode output:"
# print alice_hears
# print logprob

# aaa = model.predict(bob_says)
# print '\npredict output:'
# print aaa

# # Compute the log probability under the model.
# sss = model.score(bob_says)
# print '\nscore output:'
# print sss

# # Compute the posterior probability for each state in the model.
# ppp = model.predict_proba(bob_says)
# print '\npredict_proba output:'
# print ppp
