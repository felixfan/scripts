# Mini-project #6 - Blackjack
try:
    import simplegui
except:
	import SimpleGUICS2Pygame.simpleguics2pygame as simplegui

import random

# load card sprite - 936x384 - source: jfitz.com
CARD_SIZE = (72, 96)
CARD_CENTER = (36, 48)
card_images = simplegui.load_image("http://storage.googleapis.com/codeskulptor-assets/cards_jfitz.png")

CARD_BACK_SIZE = (72, 96)
CARD_BACK_CENTER = (36, 48)
card_back = simplegui.load_image("http://storage.googleapis.com/codeskulptor-assets/card_jfitz_back.png")    

# initialize some useful global variables
in_play = False
outcome = ""
message = ""
score = 0
deck = []
dealer = []
player = []

# define globals for cards
SUITS = ('C', 'S', 'H', 'D')
RANKS = ('A', '2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K')
VALUES = {'A':1, '2':2, '3':3, '4':4, '5':5, '6':6, '7':7, '8':8, '9':9, 'T':10, 'J':10, 'Q':10, 'K':10}

# define card class
class Card:
    def __init__(self, suit, rank):
        if (suit in SUITS) and (rank in RANKS):
            self.suit = suit
            self.rank = rank
        else:
            self.suit = None
            self.rank = None
            print "Invalid card: ", suit, rank

    def __str__(self):
        return self.suit + self.rank

    def get_suit(self):
        return self.suit

    def get_rank(self):
        return self.rank

    def draw(self, canvas, pos):
        card_loc = (CARD_CENTER[0] + CARD_SIZE[0] * RANKS.index(self.rank), 
                    CARD_CENTER[1] + CARD_SIZE[1] * SUITS.index(self.suit))
        canvas.draw_image(card_images, card_loc, CARD_SIZE, [pos[0] + CARD_CENTER[0], pos[1] + CARD_CENTER[1]], CARD_SIZE)
        
# define hand class
class Hand:
    def __init__(self):
        self.cards = []

    def __str__(self):
        s = 'Hand contains'
        for card in self.cards:
            s += ' ' + str(card)
        return s

    def add_card(self, card):
        self.cards.append(card)
        return self.cards

    def get_value(self):
        # count aces as 1, if the hand has an ace, then add 10 to hand value if it doesn't bust
        # compute the value of the hand, see Blackjack video
        value = 0
        flag = 0
        for card in self.cards:
            rank = card.get_rank()
            if rank == 'A':
                flag = 1
            value += VALUES[rank]
        if flag==1 and value <=11:
            value += 10
        return value
   
    def draw(self, canvas, pos):
        for card in self.cards:
            card.draw(canvas, pos)
            pos[0] += CARD_SIZE[0]
        if in_play == True:
            canvas.draw_image(card_back, CARD_BACK_CENTER, CARD_BACK_SIZE,[CARD_BACK_CENTER[0]+150,CARD_BACK_CENTER[1]+350] , CARD_BACK_SIZE)
                  
# define deck class 
class Deck:
    def __init__(self):
        cards=[]
        for suit in SUITS:
            for rank in RANKS:
                cards.append(Card(suit, rank))
        self.cards = cards

    def shuffle(self):
        random.shuffle(self.cards)

    def deal_card(self):
        return self.cards.pop()
    
    def __str__(self):
        s = 'Deck contains'
        for card in self.cards:
            s += ' ' + str(card)
        return s

#define event handlers for buttons
def deal():
    global outcome,message, in_play, deck, player, dealer, score
    if in_play == True:
        score -= 1
    deck = Deck()
    deck.shuffle()
    player = Hand()
    dealer = Hand()
    player.add_card(deck.deal_card())
    player.add_card(deck.deal_card())
    dealer.add_card(deck.deal_card())
    dealer.add_card(deck.deal_card())
    in_play = True
    outcome = "Hit or stand?"
    message = ""
    
def hit():
    global in_play, score, outcome, player, deck, message
    if in_play == True:
        if player.get_value() <= 21:
            player.add_card(deck.deal_card())
        if player.get_value() > 21:
            outcome = "New deal?"
            message = "You have busted"
            in_play = False
            score -= 1
       
def stand():
    global in_play, score, outcome, message, dealer, deck
    if in_play == True:
        while dealer.get_value() < 17:
            dealer.add_card(deck.deal_card())
        if dealer.get_value() > 21:
            score += 1
            message = "Dealer has busted, you win!"
        elif dealer.get_value() >= player.get_value():
            score -= 1
            message = "You lose!"
        elif dealer.get_value() < player.get_value():
            score += 1
            message = "You win!"
        in_play = False
        outcome = "New deal?"

# draw handler    
def draw(canvas):  
    canvas.draw_text("Blackjack", [250,100], 40, "Black")
    canvas.draw_text("Score: " + str(score), [250,150], 40, "Red")
    canvas.draw_text("Player:", [10,250], 40, "Black")
    canvas.draw_text("Dealer:", [10,400], 40, "Black")
    player.draw(canvas,[150,200])
    dealer.draw(canvas,[150,350])
    canvas.draw_text(message, [30,500], 30, "White")
    canvas.draw_text(outcome, [30,550], 30, "White")

# initialization frame
frame = simplegui.create_frame("Blackjack", 600, 600)
frame.set_canvas_background("Green")

#create buttons and canvas callback
frame.add_button("Deal", deal, 200)
frame.add_button("Hit",  hit, 200)
frame.add_button("Stand", stand, 200)
frame.set_draw_handler(draw)

# get things rolling
deal()
frame.start()
